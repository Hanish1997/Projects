package com.groupd.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupd.finalproject.bean.Customer;
import com.groupd.finalproject.bean.CustomerAccount;
import com.groupd.finalproject.bean.Login;

public class CustomerAccountDao {
	private JdbcTemplate template;

	//JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	public Customer getLoginId(String id){  
	    String sql="select * from javafinalproject.customertbl where customerId=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));  
	} 
	
	public int addAccount(CustomerAccount l,String bal) {

		//String sql = "insert javafinalproject.customeraccounttbl Set acctBalance = acctBalance + '"+  amount +  "';";
		String sql="insert into javafinalproject.customeraccounttbl(customerId,acctNo,acctType,acctBalance) values('"+l.getCustomerId()+"','"+l.getAcctNo()+"','"+l.getAcctType()+"','"+bal+ "');";  
	    //return template.update(sql); 
		try {
			return template.update(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
			// null if there is any error
			return -1;
		}
	}

	public List<CustomerAccount> getAllBalance(String loginId){  
	    return template.query("select * from javafinalproject.customeraccounttbl where customerId IN (select customerId from javafinalproject.customertbl where loginId = '"+loginId+"');" ,new RowMapper<CustomerAccount>(){  
        public CustomerAccount mapRow(ResultSet rs, int row) throws SQLException {  
        	CustomerAccount e=new CustomerAccount();
        	System.out.println("in getAllBalance");

        	System.out.println(rs.getString(1));
        	System.out.println(rs.getString(2));
        	System.out.println(rs.getString(3));
        	System.out.println(rs.getString(4));

	            e.setAcctNo(rs.getString(1));
	            e.setAcctType(rs.getString(2));  
	            e.setAcctBalance(rs.getString(3));  
	            e.setCustomerId(rs.getString(4));  
	         
	            
	            return e;  
	        }  
	    });  
	}  
	public int depositMoney(String BillerName,
			 String BillerAcctNo, String Amt, String CustomerId) {

		String sql = "Update javafinalproject.customeraccounttbl Set acctBalance = acctBalance + '"+Amt +"' where customerId  = '"+CustomerId+"';";
		try {
			return template.update(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
			// null if there is any error
			return -1;
		}
	}
	public int withdrawMoney(String BillerName,
			 String BillerAcctNo, String Amt, String CustomerId){

		String sql = "Update javafinalproject.customeraccounttbl Set acctBalance = acctBalance - '"+Amt +"' where customerId  = '"+CustomerId+ "' and acctNo ='"+BillerAcctNo+"';";
		try {
			return template.update(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
			// null if there is any error
			return -1;
		}
	}
	
	public int transferMoney(CustomerAccount l,String amount,String accWithdraw,String accDeposit) {
		String sql = "Update javafinalproject.customeraccounttbl Set acctBalance = acctBalance - '" +  amount + "','"+ "' where acctNo='"+  accWithdraw + "' and customerId='"
				+ l.getCustomerId() +  "' Update javafinalproject.customeraccounttbl Set acctBalance = acctBalance + '" + amount + "','"+ "' where acctNo='"+  accDeposit + "';";
		try {
			return template.update(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
			// null if there is any error
			return -1;
		}
	}
	
	public int payBill(  String BillerName,
			 String BillerAcctNo, String Amt, String CustomerId) {
		String sql = "Update javafinalproject.customeraccounttbl Set acctBalance = acctBalance - '"+Amt +"' where customerId  = '"+CustomerId+"';";
//		String sql = "insert into javafinalproject.customerbilltbl where amt = '"+  Amt + "' and customerId = '" +  CustomerId+ "' and billerName = '" +  BillerName+ "' and billerAccNo = '" +  BillerAcctNo + "';";

//		String sql = "insert into javafinalproject.customerbilltbl ( amt , customerId , billerName , billerAccNo) VALUES('"+txtUserID.getText()+"','"+txtPassword.getText()+"','"+txtFirstName.getText()+"','"+txtLastName.getText()+"','"+gender+"','"+txtBirthdate.getText()+"')");
		try {
			return template.update(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
			// null if there is any error
			return -1;
		}
	}
	
	public int payFees(CustomerAccount l,String amount) {
		String sql = "Update javafinalproject.customeraccounttbl Set acctBalance = acctBalance - '"+  amount + "' where acctNo='"+  l.getAcctNo() + "' and customerId='"
				+ l.getCustomerId() + "';";
		try {
			return template.update(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
			// null if there is any error
			return -1;
		}
	}
	 
}
