package Avanish_MGNREA.Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Avanish_MGNREA.Bean.Projects;
import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.custom.Custom;

public class CreateProjectCase {

	public static  void CreateProjectByBDO() {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println(Custom.ORANGE + "Enter Project ID number" + Custom.RESET);
			int pid =sc.nextInt();
			System.out.println(Custom.ORANGE + "Enter Project Name name" + Custom.RESET);
			String pName = sc.next();
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
		sc.close();
	}

}
