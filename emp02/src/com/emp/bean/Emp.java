package com.emp.bean;

//与t_emp表的结构一致
public class Emp {
	private String empno;// 员工编号
	private String ename;// 姓名
	private String esex;// 性别
	private Integer eage;// 年龄
	private Float esalary;// 薪资
	private String deptno;// 部门编号
	private String mgrno;// 经理编号

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(String empno, String ename, String esex, Integer eage, Float esalary, String deptno, String mgrno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.esex = esex;
		this.eage = eage;
		this.esalary = esalary;
		this.deptno = deptno;
		this.mgrno = mgrno;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsex() {
		return esex;
	}

	public void setEsex(String esex) {
		this.esex = esex;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public Float getEsalary() {
		return esalary;
	}

	public void setEsalary(Float esalary) {
		this.esalary = esalary;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getMgrno() {
		return mgrno;
	}

	public void setMgrno(String mgrno) {
		this.mgrno = mgrno;
	}

}
