package com.demo.struts2.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.Address;
import com.demo.hibernate.dao.AddressDAO;
import com.demo.hibernate.dao.AddressDAOImpl;
import com.demo.hibernate.service.AddressService;
import com.demo.hibernate.service.AddressServiceImpl;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.hibernate.util.Pager;
import com.demo.struts2.util.RegExpression;

public class AddressAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private AddressServiceImpl addressService;

	public AddressAction() {
		super();
		if (addressService == null) {
			addressService = new AddressServiceImpl();
			AddressDAO addressDAO = new AddressDAOImpl();
			addressService.setAddressDAO(addressDAO);
		}
	}

	protected String id = null;

	protected String username = null;

	protected String name = null;

	protected String sex = null;

	protected String mobile = null;

	protected String email = null;

	protected String qq = null;

	protected String company = null;

	protected String address = null;

	protected String postcode = null;

	public void validate() {
		clearErrorsAndMessages();

		String queryString = getRequestPath();
		if (queryString.indexOf("addressadd!insert") != -1 || queryString.indexOf("addressedit!update") != -1) {
			if (name == null || name.equals("")) {
				addFieldError("name", getText("address.error.name"));
			}

			if (mobile != null && !mobile.equals("")) {
				Pattern p_mobile = Pattern.compile(RegExpression.REG_mobile);
				Matcher m_mobile = p_mobile.matcher(mobile);
				if (!m_mobile.find()) {
					addFieldError("mobile", getText("address.error.mobile"));
				}
			}

			if (email != null && !email.equals("")) {
				Pattern p_email = Pattern.compile(RegExpression.REG_email);
				Matcher m_email = p_email.matcher(email);
				if (!m_email.find()) {
					addFieldError("email", getText("address.error.email"));
				}
			}

			if (postcode != null && !postcode.equals("")) {
				Pattern p_postcode = Pattern.compile(RegExpression.REG_postcode);
				Matcher m_postcode = p_postcode.matcher(postcode);
				if (!m_postcode.find()) {
					addFieldError("postcode", getText("address.error.postcode"));
				}
			}
		}
	}

	public String init() throws Exception {
		clearErrorsAndMessages();

		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		super.pager = this.getAddressService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_ADDRESS, super.pager);

		return Constants.LIST_KEY;
	}

	public String list() throws Exception {
		clearErrorsAndMessages();

		super.pager = this.getAddressService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		setSession(Constants.PAGER_ADDRESS, super.pager);

		return Constants.LIST_KEY;
	}

	public String add() throws Exception {
		clearErrorsAndMessages();

		reset();
		return Constants.ADD_KEY;
	}

	private void reset() {
		setId(null);
		setUsername(null);
		setName(null);
		setSex(null);
		setMobile(null);
		setEmail(null);
		setQq(null);
		setCompany(null);
		setAddress(null);
		setPostcode(null);
	}

	private void bean2Form(Address address) {
		setId(address.getId().toString());
		setUsername(address.getUsername());
		setName(address.getName());
		setSex(address.getSex());
		setMobile(address.getMobile());
		setEmail(address.getEmail());
		setQq(address.getQq());
		setCompany(address.getCompany());
		setAddress(address.getAddress());
		setPostcode(address.getPostcode());
	}

	public String edit() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("address.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			Address address = this.getAddressService().select(Integer.valueOf(id));

			if (address == null) {
				saveActionError("address.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				bean2Form(address);
				return Constants.EDIT_KEY;
			}
		}
	}

	public String insert() throws Exception {
		clearErrorsAndMessages();

		Address address = new Address();
		address.setUsername(super.getLoginUsername());
		address.setName(this.getName());
		address.setSex(this.getSex());
		address.setMobile(this.getMobile());
		address.setEmail(this.getEmail());
		address.setQq(this.getQq());
		address.setCompany(this.getCompany());
		address.setAddress(this.getAddress());
		address.setPostcode(this.getPostcode());
		Integer nid = this.getAddressService().insert(address);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_ADDRESS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getAddressService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		if (nid != null) {
			saveActionMessage("address.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("address.message.add.failed");
			return Constants.ADD_KEY;
		}

	}

	public String update() throws Exception {
		clearErrorsAndMessages();

		Address address = new Address();
		address.setId(new Integer(id));
		address.setUsername(super.getLoginUsername());
		address.setName(this.getName());
		address.setSex(this.getSex());
		address.setMobile(this.getMobile());
		address.setEmail(this.getEmail());
		address.setQq(this.getQq());
		address.setCompany(this.getCompany());
		address.setAddress(this.getAddress());
		address.setPostcode(this.getPostcode());
		this.getAddressService().update(address);

		bean2Form(address);

		Pager pagerSession = (Pager) getSession(Constants.PAGER_ADDRESS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		super.pager = this.getAddressService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("address.message.edit.success");
		return Constants.LIST_KEY;

	}

	public String delete() throws Exception {
		clearErrorsAndMessages();

		if (this.getId() == null) {
			saveActionError("address.message.edit.notexist");
		} else {
			this.getAddressService().delete(Integer.valueOf(id));
			saveActionMessage("address.message.delete.success");
		}
		super.pager = this.getAddressService().list(super.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressServiceImpl addressService) {
		this.addressService = addressService;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
