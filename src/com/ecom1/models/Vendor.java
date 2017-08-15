package com.ecom1.models;

import java.io.Serializable;
import java.util.Date;

public class Vendor implements Serializable{
	private int vendorId;
	private String vendorName;
	private String vendorEmail;
	private String vendorPhone;
	private String vendorPassword;
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Vendor(int vendorId, String vendorName, String vendorEmail,
			String vendorPhone, String vendorPassword) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorEmail = vendorEmail;
		this.vendorPhone = vendorPhone;
		this.vendorPassword = vendorPassword;
	}
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	
	public String getVendorPassword() {
		return vendorPassword;
	}
	public void setVendorPassword(String vendorPassword) {
		this.vendorPassword = vendorPassword;
	}

	
	
}
