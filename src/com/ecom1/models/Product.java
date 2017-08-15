package com.ecom1.models;

import java.io.Serializable;

public class Product implements Serializable {
	private int productId;
	private String productName;
	private double productPrice;
	private String productCategory;
	private String productType;
	private String productGender;
	private String productSize;
	private String productColor;
	private String productDescription;
	private String productBrand;
	private String productImage;
	private Vendor vendor;
	
	public Product(Product p) {
		this.productId = p.productId;
		this.productName = p.productName;
		this.productPrice = p.productPrice;
		this.productCategory = p.productCategory;
		this.productType = p.productType;
		this.productGender = p.productGender;
		this.productSize = p.productSize;
		this.productColor = p.productColor;
		this.productDescription = p.productDescription;
		this.productBrand = p.productBrand;
		this.productImage = p.productImage;
		this.vendor = p.vendor;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, double productPrice,
			String productCategory, String productType, String productGender,
			String productSize, String productColor, String productDescription,
			String productBrand, String productImage, Vendor vendor) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productType = productType;
		this.productGender = productGender;
		this.productSize = productSize;
		this.productColor = productColor;
		this.productDescription = productDescription;
		this.productBrand = productBrand;
		this.productImage = productImage;
		this.vendor = vendor;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductGender() {
		return productGender;
	}
	public void setProductGender(String productGender) {
		this.productGender = productGender;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
}