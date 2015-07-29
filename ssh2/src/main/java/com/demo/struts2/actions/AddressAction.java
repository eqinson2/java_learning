package com.demo.struts2.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.demo.hibernate.beans.Address;
import com.demo.hibernate.service.AddressService;
import com.demo.struts2.common.PageAction;
import com.demo.struts2.util.Constants;
import com.demo.hibernate.util.Pager;
import com.demo.struts2.util.RegExpression;

public class AddressAction extends PageAction {

	private static final long serialVersionUID = 1L;

	private AddressService addressService;

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

	// 新增或修改时执行表单验证
	public void validate() {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得请求参数
		String queryString = getRequestPath();
		if (queryString.indexOf("addressadd!insert") != -1
				|| queryString.indexOf("addressedit!update") != -1) {
			// 检查表单字段name
			if (name == null || name.equals("")) {
				addFieldError("name", getText("address.error.name"));
			}

			// 检查表单字段mobile
			if (mobile != null && !mobile.equals("")) {
				Pattern p_mobile = Pattern.compile(RegExpression.REG_mobile);
				Matcher m_mobile = p_mobile.matcher(mobile);
				if (!m_mobile.find()) {
					addFieldError("mobile", getText("address.error.mobile"));
				}
			}

			// 检查表单字段email
			if (email != null && !email.equals("")) {
				Pattern p_email = Pattern.compile(RegExpression.REG_email);
				Matcher m_email = p_email.matcher(email);
				if (!m_email.find()) {
					addFieldError("email", getText("address.error.email"));
				}
			}

			// 检查表单字段postcode
			if (postcode != null && !postcode.equals("")) {
				Pattern p_postcode = Pattern
						.compile(RegExpression.REG_postcode);
				Matcher m_postcode = p_postcode.matcher(postcode);
				if (!m_postcode.find()) {
					addFieldError("postcode", getText("address.error.postcode"));
				}
			}
		}
	}

	// 请求addressInit.do的处理函数
	public String init() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设分页参数
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;

		// 取得当前分页数据
		super.pager = this.getAddressService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_ADDRESS, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求addressList.do的处理函数
	public String list() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 取得当前分页数据
		super.pager = this.getAddressService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		// 保存分页数据
		setSession(Constants.PAGER_ADDRESS, super.pager);

		return Constants.LIST_KEY;
	}

	// 请求addressAdd.do的处理函数
	public String add() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 重设各表单字段
		reset();
		return Constants.ADD_KEY;
	}

	// 重设各表单字段
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

	// 给表单字段赋值
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

	// 请求addressEdit.do的处理函数
	public String edit() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("address.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// 查询数据表
			Address address = this.getAddressService().select(Integer.valueOf(id));

			// 不存在时返回错误
			if (address == null) {
				saveActionError("address.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// 给表单字段赋值
				bean2Form(address);
				return Constants.EDIT_KEY;
			}
		}
	}

	// 请求addressInsert.do的处理函数
	public String insert() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		
		// 插入数据表
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
		

		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_ADDRESS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getAddressService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		if (nid != null) {
			// 保存成功信息
			saveActionMessage("address.message.add.success");
			return Constants.LIST_KEY;
		} else {
			// 保存失败信息
			saveActionError("address.message.add.failed");
			return Constants.ADD_KEY;
		}

	}

	// 请求addressUpdate.do的处理函数
	public String update() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// 更新数据表
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

		// 给表单字段赋值
		bean2Form(address);
		
		// 取得缓存的分页参数
		Pager pagerSession = (Pager) getSession(Constants.PAGER_ADDRESS);
		super.pageSize = pagerSession.getPageSize();
		super.pageNo = pagerSession.getPageNo();

		// 查询当前页的数据
		super.pager = this.getAddressService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		saveActionMessage("address.message.edit.success");
		return Constants.LIST_KEY;

	}

	// 请求addressDelete.do的处理函数
	public String delete() throws Exception {
		// 清除错误消息
		clearErrorsAndMessages();

		// id为空时返回错误
		if (this.getId() == null) {
			saveActionError("address.message.edit.notexist");
		} else {
			// 删除数据
			this.getAddressService().delete(Integer.valueOf(id));
			saveActionMessage("address.message.delete.success");
		}
		// 取得当前页的数据
		super.pager = this.getAddressService().list(super
				.getLoginUsername(), super.pageSize, super.pageNo);

		return Constants.LIST_KEY;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
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
