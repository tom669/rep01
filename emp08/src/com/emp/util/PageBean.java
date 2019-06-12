package com.emp.util;

import java.util.List;

public class PageBean<T>{ //T���ͣ�ָ�������������
	//��ʹ��PageBean�ĳ���Ա����
	private int pageNo=1;//��ǰҳ
	private int pageSize  =4;//ҳ������һҳ�ж�������¼
	private int count;//���ڷ�ҳ�Ĳ�ѯ,һ�����Բ����������¼
	//����в�ѯ��������ô���������������Բ����������¼
	//����Ա������ϵͳT ����Emp
	private List<T> list;//һҳ������
	//��������,ҳ����������
	private String condition;
	
	
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	//��ȡ��ҳ���ķ���
	//��jspҳ��ͨ��el���ʽ����������� ${pageBean����.totalPage}
	public int getTotalPage(){
		int totalPage = count%pageSize==0?count/pageSize:count/pageSize+1;
		return totalPage;
	}
	//��һҳ  ${pageBean����.previous}
	public int getPrevious(){
		int prev = pageNo>1?pageNo-1:1;
		return prev;
	}
	//��һҳ  ${pageBean����.next}
	public int getNext(){
		 int next = pageNo<getTotalPage()?pageNo+1:getTotalPage();
		 return next;
	}
	//��ҳ
    public int getFirst(){
    	return 1;
    }
	//βҳ ${pageBean.last}
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
