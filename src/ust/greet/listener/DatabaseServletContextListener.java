package ust.greet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import javax.servlet.*;

import java.sql.*;

import ust.greet.utility.Security;

@WebListener
public class DatabaseServletContextListener 
	implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servlet content initialized executed");
		
		ServletContext context = sce.getServletContext();
		
		try {
			Class.forName(Security.decrypt(context.getInitParameter("jdbcDriver")));
			
			Connection connection = DriverManager.getConnection(
				Security.decrypt(context.getInitParameter("jdbcUrl")),
				Security.decrypt(context.getInitParameter("dbUserName")),
				Security.decrypt(context.getInitParameter("dbPassword")));
			
			if (connection != null) {
				System.out.println("Connection successful.");
				
//				Store the connection object in the ServletContext
				sce.getServletContext().setAttribute("dbconn", connection);
			} else {
				System.err.println("Connection failed.");
			}
		} catch (ClassNotFoundException cfne) {
			System.err.println(cfne.getMessage());
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("servlet content destroyed executed");
	}
}
