package com.ecom1.models;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private int orderId;
	private Date orderDate;
	private Date orderDeliveryDate;
	private int orderQuantity;
	private double orderTotalAmount;
	private String orderStatus;
	private Customer customerId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderDeliveryDate() {
		return orderDeliveryDate;
	}
	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public void setOrderTotalAmount(double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Order(int orderId, Date orderDate, Date orderDeliveryDate,
			int orderQuantity, double orderTotalAmount, String orderStatus,
			Customer customerId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderDeliveryDate = orderDeliveryDate;
		this.orderQuantity = orderQuantity;
		this.orderTotalAmount = orderTotalAmount;
		this.orderStatus = orderStatus;
		this.customerId = customerId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}