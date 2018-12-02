package oldboard.model.vo;

import java.sql.Date;

public class OldBoard {
	private int oldBoardNo; // 게시글 번호
	private String bookTitle; // 책 이름
	private String memberName; // 판매자 이름
	private Date oldBoardDate; // 게시글 게시일
	private int oldBookPrice; // 판매 가격
	private int oldBookCount; // 판매 수량
	private String oldBookNo; // 책번호
	private String bookCondition; // 책 상태
	private int memberNo;		// 회원번호
	private String bookStatus;	// 중고여부
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public OldBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OldBoard(int oldBoardNo, String bookTitle, String memberName, Date oldBoardDate, int oldBookPrice,
			int oldBookCount) {
		super();
		this.oldBoardNo = oldBoardNo;
		this.bookTitle = bookTitle;
		this.memberName = memberName;
		this.oldBoardDate = oldBoardDate;
		this.oldBookPrice = oldBookPrice;
		this.oldBookCount = oldBookCount;
	}

	public OldBoard(String oldBookNo, int oldBookPrice) {
		super();
		this.oldBookNo = oldBookNo;
		this.oldBookPrice = oldBookPrice;
	}

	public OldBoard(String bookTitle, String memberName, Date oldBoardDate, int oldBookPrice, String oldBookNo) {
		super();
		this.bookTitle = bookTitle;
		this.memberName = memberName;
		this.oldBoardDate = oldBoardDate;
		this.oldBookPrice = oldBookPrice;
		this.oldBookNo = oldBookNo;
	}	

	public OldBoard(int oldBookPrice, String oldBookNo, String bookCondition) {
		super();
		this.oldBookPrice = oldBookPrice;
		this.oldBookNo = oldBookNo;
		this.bookCondition = bookCondition;
	}

	public String getOldBookNo() {
		return oldBookNo;
	}

	public void setOldBookNo(String oldBookNo) {
		this.oldBookNo = oldBookNo;
	}

	public int getOldBoardNo() {
		return oldBoardNo;
	}

	public void setOldBoardNo(int oldBoardNo) {
		this.oldBoardNo = oldBoardNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getOldBoardDate() {
		return oldBoardDate;
	}

	public void setOldBoardDate(Date oldBoardDate) {
		this.oldBoardDate = oldBoardDate;
	}

	public int getOldBookPrice() {
		return oldBookPrice;
	}

	public void setOldBookPrice(int oldBookPrice) {
		this.oldBookPrice = oldBookPrice;
	}

	public int getOldBookCount() {
		return oldBookCount;
	}

	public void setOldBookCount(int oldBookCount) {
		this.oldBookCount = oldBookCount;
	}

	public String getBookCondition() {
		return bookCondition;
	}

	public void setBookCondition(String bookCondition) {
		this.bookCondition = bookCondition;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return oldBoardNo + ", " + bookTitle + ", " + memberName + ", " + oldBoardDate + ", " + oldBookPrice + ", "
				+ oldBookNo;
	}
}