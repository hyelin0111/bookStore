package order.model.vo;

import java.sql.Date;

public class Order {
	private int memberNo;
	private int orderNo;
	private String bookNo;
	private int orderQty;
	private String payment;
	private String deliveryStatus;
	private String bookStatus;
	private Date orderDate;
	private String bookTitle;

	public Order() {}
	
	public Order(int memberNo, int orderNo, String bookNo, int orderQty, String payment, String deliveryStatus,
			String bookStatus) {
		this.memberNo = memberNo;
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.orderQty = orderQty;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
		this.bookStatus = bookStatus;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	
	public int getOrderQty() {
		return orderQty;
	}
	
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	public String getPayment() {
		return payment;
	}
	
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	public String getBookStatus() {
		return bookStatus;
	}
	
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	@Override
	public String toString() {
		return "Order [memberNo=" + memberNo + ", orderNo=" + orderNo + ", bookNo=" + bookNo + ", orderQty=" + orderQty
				+ ", payment=" + payment + ", deliveryStatus=" + deliveryStatus + ", bookStatus=" + bookStatus
				+ ", orderDate=" + orderDate + "]";
	}


}