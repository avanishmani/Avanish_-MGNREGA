package Avanish_MGNREA.Bean;

public class EMP_Project {
	private int Project_Id;
	private int EmplId;
	private String Start_Date;
	private String End_Date;
	private int Wages;
	public EMP_Project(int project_Id, int emplId, String start_Date, String end_Date, int wages) {
		super();
		Project_Id = project_Id;
		EmplId = emplId;
		Start_Date = start_Date;
		End_Date = end_Date;
		Wages = wages;
	}
	@Override
	public String toString() {
		return "EMP_Project [Project_Id=" + Project_Id + ", EmplId=" + EmplId + ", Start_Date=" + Start_Date
				+ ", End_Date=" + End_Date + ", Wages=" + Wages + "]";
	}
	public int getProject_Id() {
		return Project_Id;
	}
	public void setProject_Id(int project_Id) {
		Project_Id = project_Id;
	}
	public int getEmplId() {
		return EmplId;
	}
	public void setEmplId(int emplId) {
		EmplId = emplId;
	}
	public String getStart_Date() {
		return Start_Date;
	}
	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}
	public String getEnd_Date() {
		return End_Date;
	}
	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}
	public int getWages() {
		return Wages;
	}
	public void setWages(int wages) {
		Wages = wages;
	}
	public EMP_Project() {
		super();
	}
	
}
