package ust.greet.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import ust.greet.model.UserBean;
import ust.greet.utility.InvalidCreditCardNumberException;

public class GreetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String gasType = request.getParameter("gasType");
		double nLiters = Double.parseDouble(request.getParameter("nLiters"));
		String paymentType = request.getParameter("paymentType");
		String cardNum = request.getParameter("cardNum");
		Double basePrice = 0.0;
		
		try {
			if(UserBean.luhnTest(cardNum) == true) {
				if((paymentType.equals("Visa")) && cardNum.startsWith("4") || 
				  ((paymentType.equals("Mastercard")) && cardNum.startsWith("5")) ||
				  ((paymentType.equals("Amex")) && (cardNum.startsWith("34") || cardNum.startsWith("37"))) || 
				  (paymentType.equals("Diners") && (cardNum.startsWith("30") || cardNum.startsWith("36") ||
						  					        cardNum.startsWith("38") || cardNum.startsWith("39"))) ||
				  (paymentType.equals("Jcb") && (cardNum.startsWith("2") || cardNum.startsWith("1") || cardNum.startsWith("35"))) ||
				  (paymentType.equals("Paymaya")) && cardNum.startsWith("4834") || 
				  (paymentType.equals("Gcash")) && cardNum.startsWith("5268")
				 ){
					
					if(gasType.equals("Unleaded")) {
						basePrice =  54.00;
					}else if(gasType.equals("Diesel")) {
						basePrice = 41.00;
					}else {
						basePrice = 58.00;
					}
					
					Double purchaseAmt = basePrice * nLiters;
					Double vatAmt = purchaseAmt * .12;
					Double totalAmt = purchaseAmt + vatAmt;
									
					if (cardNum.length() == 16) {
						cardNum = UserBean.maskCardNumber(cardNum, "xxxx-xxxxxx-####");
					}else if(cardNum.length() == 14) {
						cardNum = UserBean.maskCardNumber(cardNum, "xxxx-xxxxxx-####");
					}else if(cardNum.length() == 15) {
						cardNum = UserBean.maskCardNumber(cardNum, "xxxx-xxxxxx-#####");
					}else if(cardNum.length() == 13) {
						cardNum = UserBean.maskCardNumber(cardNum, "xxxx-xxxxx-####");
					}
					
					UserBean userBean = new UserBean((Connection) getServletContext().getAttribute("dbconn"),
														fName,lName, gasType, nLiters, paymentType, cardNum, basePrice, purchaseAmt, vatAmt, totalAmt);
					
					userBean.insertRecord();
					userBean.insertAudit();
										
					//create a new session
					HttpSession session = request.getSession();
					
					//perform a programmatic timeout to 30 seconds
					session.setMaxInactiveInterval(30);
											
					//binding the user object to request attribute*/
					session.setAttribute("user", userBean);
					
					getServletContext().getRequestDispatcher("/display.jsp")
						.forward(request, response);
					
					getServletContext().getRequestDispatcher("/audit.jsp")
					.forward(request, response);
				  }else {
					  throw new InvalidCreditCardNumberException("\"Invalid credit card number and type combination\"");
				  }
			}else {;
				throw new InvalidCreditCardNumberException("\"Invalid credit card number\"");
			}
		}catch(InvalidCreditCardNumberException e) {
			HttpSession session = request.getSession();
			session.setAttribute("message", e.getMessage());
			System.err.println("Caught " + e.getMessage());
			getServletContext().getRequestDispatcher("/error.jsp")
			.forward(request, response);
		}
	}
}
