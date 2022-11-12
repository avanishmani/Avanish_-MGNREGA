package Avanish_MGNREA.Usecases;
import java.util.Scanner;

import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.custom.Custom;
public class BDOLoginUseCase {
public static  boolean BDOLogin() {
	Scanner sc=new Scanner(System.in);
	System.out.println(Custom.ORANGE+  "Enter username" + Custom.RESET);
	String username = sc.next();
	
	System.out.println(Custom.ORANGE + "Enter password" + Custom.RESET);
	String password = sc.next();
	sc.close();
	BDO dao=new BDOImpl();
	String result=dao.BDOLogin(username, password);
	if (result.equals("Login Successfull")){
	System.out.println(Custom.GREEN_BACKGROUND + result + Custom.RESET);
	return true;
}
else {
	System.out.println(Custom.RED_BACKGROUND + result + Custom.RESET);
	return false;
}
	
}
}
