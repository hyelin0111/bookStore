package member.model.vo;

public class NonMember {
	private int nonMemberNo;
	private String nonMemberPwd;
	private String nonMemberName;
	private String nonMemberEmail;
	private String nonMemberAddr;

	public NonMember() {
		super();
	}

	public NonMember(int nonMemberNo, String nonMemberPwd, String nonMemberName, String nonMemberEmail,
			String nonMemberAddr) {
		super();
		this.nonMemberNo = nonMemberNo;
		this.nonMemberPwd = nonMemberPwd;
		this.nonMemberName = nonMemberName;
		this.nonMemberEmail = nonMemberEmail;
		this.nonMemberAddr = nonMemberAddr;
	}

	public int getNonMemberNo() {
		return nonMemberNo;
	}

	public void setNonMemberNo(int nonMemberNo) {
		this.nonMemberNo = nonMemberNo;
	}

	public String getNonMemberPwd() {
		return nonMemberPwd;
	}

	public void setNonMemberPwd(String nonMemberPwd) {
		this.nonMemberPwd = nonMemberPwd;
	}

	public String getNonMemberName() {
		return nonMemberName;
	}

	public void setNonMemberName(String nonMemberName) {
		this.nonMemberName = nonMemberName;
	}

	public String getNonMemberEmail() {
		return nonMemberEmail;
	}

	public void setNonMemberEmail(String nonMemberEmail) {
		this.nonMemberEmail = nonMemberEmail;
	}

	public String getNonMemberAddr() {
		return nonMemberAddr;
	}

	public void setNonMemberAddr(String nonMemberAddr) {
		this.nonMemberAddr = nonMemberAddr;
	}

	@Override
	public String toString() {
		return nonMemberNo + ", " + nonMemberPwd + ", " + nonMemberName + ", " + nonMemberEmail + ", " + nonMemberAddr;
	}

}
