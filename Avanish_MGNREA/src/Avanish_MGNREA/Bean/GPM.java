package Avanish_MGNREA.Bean;

public class GPM {
	private int GPM_Id;
	private String Name;
	private String Email;
    private String Mobile;
	private String Password;
	private String Villege;
	
	public GPM() {
		super();
	}
	public GPM(int gPM_Id, String name, String email, String mobile, String password, String villege) {
		super();
		GPM_Id = gPM_Id;
		Name = name;
		Email = email;
		Mobile = mobile;
		Password = password;
		Villege = villege;
	}
	public int getGPM_Id() {
		return GPM_Id;
	}
	public void setGPM_Id(int gPM_Id) {
		GPM_Id = gPM_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getVillege() {
		return Villege;
	}
	public void setVillege(String villege) {
		Villege = villege;
	}

	public GPM(String name, String email, String mobile, String password, String villege) {
		super();
		
		Name = name;
		Email = email;
		Mobile = mobile;
		Password = password;
		Villege = villege;
	}
	@Override
	public String toString() {
		return "GPM [GPM_Id=" + GPM_Id + ", Name=" + Name + ", Email=" + Email + ", Mobile=" + Mobile + ", Password="
				+ Password + ", Villege=" + Villege + "]";
	}
}
