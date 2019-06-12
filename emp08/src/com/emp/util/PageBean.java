package com.emp.util;

import java.util.List;

public class PageBean<T>{ //T泛型，指任意的引用类型
	//由使用PageBean的程序员决定
	private int pageNo=1;//当前页
	private int pageSize  =4;//页容量，一页有多少条记录
	private int count;//用于分页的查询,一共可以查出多少条记录
	//如果有查询条件，那么就是依据条件可以查出多少条记录
	//对于员工管理系统T 就是Emp
	private List<T> list;//一页的数据
	//条件属性,页面搜索条件
	private String condition;
	
	
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	//获取总页数的方法
	//在jsp页面通过el表达式调用这个方法 ${pageBean对象.totalPage}
	public int getTotalPage(){
		int totalPage = count%pageSize==0?count/pageSize:count/pageSize+1;
		return totalPage;
	}
	//上一页  ${pageBean对象.previous}
	public int getPrevious(){
		int prev = pageNo>1?pageNo-1:1;
		return prev;
	}
	//下一页  ${pageBean对象.next}
	public int getNext(){
		 int next = pageNo<getTotalPage()?pageNo+1:getTotalPage();
		 return next;
	}
	//首页
    public int getFirst(){
    	return 1;
    }
	//尾页 ${pageBean.last}
	public int getLast(){
		 return getTotalPage();
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	

}
