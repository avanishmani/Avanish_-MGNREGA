package Avanish_MGNREA.Usecases;

import java.util.Scanner;

import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.Exception.BDOException;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.Exception.GPMException;
import Avanish_MGNREA.custom.Custom;

public class AllocateProjectToGPMCase {
public static void AllocateProject(int pid,int gid) {
	BDO dao=new BDOImpl();
//	Scanner sc=new Scanner(System.in);
	
//	sc.close();
	try {
	String s1=	dao.allocateProjectToGPM(pid, gid);
	if(s1.equals("Project allocated")) {
		System.out.println(Custom.GREEN_BACKGROUND + s1 + Custom.RESET);
	}else {
		System.out.println(Custom.RED_BACKGROUND + s1 + Custom.RESET);
	}
	} catch (BDOException e) {
		// TODO Auto-generated catch block
		System.out.println(Custom.RED_BACKGROUND + e.getMessage()+3 + Custom.RESET);
	} catch (GPMException e) {
		// TODO Auto-generated catch block
		System.out.println(Custom.RED_BACKGROUND + e.getMessage()+2 + Custom.RESET);
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		System.out.println(Custom.RED_BACKGROUND + e.getMessage()+1 + Custom.RESET);
	}
	
}
}
