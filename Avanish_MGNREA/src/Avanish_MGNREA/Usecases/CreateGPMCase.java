package Avanish_MGNREA.Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Avanish_MGNREA.Bean.GPM;
import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.custom.Custom;

public class CreateGPMCase {


public static void CreateGPM(String name, String email,String contact,String password,String Vill) {
	
	try {
		
		
		
		
		
		

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
