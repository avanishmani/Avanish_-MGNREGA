package Avanish_MGNREA.Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Avanish_MGNREA.Bean.GPM;
import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.custom.Custom;

public class CreateGPMCase {
public static void CreateGPM() {
	
	try {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Custom.ORANGE + "Enter GPMname" + Custom.RESET);
		String name = sc.next();
		
		System.out.println(Custom.ORANGE + "Enter Email of GPM" + Custom.RESET);
		String email = sc.next();
		
		System.out.println(Custom.ORANGE + "Enter Contact Number" + Custom.RESET);
		String contact = sc.next();
		
		System.out.println(Custom.ORANGE + "Enter Password" + Custom.RESET);
		String password = sc.next();
		
		sc.nextLine();
		System.out.println(Custom.ORANGE + "Enter Village" + Custom.RESET);
		String Vill = sc.nextLine();
		
		
		sc.close();
		BDO dao = new BDOImpl();
		GPM g1=new GPM(name, email, contact, password, Vill);
		
		String result = dao.createGPM(g1);
		
		
		if (result.equals( name+"is registered successfully as GPM.")) {
			System.out.println(Custom.GREEN_BACKGROUND + result +" is registered successfully as GPM." +Custom.RESET);
		
			}
		else {
			System.out.println(Custom.RED_BACKGROUND + result+" is not registered successfully as GPM." + Custom.RESET);
		}
	}catch(InputMismatchException e) {
		System.out.println(Custom.RED_BACKGROUND + "Invalid Input" + Custom.RESET);
	}
	
}
}
