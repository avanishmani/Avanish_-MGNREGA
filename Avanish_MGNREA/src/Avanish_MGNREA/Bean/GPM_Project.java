package Avanish_MGNREA.Bean;

public class GPM_Project {
	private int Project_Id;
	private int GPM_Id;
	public int getGPM_Id() {
		return GPM_Id;
	}
	public void setGPM_Id(int gPM_Id) {
		GPM_Id = gPM_Id;
	}
	public GPM_Project() {
		super();
	}
	public GPM_Project(int project_Id, int gPM_Id) {
		super();
		Project_Id = project_Id;
		GPM_Id = gPM_Id;
	}
}
