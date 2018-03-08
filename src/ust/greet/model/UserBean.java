package ust.greet.model;

import java.sql.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import ust.greet.utility.Security;

public class UserBean {
	
	private String fName;
	private String lName; 
	private String gasType;
	private double nLiters;
	private String paymentType;
	private String cardNum;
	private double purchaseAmt;
	private double vatAmt;
	private double totalAmt;
	private double basePrice;
	
	private String event;
	
	
	private Connection connection;
	
	public UserBean() {
		
	}

	public UserBean(Connection connection, String fName, String lName, String gasType, double nLiters, String paymentType, String cardNum,
			double basePrice, double purchaseAmt, double vatAmt, double totalAmt) {
		
		this.fName = fName;
		this.lName = lName;
		this.gasType = gasType;
		this.nLiters = nLiters;
		this.paymentType = paymentType;
		this.cardNum = cardNum;
		this.basePrice = basePrice;
		this.purchaseAmt = purchaseAmt;
		this.vatAmt = vatAmt;
		this.totalAmt = totalAmt;
		this.connection = connection;
		
	}

	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getGasType() {
		return gasType;
	}
	
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	
	public double getnLiters() {
		return nLiters;
	}
	
	public void setnLiters(double nLiters) {
		this.nLiters = nLiters;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getCardNum() {
		return cardNum;
	}
	
	public void setCardNum(String ccNumber) {
		this.cardNum = ccNumber;
	}
	
	public double getPurchaseAmt() {
		return purchaseAmt;
	}

	public void setPurchaseAmt(double purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}

	public double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(double vatAmt) {
		this.vatAmt = vatAmt;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public boolean insertRecord() {
		String sql = "insert into gasoline (fname, lname, gasType, nLiters, paymentType, cardNum, basePrice, purchaseAmt, vatAmt, totalAmt) values (?,?,?,?,?,?,?,?,?,?)";
		boolean isSuccess = false;
		try {
//			granting that connection is not null
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, Security.encrypt(this.fName));
			pstmt.setString(2, Security.encrypt(this.lName));
			pstmt.setString(3, this.gasType);
			pstmt.setDouble(4, this.nLiters);
			pstmt.setString(5, this.paymentType);
			pstmt.setString(6, Security.encrypt(this.cardNum));
			pstmt.setDouble(7, this.basePrice);
			pstmt.setDouble(8, this.purchaseAmt);
			pstmt.setDouble(9, this.vatAmt);
			pstmt.setDouble(10, this.totalAmt);
			
			pstmt.executeUpdate(); //commit this to database
			isSuccess = true;
		}catch (SQLException sqle){
			System.err.println(sqle.getMessage());
		}
		return isSuccess;
	}
	
	public boolean insertAudit() {
		String sql = "insert into auditlogs (event) values (?)";
		boolean isSuccess = false;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			this.event = Security.encrypt(this.fName + " " + this.lName + " purchased " + this.nLiters + " liters of " +
					this.gasType + " gasoline with a total amount of Php" + this.totalAmt + " using " + this.paymentType + " " + this.cardNum);
			pstmt.setString(1, this.event);
			
			pstmt.executeUpdate();
			isSuccess = true;
			
			System.out.println(Security.decrypt(this.event));
		}catch (SQLException sqle){
			System.err.println(sqle.getMessage());
		}
		return isSuccess;
	}
	
	public static boolean luhnTest(String number){
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }
	
	public static String maskCardNumber(String cardNumber, String mask) {

	    // format the number
	    int index = 0;
	    StringBuilder maskedNumber = new StringBuilder();
	    for (int i = 0; i < mask.length(); i++) {
	        char c = mask.charAt(i);
	        if (c == '#') {
	            maskedNumber.append(cardNumber.charAt(index));
	            index++;
	        } else if (c == 'x') {
	            maskedNumber.append(c);
	            index++;
	        } else {
	            maskedNumber.append(c);
	        }
	    }

	    // return the masked number
	    return maskedNumber.toString();
	}
} 
