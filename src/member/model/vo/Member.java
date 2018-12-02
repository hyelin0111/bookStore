package member.model.vo;

import java.sql.Date;

public class Member {
	private int member_no;
	private String member_id;
	private String member_password;
	private String member_name;
	private String member_gender;
	private String member_birthday;
	private String member_phone;
	private String member_email;
	private String member_interested;
	private Date member_enrolldate;
	private Date member_deletedate;
	private String member_status;	
	


	public Member() {}


	public Member(int member_no, String member_id, String member_password, String member_name, String member_gender,
			String member_birthday, String member_phone, String member_email, String member_interested,
			Date member_enrolldate, Date member_deletedate, String member_status) {
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_password = member_password;
		this.member_name = member_name;
		this.member_gender = member_gender;
		this.member_birthday = member_birthday;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_interested = member_interested;
		this.member_enrolldate = member_enrolldate;
		this.member_deletedate = member_deletedate;
		this.member_status = member_status;
	}
	//insert
	public Member(String id, String password, String name, String gender,String birthday, String email, String phone,String interested) {
		this.member_id = id;
		this.member_password = password;
		this.member_name = name;
		this.member_gender = gender;
		this.member_birthday = birthday;
		this.member_email = email;
		this.member_phone = phone;
		this.member_interested = interested;
	}
	public Member(String id) {
		this.member_id = id;
	}

	//update
	public Member(String id, String email, String phone, String interested) {
		this.member_id = id;
		this.member_email = email;
		this.member_phone = phone;
		this.member_interested = interested;
		
	}

	//Admin- memberUpdate
	public Member(String id, String password, String email, String phone, String interested,String ms) {
		this.member_id = id;
		this.member_password = password;
		this.member_email = email;
		this.member_phone = phone;
		this.member_interested = interested;
		this.member_status = ms;
	}


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getMember_password() {
		return member_password;
	}


	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getMember_gender() {
		return member_gender;
	}


	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}


	public String getMember_birthday() {
		return member_birthday;
	}


	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}


	public String getMember_phone() {
		return member_phone;
	}


	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}


	public String getMember_email() {
		return member_email;
	}


	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}


	public String getMember_interested() {
		return member_interested;
	}


	public void setMember_interested(String member_interested) {
		this.member_interested = member_interested;
	}


	public Date getMember_enrolldate() {
		return member_enrolldate;
	}


	public void setMember_enrolldate(Date member_enrolldate) {
		this.member_enrolldate = member_enrolldate;
	}


	public Date getMember_deletedate() {
		return member_deletedate;
	}


	public void setMember_deletedate(Date member_deletedate) {
		this.member_deletedate = member_deletedate;
	}


	public String getMember_status() {
		return member_status;
	}


	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}
	



	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", member_id=" + member_id + ", member_password=" + member_password
				+ ", member_name=" + member_name + ", member_gender=" + member_gender + ", member_birthday="
				+ member_birthday + ", member_phone=" + member_phone + ", member_email=" + member_email
				+ ", member_interested=" + member_interested + ", member_enrolldate=" + member_enrolldate
				+ ", member_deletedate=" + member_deletedate + ", member_status=" + member_status + "]";
	}
	
	
	
	
		
}
