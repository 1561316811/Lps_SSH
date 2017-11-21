package com.lps.util;

import java.util.List;

/**
 * @author 0001
 *
 * @param <T>
 */
public class PageBean<T> {

	private long page;// 当前页数
	
	private long allCount;// 总记录数
	
	private long allPage;// 总页数(总记录数/每页记录数)
	
	private long limit;// 每页记录数
	
	private List<T> list ;// 包含的集合

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getAllCount() {
		return allCount;
	}

	public void setAllCount(long allCount) {
		this.allCount = allCount;
	}

	public long getAllPage() {
		return allPage;
	}

	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}


}
