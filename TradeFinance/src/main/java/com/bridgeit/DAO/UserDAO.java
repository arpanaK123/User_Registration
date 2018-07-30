package com.bridgeit.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bridgeit.model.UserModel;

@Repository
public class UserDAO {
	@Autowired
	private DataSource datasource;

	public int inserData(UserModel userModel) {

		String query = "insert into login (id,name, email,city,role) values (?,?,?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);

		Object[] args = new Object[] { userModel.getId(), userModel.getName(), userModel.getEmail(),
				userModel.getCity(), userModel.getRole() };

		int out = jdbcTemplate.update(query, args);

		if (out != 0) {
			System.out.println("Employee saved ");
		} else {
			System.out.println("Employee save failed");
		}
		return out;
	}
	//
	// public boolean checkEmailPresent(UserModel userModel) {
	// System.out.println("userModel: "+userModel);
	// List<UserModel> user = new ArrayList<UserModel>();
	// String query = "select email from login where email = ?";
	// JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
	// Object[] args = new Object[] { userModel.getEmail() };
	// String name = jdbcTemplate.queryForObject(query, new Object[] {
	// userModel.getEmail() }, String.class);
	// return name != null;
	//
	// }

	public int userPresentOrNot(UserModel userModel) {
		String query = "insert into login (password) values(?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		Object[] args = new Object[] { userModel.getPassword() };
		int out = jdbcTemplate.update(query, args);

		if (out != 0) {
			System.out.println("password saved");
		} else {
			System.out.println("u r not a registered person");
		}
		return out;

	}

	public int insertLoginData(UserModel userModel) {
		String query = "insert into login (email,password) values (?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		Object[] args = new Object[] { userModel.getPassword() };
		int out = jdbcTemplate.update(query, args);
		if (out != 0) {
			System.out.println("password saved ");
		} else {
			System.out.println(" failed");
		}
		return out;

	}

}
