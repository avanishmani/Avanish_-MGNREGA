package Avanish_MGNREA.Usecases;

import java.util.Scanner;


import Avanish_MGNREA.Dao.GPMDao;
import Avanish_MGNREA.Dao.GPMDaoImpl;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.custom.Custom;

public class AssignEmployeesToProjectCase {
	public static void EmpOnProject(int pid,int eid,String start,String end,int Wages) {
	GPMDao dao=new GPMDaoImpl();	
	try {
	String result=	dao.assignEmployeesToProject(pid, eid, start, end, Wages);
	if(result.equals(eid + " Employee assigned to " + pid + " Project Successfully..."));
	else System.out.println(Custom.RED_BACKGROUND + result + Custom.RESET);
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		System.out.println(Custom.RED_BACKGROUND + e.getMessage() + Custom.RESET);
	}
	
}
}
