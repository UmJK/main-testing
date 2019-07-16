package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//ResultSet r = s.executeQuery("Select* from Employee");
		//stmt.executeUpdate("Insert into Employee values('James',24,5545)";
		//execution happened failed then - exception
		Product p  =  new Product("Hair Oil",(float) 50001.0,250);
		ProductDao pd = new ProductDao();
//		int generatedId  =  pd.save(p);
//		System.out.println(generatedId);
		//Product pp = pd.findById(1);
		List<Product> all = pd.findAll() ;
		all.forEach(System.out::println);
		
		
		
	}

}

