package com.demo.ibatis.util;

import java.util.ArrayList;
import java.util.List;

public class Pager {

	protected int[] pageSizeList = { 10, 25, 50, 100, 200, 300, 500 };

	protected int pageSize = 25;

	protected int pageNo = 1;

	protected int rowCount = 0;

	protected int pageCount = 1;

	protected int startIndex = 1;

	protected int endIndex = 1;

	protected int firstPageNo = 1;
	protected int prePageNo = 1;
	protected int nextPageNo = 1;
	protected int lastPageNo = 1;

	protected List<?> resultList;

	public Pager(int pageSize, int pageNo, int rowCount, List<?> resultList) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.rowCount = rowCount;
		this.resultList = resultList;

		if (rowCount % pageSize == 0) {
			this.pageCount = rowCount / pageSize;
		} else {
			this.pageCount = rowCount / pageSize + 1;
		}
		this.startIndex = pageSize * (pageNo - 1);
		this.endIndex = this.startIndex + resultList.size();

		this.lastPageNo = this.pageCount;
		if (this.pageNo > 1)
			this.prePageNo = this.pageNo - 1;
		if (this.pageNo == this.lastPageNo) {
			this.nextPageNo = this.lastPageNo;
		} else {
			this.nextPageNo = this.pageNo + 1;
		}
	}

	public Object[] getPageSizeIndexs() {
		List<String> result = new ArrayList<String>(pageSizeList.length);
		for (int i = 0; i < pageSizeList.length; i++) {
			result.add(String.valueOf(pageSizeList[i]));
		}
		Object[] indexs = (result.toArray());
		return indexs;
	}

	public Object[] getPageNoIndexs() {
		List<String> result = new ArrayList<String>(pageCount);
		for (int i = 0; i < pageCount; i++) {
			result.add(String.valueOf(i + 1));
		}
		Object[] indexs = (result.toArray());
		return indexs;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int[] getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(int[] pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getLastPageNo() {
		return lastPageNo;
	}

	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getPrePageNo() {
		return prePageNo;
	}

	public void setPrePageNo(int prePageNo) {
		this.prePageNo = prePageNo;
	}

}
