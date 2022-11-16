package Avanish_MGNREA.Usecases;
import java.util.Scanner;

import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;
import Avanish_MGNREA.custom.Custom;
public class BDOLoginUseCase {
public static  boolean BDOLogin(String username, String password) {

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
