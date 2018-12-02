package seller.model.vo;

public class Seller {
	private int member_no;
	private int success_count;
	private String tell_ok;
	private String email_ok;
	private String account_ok;
	private String delivery_way;
	private int delivery_island_price;
	private int delivery_price;
	private String seller_nickname;
	private String delivery_chul;
	private String account_bank;
	private String member_id;
	private String member_name;
	private String member_status;
	
	
	public Seller() {}


	/*public Seller(int member_no, int success_count, String tell_ok, String email_ok, String account_ok,
			String delivery_way, int delivery_island_price, int delivery_price, String seller_nickname,
			String delivery_chul, String account_bank) {
		this.member_no = member_no;
		this.success_count = success_count;
		this.tell_ok = tell_ok;
		this.email_ok = email_ok;
		this.account_ok = account_ok;
		this.delivery_way = delivery_way;
		this.delivery_island_price = delivery_island_price;
		this.delivery_price = delivery_price;
		this.seller_nickname = seller_nickname;
		this.delivery_chul = delivery_chul;
		this.account_bank = account_bank;
	}*/
	
	public Seller(int member_no, int success_count, String tell_ok, String email_ok, String account_ok,
			String delivery_way, int delivery_island_price, int delivery_price, String seller_nickname,
			String delivery_chul, String account_bank,String member_id,String member_name,String member_status) {
		this.member_no = member_no;
		this.success_count = success_count;
		this.tell_ok = tell_ok;
		this.email_ok = email_ok;
		this.account_ok = account_ok;
		this.delivery_way = delivery_way;
		this.delivery_island_price = delivery_island_price;
		this.delivery_price = delivery_price;
		this.seller_nickname = seller_nickname;
		this.delivery_chul = delivery_chul;
		this.account_bank = account_bank;
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_status = member_status;
	}


	public Seller(int no, String selPhone1, String selEmail, String account, String pdel1, int delIPrice1,
			int delPrice1, String sellernick1, String address, String bank) {
		this.member_no = no;
		this.tell_ok = selPhone1;
		this.email_ok = selEmail;
		this.account_ok = account;
		this.delivery_way = pdel1;
		this.delivery_island_price=delIPrice1;
		this.delivery_price = delPrice1;
		this.seller_nickname=sellernick1;
		this.delivery_chul = address;
		this.account_bank=bank;
		
	}


	public Seller(int no, String bank, String account, String email, String address, int delPrice1, int delIPrice1) {
		this.member_no = no;
		this.account_bank=bank;
		this.account_ok = account;
		this.email_ok = email;
		this.delivery_chul = address;
		this.delivery_island_price=delIPrice1;
		this.delivery_price = delPrice1;
		// TODO Auto-generated constructor stub
	}


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public int getSuccess_count() {
		return success_count;
	}


	public void setSuccess_count(int success_count) {
		this.success_count = success_count;
	}


	public String getTell_ok() {
		return tell_ok;
	}


	public void setTell_ok(String tell_ok) {
		this.tell_ok = tell_ok;
	}


	public String getEmail_ok() {
		return email_ok;
	}


	public void setEmail_ok(String email_ok) {
		this.email_ok = email_ok;
	}


	public String getAccount_ok() {
		return account_ok;
	}


	public void setAccount_ok(String account_ok) {
		this.account_ok = account_ok;
	}


	public String getDelivery_way() {
		return delivery_way;
	}


	public void setDelivery_way(String delivery_way) {
		this.delivery_way = delivery_way;
	}


	public int getDelivery_island_price() {
		return delivery_island_price;
	}


	public void setDelivery_island_price(int delivery_island_price) {
		this.delivery_island_price = delivery_island_price;
	}


	public int getDelivery_price() {
		return delivery_price;
	}


	public void setDelivery_price(int delivery_price) {
		this.delivery_price = delivery_price;
	}


	public String getSeller_nickname() {
		return seller_nickname;
	}


	public void setSeller_nickname(String seller_nickname) {
		this.seller_nickname = seller_nickname;
	}


	public String getDelivery_chul() {
		return delivery_chul;
	}


	public void setDelivery_chul(String delivery_chul) {
		this.delivery_chul = delivery_chul;
	}
	public String getAccount_bank() {
		return account_bank;
	}
	public void setAccount_bank(String account_bank) {
		this.account_bank = account_bank;
	}
	
	


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getMember_status() {
		return member_status;
	}


	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}


	@Override
	public String toString() {
		return "Seller [member_no=" + member_no + ", success_count=" + success_count + ", tell_ok=" + tell_ok
				+ ", email_ok=" + email_ok + ", account_ok=" + account_ok + ", delivery_way=" + delivery_way
				+ ", delivery_island_price=" + delivery_island_price + ", delivery_price=" + delivery_price
				+ ", seller_nickname=" + seller_nickname + ", delivery_chul=" + delivery_chul + ", account_bank="
				+ account_bank + ", member_id=" + member_id + ", member_name=" + member_name + ", member_status="
				+ member_status + "]";
	}


	
	
}
