package review.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;
	private String bookNo;
	private String reviewContent;
	private String reviewWriter;
	private Date reviewDate;
	private String bookStatus;

	public Review() {}

	public Review(int reviewNo, String bookNo, String reviewContent, String reviewWriter, Date reviewDate,
			String bookStatus) {
		this.reviewNo = reviewNo;
		this.bookNo = bookNo;
		this.reviewContent = reviewContent;
		this.reviewWriter = reviewWriter;
		this.reviewDate = reviewDate;
		this.bookStatus = bookStatus;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return  reviewNo + "\t" + bookNo + "\t" + reviewContent
				+ "\t" + reviewWriter + "\t" + reviewDate + "\t" + bookStatus;
	}
	
	
}
