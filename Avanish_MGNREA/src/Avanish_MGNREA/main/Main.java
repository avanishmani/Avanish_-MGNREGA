package Avanish_MGNREA.main;

import java.util.*;

import Avanish_MGNREA.Usecases.AllocateProjectToGPMCase;
import Avanish_MGNREA.Usecases.AssignEmployeesToProjectCase;
import Avanish_MGNREA.Usecases.BDOLoginUseCase;
import Avanish_MGNREA.Usecases.CreateEmployeeCase;
import Avanish_MGNREA.Usecases.CreateGPMCase;
import Avanish_MGNREA.Usecases.CreateProjectCase;
import Avanish_MGNREA.Usecases.GPMLoginCase;
import Avanish_MGNREA.Usecases.ViewAllEmplCase;
import Avanish_MGNREA.Usecases.ViewAllEmployeesWorkDetailsCase;
import Avanish_MGNREA.Usecases.ViewAllGPMCase;
import Avanish_MGNREA.Usecases.ViewAllProjectsCase;
import Avanish_MGNREA.custom.Custom;

public class Main {

	static Scanner sc=new Scanner(System.in);

	static void BDOOrGPM() {
		System.out.println();
		System.out.println("<===================  WELCOME TO MGNREGA MANAGEMENT SYSTEM  ===================> ");
		System.out.println("	The Mahatama Gandhi National Rural Employment Guarantee Act 2005 ");
		System.out.println("	----- Ministry Of Rural Development, Government Of India ------ ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();

		
		System.out.println(Custom.PURPLE + "+---------------------------+" + "\n"
				   + "| 1. Login As BDO           |" + "\n"
				   + "| 2. Login As GPM           |" + "\n"
				   + "| 3. Exit                   |" + "\n"
				   + "+---------------------------+" + Custom.RESET);
choice();
}
	static void choice() {

		
		int n = 0;
		try {
			n = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println(Custom.RED_BACKGROUND + "Input type should be number" + Custom.RESET);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BDOOrGPM();
		}
		
		if (n == 1) {
			System.out.println(Custom.ROSY_PINK + "Welcome BDO ! Please Login to your account" + Custom.RESET);
			BDOLogin();

		}
		else if (n == 2) {
			System.out.println(Custom.ROSY_PINK + "Welcome GPM !" + Custom.RESET);
			GPMLogin();
		}
		else if (n == 3) {
			System.out.println(Custom.ROSY_PINK + "Thank you ! Visit again" + Custom.RESET);
			System.exit(0);
		}
		else {
			System.out.println(Custom.RED_BACKGROUND + "Please choose a number from below options" + Custom.RESET);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BDOOrGPM();
		}

	}
static void BDOLogin() {
	System.out.println(Custom.ORANGE+  "Enter username" + Custom.RESET);
	String username = sc.next();
	
	System.out.println(Custom.ORANGE + "Enter password" + Custom.RESET);
	String password = sc.next();
		Boolean result = BDOLoginUseCase.BDOLogin(username,password);

//		CreateProjectCase.CreateProjectByBDO();
//		ViewAllProjectsCase.viewAllProjects();

		if (result)       BDOMethods();
		else BDOLogin();
		
	}
static void BDOMethods() {

	int n1=0;
	System.out.println(Custom.PURPLE + "+-----------------------------------------------------------------------+" + "\n"
					 + "| Welcome BDO                                                           |" + "\n"
					 + "| 1. Create a project.                                                  |" + "\n"
					 + "| 2. View List Of Project.                                              |" + "\n"
					 + "| 3. Create new Gram Panchayat Member(GPM).                             |" + "\n"
					 + "| 4. View all the GPM.                                                  |" + "\n"
					 + "| 5. Allocate  Project to GPM                                           |" + "\n"
					 + "| 6. See List of Employee working on that Project and their wages.      |" + "\n"
					 + "| 7. Back                                                               |" + "\n"
					 + "| 8. Exit                                                               |" + "\n"
					 + "+-----------------------------------------------------------------------+" + Custom.RESET);
	
//	Scanner sc = new Scanner(System.in);
	
	
	try {

		n1 = sc.nextInt();

		if (n1 != 1 && n1 != 2 && n1 != 3 && n1 != 4 && n1 != 5 && n1 != 6 && n1 != 7 && n1 != 8) {
			System.out.println(Custom.RED_BACKGROUND + "Please choose a number from below options" + Custom.RESET);
			BDOMethods();
		}
		else BDOChoice(n1);
	}
	catch (InputMismatchException e) {
//		e.printStackTrace();
		System.out.println(Custom.RED_BACKGROUND + "Input type should be number" + Custom.RESET);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BDOMethods();
	}

}
static void BDOChoice(int choice) {
	
	switch(choice) {
		case 1 : {

			System.out.println(Custom.ORANGE + "Enter Project ID number" + Custom.RESET);
			int pid =sc.nextInt();
			System.out.println(Custom.ORANGE + "Enter Project Name name" + Custom.RESET);
			String pName = sc.next();
			CreateProjectCase.CreateProjectByBDO(pid,pName);

			BDOMethods();
		}
		break;
		case 2 : {

			ViewAllProjectsCase.viewAllProjects();
			BDOMethods();
		}
		break;
		case 3 : {

			System.out.println(Custom.ORANGE + "Enter GPMname" + Custom.RESET);
			String name = sc.next();
			
			System.out.println(Custom.ORANGE + "Enter Email of GPM" + Custom.RESET);
			String email = sc.next();
			
			System.out.println(Custom.ORANGE + "Enter Contact Number" + Custom.RESET);
			String contact = sc.next();
			
			System.out.println(Custom.ORANGE + "Enter Password" + Custom.RESET);
			String password = sc.next();
			
			
			System.out.println(Custom.ORANGE + "Enter Village" + Custom.RESET);
			String Vill = sc.next();
			CreateGPMCase.CreateGPM(name, email, contact, password, Vill);

			BDOMethods();
		}
		break;
		case 4 : {

			ViewAllGPMCase.ViewAllGPM();
			BDOMethods();
		}
		break;
		case 5 : {

			System.out.println(Custom.ORANGE + "Enter Project ID number" + Custom.RESET);
			int pid =sc.nextInt();
			System.out.println(Custom.ORANGE + "Enter GPM ID number" + Custom.RESET);
			int gid = sc.nextInt();
			AllocateProjectToGPMCase.AllocateProject(pid, gid);

			BDOMethods();
		}
		break;
		case 6 : {
			ViewAllEmployeesWorkDetailsCase.AllEmployeeDetails();
			BDOMethods();
		}
		break;
		case 7 : BDOOrGPM();
		break;	
		case 8 : {
			System.out.println(Custom.ROSY_PINK + "Thank you ! Visit again" + Custom.RESET);
			System.exit(0);
		}
	}
}
static void GPMLogin() {

	System.out.println(Custom.ORANGE+  "Enter username" + Custom.RESET);
	String username = sc.next();
	
	System.out.println(Custom.ORANGE + "Enter password" + Custom.RESET);
	String password = sc.next();
	Boolean result = GPMLoginCase.GPMLogin(username,password);

	if(result==true) GPMServer();
	else GPMLogin();
}
static void GPMServer() { 	
	System.out.println(Custom.PURPLE + "+-----------------------------------------------------------------------------------------+" + "\n"
			                                + "|  Welcome to GPM  Account                                                                |" + "\n"
			                                + "| 1. Create Employee                                                                      |" + "\n"
			                                + "| 2. View the Details of Employee.                                                        |" + "\n"
			                                + "| 3. Assign Employee to a Project.                                                        |" + "\n"
			                                + "|                                                                                         |" + "\n"
			                                + "| 4. Back To Login Page.                                                                  |" + "\n"
			                                + "| 5. EXIT                                                                                 |" + "\n"
			                                + "+-----------------------------------------------------------------------------------------+" + Custom.RESET);
	try {
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if (choice == 1) {

			System.out.println(Custom.ORANGE + "Enter Employee name" + Custom.RESET);
			String name = sc.next();
			
			System.out.println(Custom.ORANGE + "Enter Contact Number" + Custom.RESET);
			String contact = sc.next();
			
			
			System.out.println(Custom.ORANGE + "Enter Address of Employee" + Custom.RESET);
			String Address = sc.next();
			CreateEmployeeCase.CreateEmpl(name, contact, Address);

			GPMServer();
		}
		else if (choice == 2) {
//			customerSignup();
			ViewAllEmplCase.AllEmployeeDetails();
			GPMServer();
		}
		else if (choice == 3) {

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
			AssignEmployeesToProjectCase.EmpOnProject(pid, eid, start, end, Wages);
			GPMServer();
		}
//		else if (choice == 4) {
////			customerSignup();
//			GPMServer();
//		}
		else if (choice == 4) {
     		BDOOrGPM();

		}
		else if (choice == 5) {

			System.out.println(Custom.ROSY_PINK + "Thank you ! Visit again" + Custom.RESET);
			System.exit(0);
		}
		else {
			System.out.println(Custom.RED_BACKGROUND + "Please choose a number from below options" + Custom.RESET);
			GPMLogin();
		}
	}
	catch (InputMismatchException e) {
		System.out.println(Custom.RED_BACKGROUND + "Input type should be number" + Custom.RESET);
		GPMLogin();
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//AssignEmployeesToProjectCase.EmpOnProject();
		BDOOrGPM();

	}

}
