package com.ecom1.models;

import java.io.Serializable;

public class OrderProducts implements Serializable
{
private int orderProductsId;
private Order orderId;
private Product productId;
private int productQuantity;

public int getOrderProductsId() {
	return orderProductsId;
}
public void setOrderProductsId(int orderProductsId) {
	this.orderProductsId = orderProductsId;
}
public Order getOrderId() {
	return orderId;
}
public void setOrderId(Order orderId) {
	this.orderId = orderId;
}
public Product getProductId() {
	return productId;
}
public void setProductId(Product productId) {
	this.productId = productId;
}
public int getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}
public OrderProducts(int orderProductsId, Order orderId, Product productId,
		int productQuantity) {
	super();
	this.orderProductsId = orderProductsId;
	this.orderId = orderId;
	this.productId = productId;
	this.productQuantity = productQuantity;
}
public OrderProducts() {
	super();
	// TODO Auto-generated constructor stub
}

}
