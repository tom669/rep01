package com.emp.bean;

//��t_emp��Ľṹһ��
public class Emp {
	private String empno;// Ա�����
	private String ename;// ����
	private String esex;// �Ա�
	private Integer eage;// ����
	private Float esalary;// н��
	private String deptno;// ���ű��
	private String mgrno;// ������

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
