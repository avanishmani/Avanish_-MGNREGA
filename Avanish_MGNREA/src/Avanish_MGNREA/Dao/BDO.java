package Avanish_MGNREA.Dao;

import java.util.List;

import Avanish_MGNREA.Bean.EMP_Project;
import Avanish_MGNREA.Bean.GPM;
import Avanish_MGNREA.Bean.Projects;
import Avanish_MGNREA.Exception.BDOException;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.Exception.GPMException;

public interface BDO {
    public final String username = "bdo";
	
	public final String password = "1234";

	public String BDOLogin(String username, String password);
	public String createProject(Projects project);
	public List<Projects> viewAllProjects() throws BDOException;
	public String createGPM(GPM gpm);
	public List<GPM> viewAllGPM()throws GPMException;
	public String allocateProjectToGPM(int projectId, int GPMId) throws BDOException, GPMException,EmployeeException;
	public List<EMP_Project> viewAllEmployeesWorkDetails()throws EmployeeException;
}
