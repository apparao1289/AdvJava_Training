package com.test.model;

import java.sql.Date;

public class Employee {

	private int id;

	private String name;

	private int deptNo;

	private String job;

	private int salary;

	private int commission;

	private Date hireDate;
	
	private int mgr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", deptNo=");
		builder.append(deptNo);
		builder.append(", job=");
		builder.append(job);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", commission=");
		builder.append(commission);
		builder.append(", hireDate=");
		builder.append(hireDate);
		builder.append("]");
		return builder.toString();
	}

}
