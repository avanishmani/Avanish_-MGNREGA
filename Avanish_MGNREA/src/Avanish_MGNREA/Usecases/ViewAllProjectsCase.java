package Avanish_MGNREA.Usecases;

import java.util.List;

import Avanish_MGNREA.Bean.Projects;
import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.Exception.BDOException;
import Avanish_MGNREA.custom.Custom;

public class ViewAllProjectsCase {
public static void viewAllProjects() {
	BDO dao=new BDOImpl();
	try {
		List<Projects> p1=dao.viewAllProjects();
		if(!p1.isEmpty())
		for(Projects p:p1) System.out.println(Custom.GREEN_BACKGROUND+"Project Name is:- "+ p.getName()+" ,ProjectID is :- "+p.getProject_Id()+Custom.RESET);
		else System.out.println(Custom.RED_BACKGROUND+"NO ANY ONGOING PROJECT IS ThERE IN THIS VILLEGE"+Custom.RESET);
	} catch (BDOException e) {
		// TODO Auto-generated catch block
		System.out.println(Custom.RED_BACKGROUND+e.getMessage()+Custom.RESET);
//		e.printStackTrace();
	}
}
}
