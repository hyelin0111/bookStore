package recommend.model.vo;

public class Recommend {
	private int recommendNo; // 지서재 번호
	private String recommendBookNo; // 지서재에 등록된 bookNo
	private String recommendBookTitle; // 책이름 나중에 쓸때?
	private String recommendTitle; // 지서재 제목
	private String recommendContent; // 지서재 내용

	public Recommend() {
		super();
	}

	public Recommend(int recommendNo, String recommendBookNo, String recommendBookTitle, String recommendTitle,
			String recommendContent) {
		super();
		this.recommendNo = recommendNo;
		this.recommendBookNo = recommendBookNo;
		this.recommendBookTitle = recommendBookTitle;
		this.recommendTitle = recommendTitle;
		this.recommendContent = recommendContent;
	}

	public int getRecommendNo() {
		return recommendNo;
	}

	public void setRecommendNo(int recommendNo) {
		this.recommendNo = recommendNo;
	}

	public String getRecommendBookNo() {
		return recommendBookNo;
	}

	public void setRecommendBookNo(String recommendBookNo) {
		this.recommendBookNo = recommendBookNo;
	}

	public String getRecommendBookTitle() {
		return recommendBookTitle;
	}

	public void setRecommendBookTitle(String recommendBookTitle) {
		this.recommendBookTitle = recommendBookTitle;
	}

	public String getRecommendTitle() {
		return recommendTitle;
	}

	public void setRecommendTitle(String recommendTitle) {
		this.recommendTitle = recommendTitle;
	}

	public String getRecommendContent() {
		return recommendContent;
	}

	public void setRecommendContent(String recommendContent) {
		this.recommendContent = recommendContent;
	}

	@Override
	public String toString() {
		return recommendNo + ", " + recommendBookNo + ", " + recommendBookTitle + ", " + recommendTitle + ", "
				+ recommendContent;
	}
}
