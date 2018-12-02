package member.model.vo;

public class Address {
	private int member_no;
	private String member_address1;
	private String member_address2;
	private String member_address3;
	private String member_address4;
	private int addressStatus;
	
	public Address() {}
	
	
	public Address(int member_no, String member_address1, String member_address2, String member_address3,
			String member_address4, int addressStatus) {
		this.member_no = member_no;
		this.member_address1 = member_address1;
		this.member_address2 = member_address2;
		this.member_address3 = member_address3;
		this.member_address4 = member_address4;
		this.addressStatus = addressStatus;
	}
	
	public Address(int member_no, String member_address1, String member_address2, String member_address3,String member_address4) {
		this.member_no = member_no;
		this.member_address1 = member_address1;
		this.member_address2 = member_address2;
		this.member_address3 = member_address3;
		this.member_address4 = member_address4;
	}
	//회원가입시 주소 추가.
	public Address(int no, String address) {
		this.member_no = no;
		this.member_address1 = address;
	}


	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_address1() {
		return member_address1;
	}
	public void setMember_address1(String member_address1) {
		this.member_address1 = member_address1;
	}
	public String getMember_address2() {
		return member_address2;
	}
	public void setMember_address2(String member_address2) {
		this.member_address2 = member_address2;
	}
	public String getMember_address3() {
		return member_address3;
	}
	public void setMember_address3(String member_address3) {
		this.member_address3 = member_address3;
	}
	public String getMember_address4() {
		return member_address4;
	}
	public void setMember_address4(String member_address4) {
		this.member_address4 = member_address4;
	}
	public int getAddressStatus() {
		return addressStatus;
	}
	public void setAddressStatus(int addressStatus) {
		this.addressStatus = addressStatus;
	}


	@Override
	public String toString() {
		return "Address [member_no=" + member_no + ", member_address1=" + member_address1 + ", member_address2="
				+ member_address2 + ", member_address3=" + member_address3 + ", member_address4=" + member_address4
				+ ", addressStatus=" + addressStatus + "]";
	}
	
	
		
}
