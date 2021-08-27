package com.groupd.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.groupd.finalproject.bean.Customer;
import com.groupd.finalproject.bean.Login;

public class LoginDao {


	private JdbcTemplate template;
	public static final int USER_ALREADY_EXISTS = -4;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
//	@ModelAttribute("Login")
	public Login validateUser(Login l) {

		String sql = "select * from javafinalproject.logintbl where LoginId='" + l.getLoginId() + "' and Password='"
				+ l.getPassword() + "';";
		try {
			
				return template.query(sql, new ResultSetExtractor<Login>() {

					public Login extractData(ResultSet rs) throws SQLException, DataAccessException {

						Login u = new Login();

						rs.next();
						u.setLoginId(rs.getString("LoginId"));
						u.setPassword(rs.getString("Password"));
						
						return u;
					}
				});
		
		} catch (Exception e) {
			System.out.println(e+"------------------------- in exception e");
			e.printStackTrace();
			// null if there is any error
			return null;
		}
	}
	public int registerUser(Login l) {

		String sql = "insert into javafinalproject.logintbl(LoginId,Password) values('" + l.getLoginId() + "','"
				+ l.getPassword() + "');";
		System.out.print(sql);
		try {
			return template.update(sql);
		} catch (DuplicateKeyException e) {
			return USER_ALREADY_EXISTS;
		} catch (Exception e) {
			return -1;
		}
	}
	

}
