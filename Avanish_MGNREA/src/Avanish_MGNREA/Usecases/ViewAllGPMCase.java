package Avanish_MGNREA.Usecases;

import java.util.List;

import Avanish_MGNREA.Bean.GPM;

import Avanish_MGNREA.Dao.BDO;
import Avanish_MGNREA.Dao.BDOImpl;

import Avanish_MGNREA.Exception.GPMException;
import Avanish_MGNREA.custom.Custom;

public class ViewAllGPMCase {
	public static void ViewAllGPM() {
		
	BDO dao=new BDOImpl();

	// TODO Auto-generated constructor stub

	try {
		List<GPM> p1=dao.viewAllGPM();
		if(!p1.isEmpty())
		for(GPM p:p1) System.out.println(Custom.GREEN_BACKGROUND+"GPM name is:- "+ p.getName()+" ,His ID Number is :- "+p.getGPM_Id()+" ,His Email id is :- "+p.getEmail()+" , You Can Contact Him at :- "+p.getMobile()+" And He belong to:- "+p.getVillege()+" Villege "+Custom.RESET);
		else System.out.println(Custom.RED_BACKGROUND+"NO ANY GPM IS ThERE IN THIS VILLEGE"+Custom.RESET);
	} catch (GPMException e) {
		// TODO Auto-generated catch block
		System.out.println(Custom.RED_BACKGROUND+e.getMessage()+Custom.RESET);
//		e.printStackTrace();
	}

}
}
