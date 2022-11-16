package Avanish_MGNREA.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Avanish_MGNREA.Bean.Employees;
import Avanish_MGNREA.Exception.EmployeeException;
import Avanish_MGNREA.Exception.GPMException;
import Avanish_MGNREA.utility.DButil;

public class GPMDaoImpl implements GPMDao {

	@Override
	public String loginGPM(String email, String pass) throws GPMException {
		// TODO Auto-generated method stub
		String name = "Login Failed";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from GPM where email=? and password=?");

			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				name = "Login Succefull";
			else
				throw new GPMException("Invalid Email or Password..");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return name;
	}

	@Override
	public String createEmployee(Employees empl) {
		// TODO Auto-generated method stub
		String message = "Unable to create new Employee...";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into Employee(Emplname,Mobile,address) values(?,?,?)");

			ps.setString(1, empl.getName());
			ps.setString(2, empl.getMobile());
			ps.setString(3, empl.getAddress());

			int eu = ps.executeUpdate();

			if (eu > 0)
				message = empl.getName() + " is registered successfully as Employee.";

		} catch (SQLException e) {
//			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<Employees> viewAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employees> emplList = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Employee");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				emplList.add(new Employees(rs.getInt("EmplId"), rs.getString("EMPLName"), rs.getString("Mobile"),
						rs.getString("Address")));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return emplList;
	}

	@Override
	public String assignEmployeesToProject(int projectId, int EmployeeId, String Start_date,String End_date, int wages ) throws EmployeeException {
		// TODO Auto-generated method stub
		String message = "Not Allocated...!";
		String proj_name = "";
		String empl_name = "";

		try (Connection conn = DButil.provideConnection()) {

			PreparedStatement ps1 = conn.prepareStatement("select emplname from Employee where emplid=?");

			ps1.setInt(1, EmployeeId);

			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {
				empl_name = rs1.getString("emplname");

				PreparedStatement ps2 = conn.prepareStatement("select pname from project where PROJECTiD=?");
				ps2.setInt(1, projectId);

				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {
					proj_name = rs2.getString("pname");

					PreparedStatement ps3 = conn.prepareStatement("insert into EMP_Project values(?,?,?,?,?)");
					ps3.setInt(1, projectId);
					ps3.setInt(2, EmployeeId);
                    ps3.setString(3, Start_date);
                    ps3.setString(4, End_date);
                    ps3.setInt(5,wages);
					int eu = ps3.executeUpdate();

					if (eu > 0)
						message = EmployeeId + " Employee assigned to " + projectId + " Project Successfully...";
					else
						throw new EmployeeException("Something went wrong...!");
				} else
					throw new  EmployeeException("Invalid Project Id...!");
			} else
				throw new  EmployeeException("Invalid Employee Id...2");

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}


}
