package Avanish_MGNREA.Usecases;

import java.util.Scanner;


import Avanish_MGNREA.Dao.GPMDao;
import Avanish_MGNREA.Dao.GPMDaoImpl;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.custom.Custom;

public class AssignEmployeesToProjectCase {
	public static void EmpOnProject() {
	GPMDao dao=new GPMDaoImpl();
	Scanner sc=new Scanner(System.in);
	System.out.println(Custom.ORANGE + "Enter Project ID number" + Custom.RESET);
	int eid =sc.nextInt();
	System.out.println(Custom.ORANGE + "Enter Employee ID number" + Custom.RESET);
	int pid =sc.nextInt();
	System.out.println(Custom.ORANGE + "Enter Start Day Of  Employee" + Custom.RESET);
	String start = sc.next();
	System.out.println(Custom.ORANGE + "Enter End Day Of  Employee" + Custom.RESET);
	String end = sc.next();
	System.out.println(Custom.ORANGE + "Enter Employee Wages " + Custom.RESET);
	int Wages = sc.nextInt();
	sc.close();
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
