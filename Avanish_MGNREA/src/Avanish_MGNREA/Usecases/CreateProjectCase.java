package Avanish_MGNREA.Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Avanish_MGNREA.Bean.Projects;
import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.custom.Custom;

public class CreateProjectCase {

	public static  void CreateProjectByBDO(int pid,String pName) {
		
		try {
			
			Projects pro=new Projects(pid, pName);
			BDO dao=new BDOImpl();
			String result =dao.createProject(pro);
			if(result.equals(pName+" project Created Successfully")) {
				System.out.println(Custom.GREEN_BACKGROUND + result + Custom.RESET);
			}else {
				System.out.println(Custom.RED_BACKGROUND + result + Custom.RESET);
			}
		}catch(InputMismatchException e) {
			System.out.println(Custom.RED_BACKGROUND + "Invalid input" + Custom.RESET);
		}
		
	}

}
