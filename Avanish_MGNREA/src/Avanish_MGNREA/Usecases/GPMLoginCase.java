package Avanish_MGNREA.Usecases;

import java.util.Scanner;

import Avanish_MGNREA.Dao.GPMDao;
import Avanish_MGNREA.Dao.GPMDaoImpl;
import Avanish_MGNREA.Exception.GPMException;
import Avanish_MGNREA.custom.Custom;

public class GPMLoginCase {
public static boolean GPMLogin() {
	Scanner sc=new Scanner(System.in);
	System.out.println(Custom.ORANGE+  "Enter username" + Custom.RESET);
	String username = sc.next();
	
	System.out.println(Custom.ORANGE + "Enter password" + Custom.RESET);
	String password = sc.next();
	sc.close();
	GPMDao dao=new GPMDaoImpl();
	String s1="";
	try {
		s1=dao.loginGPM(username, password);
		if(s1.equals("Login Succefull")){
			System.out.println(Custom.GREEN_BACKGROUND + s1 + Custom.RESET);
			return true;
		}
		else {
			System.out.println(Custom.RED_BACKGROUND + s1 + Custom.RESET);
			return false;
		}
	} catch (GPMException e) {

		System.out.println(Custom.RED_BACKGROUND + e.getMessage() + Custom.RESET);
		return false;
	}
}
}
