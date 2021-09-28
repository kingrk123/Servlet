package com.nt.bo;

public class EmployeeBO {

	private int  empNo;
	 private  String empName;
	 private  String empAddrs;
	 private  String empDesg;
	 private  float  basicSalary;
	 private  float  grossSalary;
	 private  float  netSalary;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddrs() {
		return empAddrs;
	}
	public void setEmpAddrs(String empAddrs) {
		this.empAddrs = empAddrs;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	@Override
	public String toString() {
		return "EmployeeBO [empNo=" + empNo + ", empName=" + empName + ", empAddrs=" + empAddrs + ", empDesg=" + empDesg
				+ ", basicSalary=" + basicSalary + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
	}
	 
}
