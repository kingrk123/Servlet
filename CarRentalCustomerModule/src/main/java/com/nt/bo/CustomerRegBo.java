package com.nt.bo;

import java.sql.Date;

import lombok.Data;

@Data
public class CustomerRegBo {

	private String customerName ; 		
	private long landlineNo;
	private long mobileNo;		
	private String address;				
	private String passportNo;		
	private Date passportExpirydate;	
	private String drivingLicenseNo;		
	private String nationality;			
	private String refName;	 		
	private long refPhoneno;			
	private String jobDetails;			
	private String referBy;			
	private String premiumCustomer;  
	private Boolean permission;
	private String username;
	private String confirmPassword;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getLandlineNo() {
		return landlineNo;
	}
	public void setLandlineNo(long landlineNo) {
		this.landlineNo = landlineNo;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public Date getPassportExpirydate() {
		return passportExpirydate;
	}
	public void setPassportExpirydate(Date passportExpirydate) {
		this.passportExpirydate = passportExpirydate;
	}
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}
	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public long getRefPhoneno() {
		return refPhoneno;
	}
	public void setRefPhoneno(long refPhoneno) {
		this.refPhoneno = refPhoneno;
	}
	public String getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}
	public String getReferBy() {
		return referBy;
	}
	public void setReferBy(String referBy) {
		this.referBy = referBy;
	}
	public String getPremiumCustomer() {
		return premiumCustomer;
	}
	public void setPremiumCustomer(String premiumCustomer) {
		this.premiumCustomer = premiumCustomer;
	}
	public Boolean getPermission() {
		return permission;
	}
	public void setPermission(Boolean permission) {
		this.permission = permission;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
