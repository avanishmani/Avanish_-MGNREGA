package Avanish_MGNREA.Usecases;

import java.util.List;

import Avanish_MGNREA.Bean.EMP_Project;
import Avanish_MGNREA.Bean.Projects;
import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.custom.Custom;

public class ViewAllEmployeesWorkDetailsCase {
public static void AllEmployeeDetails() {
	BDO dao=new BDOImpl();
	try {
		List<EMP_Project> li=	dao.viewAllEmployeesWorkDetails();
		if(!li.isEmpty())for(EMP_Project p:li)System.out.println(Custom.GREEN_BACKGROUND+"Employee ID is :- "+ p.getEmplId() +" ,Working on Project ID :- "+p.getProject_Id()+" ,Employee Start Working on that Project:- "+p.getStart_Date()+", Employee Daily Wages is"+p.getWages()+Custom.RESET);
		else System.out.println(Custom.RED_BACKGROUND+"NO ANY EMPLOYEE IS ALLOATED ON THAT PROJECT"+Custom.RESET);
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println(Custom.RED_BACKGROUND+e.getMessage()+Custom.RESET);
	}
}
}
