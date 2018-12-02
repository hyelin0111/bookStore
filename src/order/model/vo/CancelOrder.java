package order.model.vo;

import java.sql.Date;

public class CancelOrder {
	
	private int memberNo;
	private int orderNo;
	private String bookNo;
	private int orderQTY;
	private Date orderDate;
	private String orderPayment;
	private String delivertStatus;
	private String bookStatus;
	private String bookTitle;
	
	public CancelOrder() {
		
	}

	public CancelOrder(int memberNo, int orderNo, String bookNo, int orderQTY, Date orderDate, String orderPayment,
			String delivertStatus, String bookStatus) {
		this.memberNo = memberNo;
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.orderQTY = orderQTY;
		this.orderDate = orderDate;
		this.orderPayment = orderPayment;
		this.delivertStatus = delivertStatus;
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

	public int getOrderQTY() {
		return orderQTY;
	}

	public void setOrderQTY(int orderQTY) {
		this.orderQTY = orderQTY;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}

	public String getDelivertStatus() {
		return delivertStatus;
	}

	public void setDelivertStatus(String delivertStatus) {
		this.delivertStatus = delivertStatus;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "CancelOrder [memberNo=" + memberNo + ", orderNo=" + orderNo + ", bookNo=" + bookNo + ", orderQTY="
				+ orderQTY + ", orderDate=" + orderDate + ", orderPayment=" + orderPayment + ", delivertStatus="
				+ delivertStatus + ", bookStatus=" + bookStatus + "]";
	}
	
	
}	
