package libiaryManagmentSystem.DayNine;

public class Member {
	
	private int memberId;
	private String name;
	private String address;
	private long contact;
	
	public Member(int memberId, String name, String address, long contact) {
		this.memberId = memberId;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public long getContact() {
		return contact;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ "]";
	}

	

}
