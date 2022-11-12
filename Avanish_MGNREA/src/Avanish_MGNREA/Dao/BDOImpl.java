package Avanish_MGNREA.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Avanish_MGNREA.Bean.EMP_Project;
import Avanish_MGNREA.Bean.GPM;
import Avanish_MGNREA.Bean.Projects;
import Avanish_MGNREA.Exception.BDOException;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.Exception.GPMException;
import Avanish_MGNREA.utility.DButil;

public class BDOImpl implements BDO {

	@Override
	public String BDOLogin(String username, String password) {
		// TODO Auto-generated method stub
String message = "Invalid username or password";
		
		if (username.equals(BDO.username) && password.equals(BDO.password)) {
			 message = "Login Successfull";
		}
		
		return message;
	}

	@Override
	public String createProject(Projects project) {
		// TODO Auto-generated method stub
		String message = "Unable to create project...";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into project(ProjectID,PName) values(?,?)");

			ps.setInt(1, project.getProject_Id());
			ps.setString(2, project.getName());
			
			int x = ps.executeUpdate();

			if (x > 0)
				message = project.getName() + " project Created Successfully";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<Projects> viewAllProjects() throws BDOException {
		// TODO Auto-generated method stub
		List<Projects> projectList = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from project");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				projectList.add(new Projects(rs.getInt("ProjectID"), rs.getString("PName")));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return projectList;
	}

	@Override
	public String createGPM(GPM gpm) {
		// TODO Auto-generated method stub
		String message = "Unable to create new Gram Panchayat Member(GPM)...";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into GPM(Name,Email,Mobile,Password,Villege) values(?,?,?,?,?)");

			ps.setString(1, gpm.getName());
			ps.setString(2, gpm.getEmail());
			ps.setString(3, gpm.getMobile());
			ps.setString(4, gpm.getPassword());
			ps.setString(4, gpm.getVillege());

			int eu = ps.executeUpdate();

			if (eu > 0)
				message = gpm.getName() + "is registered successfully as GPM.";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<GPM> viewAllGPM() throws GPMException {
		// TODO Auto-generated method stub
		List<GPM> gpmList = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from GPM");

			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				gpmList.add(new GPM(rs.getInt("GPM_ID"), rs.getString("NAME"), rs.getString("EMAIL"), 
						rs.getString("MOBILE"), rs.getString("PASSWORD"),rs.getString("Villege")));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return gpmList;
	}
	@Override
	public String allocateProjectToGPM(int projectId, int GPMId) throws BDOException,GPMException,EmployeeException{
		String message = "Not Allocated";
		String proj_name = "";
		String gpm_name = "";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps1 = conn.prepareStatement("select name from GPM where GPM_ID=?");

			ps1.setInt(1, GPMId);

			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {
				gpm_name = rs1.getString("NAME");

				PreparedStatement ps2 = conn.prepareStatement("select pname from project where PROJECTID=?");
				ps2.setInt(1, projectId);

				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {
					proj_name = rs2.getString("PNAME");

					PreparedStatement ps3 = conn.prepareStatement("insert into GPM_PROJECT values(?,?)");
					ps3.setInt(1,projectId );
					ps3.setInt(2, GPMId);

					int eu = ps3.executeUpdate();

					if (eu > 0) {
						message = "Project allocated";
					}else {
						throw new BDOException("Something went wrong...!");
						}
				} else
					throw new EmployeeException("Invalid Project Id...!");
			} else
				throw new GPMException("Invalid GPM Id...!");

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}
@Override
public List<EMP_Project> viewAllEmployeesWorkDetails()throws EmployeeException{
	List<EMP_Project> epmList = new ArrayList<>();
	try (Connection conn = DButil.provideConnection()) {

		PreparedStatement ps = conn.prepareStatement(" select * from employee e inner join  project p inner join emp_project ep on e.emplid=ep.emplid And p.projectid=ep.projectid;");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			epmList.add(new EMP_Project(rs.getInt("ProjectID"), rs.getInt("EmplId"), rs.getString("Start_date"), 
					rs.getString("End_date"),rs.getInt("Wages")));
		}

	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}

	return epmList;
}

}
