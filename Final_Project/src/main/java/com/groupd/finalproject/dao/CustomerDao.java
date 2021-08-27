package com.groupd.finalproject.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.groupd.finalproject.bean.Customer;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerDao {
	JdbcTemplate template;
	 public void setTemplate(JdbcTemplate template) {
		 this.template = template;
		 }
	 
		 public int save(Customer cust) {
//			 String sql ="Insert into customertbl(customerId,name,address,state,country,postalCode,loginId)"
//				  		+ "values('"+cust.getCustomerId()+"','"+cust.getName()+"','"+cust.getAddress()+"','"+cust.getState()+"','"+cust.getCountry()+"','"+cust.getPostalCode()+"','"+cust.getLoginId()+"')";
//				  		return template.update(sql);
			 String sql =  "insert into javafinalproject.customertbl(customerId,name,address,state,country,postalCode,loginId) values ('" + cust.getCustomerId() + "','"
						+ cust.getName() + "','" + cust.getAddress() + "','" + cust.getState() + "','" + cust.getCountry() + "','" + cust.getPostalCode() + "','" + cust.getLoginId() + "');";
			 return template.update(sql);
		 }

//		 "insert into javafinalproject.customertbl(customerId,name,address,state,country,postalCode,loginId) values ('" + cust.getCustomerId() + "','"
//			+ cust.getName() + "','" + cust.getAddress() + "','" + cust.getState() + "','" + cust.getCountry() + "','" + cust.getPostalCode() + "','" + cust.getLoginId() + "');";
//		 
		 
		 
//		 String sql = "insert into javafinalproject.logintbl(LoginId,Password) values('" + l.getLoginId() + "','"
//					+ l.getPassword() + "');";
//			System.out.print(sql);
//			try {
//				return template.update(sql);
//			} catch (DuplicateKeyException e) {
//				return USER_ALREADY_EXISTS;
//			} catch (Exception e) {
//				return -1;
//			}
		 public Customer getCustById(String id){  
			    String sql="select * from javafinalproject.customertbl where customerId=?";  
			    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));  
			}  
		 
//		 +  l.getAcctNo() + "' and customerId='" + l.getCustomerId() + "';";
//			
		 
		 public int updateCustomer(Customer cust) {
			    String sql="update javafinalproject.customertbl set name='"+cust.getName()+"', address='"+cust.getAddress()+"',state='"+cust.getState()+"', country='"+cust.getCountry()+"',postalCode='"+cust.getPostalCode()+"' where customerId='"+cust.getCustomerId()+ "';";  
			 	return template.update(sql);
		 }
		 
		 
		 public int deleteCustomer(int id){  
			    String sql="delete from javafinalproject.customertbl where customerId='"+id+"';";  
			    return template.update(sql);  
			} 
		 public List<Customer> getCustomer(Customer cust){  
			    return template.query("select * from javafinalproject.customertbl where loginId =  '"+cust.getLoginId()+"';",new RowMapper<Customer>(){  
			        public Customer mapRow(ResultSet rs, int row) throws SQLException {  
			            Customer cuser=new Customer();  
			            cuser.setCustomerId(rs.getString("customerId"));
			    	    cuser.setName(rs.getString("name"));
			    	    cuser.setAddress(rs.getString("address"));
			    	    cuser.setState(rs.getString("state"));
			    	    cuser.setCountry(rs.getString("country"));
			    	    cuser.setPostalCode(rs.getString("postalCode"));
			    	    cuser.setLoginId(rs.getString("loginId"));
			    	   

			    	    return cuser;
			        }  
			    });
		 }
		 
	 }


//
//class UserMapper implements RowMapper<Customer> {
//
//	  public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
//	    Customer cuser = new Customer();
//
//	    cuser.setCustomerId(rs.getString("id"));
//	    cuser.setName(rs.getString("name"));
//	    cuser.setAddress(rs.getString("address"));
//	    cuser.setState(rs.getString("state"));
//	    cuser.setCountry(rs.getString("country"));
//	    cuser.setPostalCode(rs.getString("postalcode"));
//	   
//
//	    return cuser;
//	  }
//	}

