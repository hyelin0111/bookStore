package basket.model.vo;

public class Basket {
	private int memberNo;
	private String memberName;
	private String bookNo;
	private String bookTitle;
	private int amount;
	private String usedStatus;
	private int price;

	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Basket(int memberNo, String memberName, String bookNo, String bookTitle, int amount, String usedStatus,
			int price) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.amount = amount;
		this.usedStatus = usedStatus;
		this.price = price;
	}

	public Basket(int memberNo, String bookNo,
			int amount, String usedStatus) {
		super();
		this.memberNo = memberNo;
		this.bookNo = bookNo;
		this.amount = amount;
		this.usedStatus = usedStatus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUsedStatus() {
		return usedStatus;
	}

	public void setUsedStatus(String usedStatus) {
		this.usedStatus = usedStatus;
	}	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return memberNo + ", " + memberName + ", " + bookNo + ", " + bookTitle + ", " + amount + ", " + usedStatus;
	}

}
