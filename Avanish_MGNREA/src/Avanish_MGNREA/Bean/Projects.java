package Avanish_MGNREA.Bean;

public class Projects {
	private int Project_Id;
	private String PName;
	@Override
	public String toString() {
		return "Project [Project_Id=" + Project_Id + ", Name=" + PName + "]";
	}
	public Projects(int project_Id, String name) {
		
		Project_Id = project_Id;
		PName = name;
	}
	public int getProject_Id() {
		return Project_Id;
	}
	public void setProject_Id(int project_Id) {
		Project_Id = project_Id;
	}
	public String getName() {
		return PName;
	}
	public void setName(String name) {
		PName = name;
	}
	public Projects() {
		super();
	}
}
