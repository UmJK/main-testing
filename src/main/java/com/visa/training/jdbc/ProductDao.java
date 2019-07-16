package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao 
{
	public int save (Product p) 
	{
		//insert
		int generatedId = 4;
		try (Connection c =JdbcUtil.getConnection()){    //try with resources
			String pSql ="insert into product (product_name,product_price,product_qoh) values(?,?,?)";
			PreparedStatement s = c.prepareStatement(pSql,Statement.RETURN_GENERATED_KEYS);
			s.setString(1, p.getName());
			s.setFloat(2, p.getPrice());
			s.setInt(3, p.getQoh());	
			s.executeUpdate();
			
			ResultSet keys = s.getGeneratedKeys();
			keys.next();
			generatedId = keys.getInt(1);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return generatedId;
	}
	public Product findById(int id) throws SQLException
	{
		Product p = null;
		try (Connection c =JdbcUtil.getConnection()){
			
			///////rather use optional than  null;
			PreparedStatement s = c.prepareStatement("Select * from product where product_id = ? ");
			s.setInt(1,id);

			ResultSet rs = s.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getInt(4));
				mapRow(rs);
				return p;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return p;
		//read on based on ID
	}
	private Product mapRow(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setPrice(rs.getFloat(3));
		p.setQoh(rs.getInt(4));
		return p;
	}
	public List<Product> findAll(){
	// read all
		Connection c =JdbcUtil.getConnection();
		Product p = new Product();
		List <Product>all = new ArrayList<>();
		try (Connection c1 =JdbcUtil.getConnection()){
			
			Statement s = c1.createStatement();
			String query = "Select * from product";
			System.out.println(query);
			ResultSet rs = s.executeQuery(query);
			while(rs.next())
			{
				Product aProduct = mapRow(rs);
				all.add(aProduct);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return all;
		
	}
	/* public remove(int id) {
		
	}
	public void update(Product updated)
	{
		
	}*/
}
