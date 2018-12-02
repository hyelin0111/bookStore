package book.model.vo;

public class Author {
	private int authorNo;
	private String authorName;
	
	public Author() {
		super();
	}

	public Author(int authorNo, String authorName) {
		super();
		this.authorNo = authorNo;
		this.authorName = authorName;
	}

	public int getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(int authorNo) {
		this.authorNo = authorNo;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return authorNo + ", " + authorName;
	}	
}
