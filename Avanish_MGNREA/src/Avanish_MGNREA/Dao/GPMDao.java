package Avanish_MGNREA.Dao;

import java.util.List;

import Avanish_MGNREA.Bean.Employees;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.Exception.GPMException;

public interface GPMDao {
	public String loginGPM(String email, String pass)throws GPMException;
	public String createEmployee(Employees empl);
	public List<Employees> viewAllEmployees()throws EmployeeException;
	public String assignEmployeesToProject(int projectId, int EmployeeId, String Start_date,String End_date, int wages ) throws EmployeeException;
}
