package book.model.vo;

import java.sql.Date;

public class Book {
	private String bookNo;
	private int authorNo;
	private String authorName;
	private String bookTitle;
	private String bookPublisher;
	private Date issueDate;
	private int bookPrice;
	private int bookPage;
	private String category;
	private int bookSaleQty;
	private double bookGrade;
	private String bookStatus;

	public Book() {
		super();
	}

	public Book(String bookNo, int authorNo, String authorName, String bookTitle, String bookPublisher, Date issueDate,
			int bookPrice, int bookPage, String category, int bookSaleQty, double bookGrade, String bookStatus) {
		super();
		this.bookNo = bookNo;
		this.authorNo = authorNo;
		this.authorName = authorName;
		this.bookTitle = bookTitle;
		this.bookPublisher = bookPublisher;
		this.issueDate = issueDate;
		this.bookPrice = bookPrice;
		this.bookPage = bookPage;
		this.category = category;
		this.bookSaleQty = bookSaleQty;
		this.bookGrade = bookGrade;
		this.bookStatus = bookStatus;
	}

	public Book(String bookNo, String authorName, String bookTitle, String bookPublisher) {
		super();
		this.bookNo = bookNo;
		this.authorName = authorName;
		this.bookTitle = bookTitle;
		this.bookPublisher = bookPublisher;
	}

	public Book(String bookNo, String authorName, String bookTitle, String bookPublisher, Date issueDate, int bookPrice,
			int bookPage, String category, int bookSaleQty, double bookGrade) {
		super();
		this.bookNo = bookNo;
		this.authorName = authorName;
		this.bookTitle = bookTitle;
		this.bookPublisher = bookPublisher;
		this.issueDate = issueDate;
		this.bookPrice = bookPrice;
		this.bookPage = bookPage;
		this.category = category;
		this.bookSaleQty = bookSaleQty;
		this.bookGrade = bookGrade;
	}

	public Book(String bookNo, String authorName, String bookTitle, String bookPublisher, Date issueDate, int bookPrice,
			String category) {
		super();
		this.bookNo = bookNo;
		this.authorName = authorName;
		this.bookTitle = bookTitle;
		this.bookPublisher = bookPublisher;
		this.issueDate = issueDate;
		this.bookPrice = bookPrice;
		this.category = category;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public int getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(int authorNo) {
		this.authorNo = authorNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookPage() {
		return bookPage;
	}

	public void setBookPage(int bookPage) {
		this.bookPage = bookPage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBookSaleQty() {
		return bookSaleQty;
	}

	public void setBookSaleQty(int bookSaleQty) {
		this.bookSaleQty = bookSaleQty;
	}

	public double getBookGrade() {
		return bookGrade;
	}

	public void setBookGrade(double bookGrade) {
		this.bookGrade = bookGrade;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return bookNo + ", " + authorNo + ", " + authorName + ", " + bookTitle + ", " + bookPublisher + ", " + issueDate
				+ ", " + bookPrice + ", " + bookPage + ", " + category + ", " + bookSaleQty + ", " + bookGrade + ", "
				+ bookStatus;
	}

}
