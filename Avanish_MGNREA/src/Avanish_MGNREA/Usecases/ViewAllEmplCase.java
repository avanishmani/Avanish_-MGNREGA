package Avanish_MGNREA.Usecases;

import java.util.List;

import Avanish_MGNREA.Bean.EMP_Project;
import Avanish_MGNREA.Bean.Employees;
import Avanish_MGNREA.Dao.GPMDao;
import Avanish_MGNREA.Dao.GPMDaoImpl;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.custom.Custom;

public class ViewAllEmplCase {
	public static void AllEmployeeDetails() {
		GPMDao dao=new GPMDaoImpl();
		try {
			List<Employees> li=dao.viewAllEmployees();
			if(!li.isEmpty()) if(!li.isEmpty())for(Employees p:li)System.out.println(Custom.GREEN_BACKGROUND+"Employee ID is :- "+ p.getEmplId() +" ,Employee Name is :- "+p.getName()+" ,Employee Contact Number is:- "+p.getMobile()+", Employee Address is:- "+p.getAddress()+Custom.RESET);
			else System.out.println(Custom.RED_BACKGROUND+"NO ANY EMPLOYEE IS There in Database "+Custom.RESET);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
