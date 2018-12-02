package notice.model.vo;

import java.util.Date;

public class Notice {
	private int notice_no;
	private int member_no;
	private String title;
	private String content;
	private Date date;
	
	
	public Notice() {}


	public Notice(int notice_no, int member_no, String title, String content, Date date) {
		super();
		this.notice_no = notice_no;
		this.member_no = member_no;
		this.title = title;
		this.content = content;
		this.date = date;
	}


	public int getNotice_no() {
		return notice_no;
	}


	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Notice [notice_no=" + notice_no + ", member_no=" + member_no + ", title=" + title + ", content="
				+ content + ", date=" + date + "]";
	}
	
	
	
	
	
}
