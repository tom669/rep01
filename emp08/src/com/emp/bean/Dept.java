package com.emp.bean;

//部门实体类
public class Dept {
	private String deptno;// 部门编号
	private String dname;// 部门名称
	private String location;// 部门地址

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(String deptno, String dname, String location) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
