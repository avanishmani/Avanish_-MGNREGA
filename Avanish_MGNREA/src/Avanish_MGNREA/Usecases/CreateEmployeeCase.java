package Avanish_MGNREA.Usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Avanish_MGNREA.Bean.Employees;
import Avanish_MGNREA.Bean.GPM;
import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.Dao.GPMDao;
import Avanish_MGNREA.Dao.GPMDaoImpl;
import Avanish_MGNREA.custom.Custom;

public class CreateEmployeeCase {
public static void CreateEmpl() {
	try {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Custom.ORANGE + "Enter Employee name" + Custom.RESET);
		String name = sc.next();
		
		System.out.println(Custom.ORANGE + "Enter Contact Number" + Custom.RESET);
		String contact = sc.next();
		
		
		System.out.println(Custom.ORANGE + "Enter Address of Employee" + Custom.RESET);
		String Address = sc.next();
		
		
		sc.close();
		GPMDao dao = new GPMDaoImpl();
		Employees e1=new Employees(name, contact, Address);
		
		String result = dao.createEmployee(e1);
		
		
		if (result.equals( name+" is registered successfully as Employee.")) {
			System.out.println(Custom.GREEN_BACKGROUND + result  +Custom.RESET);
		
			}
		else {
			System.out.println(Custom.RED_BACKGROUND + name+" Profile is Already There"+ Custom.RESET);
		}
	}catch(InputMismatchException e) {
		System.out.println(Custom.RED_BACKGROUND + "Invalid Input" + Custom.RESET);
	}
}
}
