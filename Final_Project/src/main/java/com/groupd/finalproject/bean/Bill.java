package com.groupd.finalproject.bean;

public class Bill {
	private String BillerName;
	private String BillerAcctNo;
	private String Amt;
	private String CustomerId;

	public String getBillerName() {
		return BillerName;
	}
	public void setBillerName(String billerName) {
		BillerName = billerName;
	}
	public String getBillerAcctNo() {
		return BillerAcctNo;
	}
	public void setBillerAcctNo(String billerAcctNo) {
		BillerAcctNo = billerAcctNo;
	}
	public String getAmt() {
		return Amt;
	}
	public void setAmt(String amt) {
		Amt = amt;
	}
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

}
