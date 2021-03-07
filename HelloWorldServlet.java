package org.upec.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter() ;
		out.println("<html>") ;
		out.println("<head>") ;
		out.println("<title>Hello words From a servlet!!!!!!</title>") ;
		
		//firstName
		out.println("<label for="+"firstName"+">firstName <span class="+"requis"+">:</span></label>");
		out.println("<input type="+"text"+" id="+"firstName" +"name="+"firstName" +"value="+" size="+"20" +"maxlength="+"60" +"/>");
        
		out.println("</head>") ;
		out.println("<body>") ;
		out.println("<h1>Hello words From a servlet!!!!!!</h1>") ;
		out.println("</body>") ;
		out.println("</html>"); 
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	}

}
