package com.visa.training.web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.Product;
import com.visa.training.jdbc.ProductDao;
@WebServlet("/createproduct")
public class Createproduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("n1");
		String s2 = request.getParameter("n2");
		String s3 = request.getParameter("n3");
		Product p = new Product();
		ProductDao pd = new ProductDao();
		p.setName(s1);
		p.setPrice((Float.parseFloat(s2)));
		p.setQoh(Integer.parseInt(s3));
		int generated_id = pd.save(p);
		System.out.println("Crated product with id"+generated_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
