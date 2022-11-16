package Avanish_MGNREA.Bean;

public class Employees {
	private int EmplId;
	private String Name;
	private String Mobile;
	private String Address;
	public Employees(int emplId, String name, String mobile, String address) {
		
		EmplId = emplId;
		Name = name;
		Mobile = mobile;
		Address = address;
	}
	@Override
	public String toString() {
		return "Employees [EmplId=" + EmplId + ", Name=" + Name + ", Mobile=" + Mobile + ", Address=" + Address + "]";
	}
	public Employees() {
		super();
	}
	public Employees(String name, String mobile, String address) {
		
		Name = name;
		Mobile = mobile;
		Address = address;
	}
	public int getEmplId() {
		return EmplId;
	}
	public void setEmplId(int emplId) {
		EmplId = emplId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}
