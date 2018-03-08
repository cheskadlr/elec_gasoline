package ust.greet.utility;

public class InvalidCreditCardNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCreditCardNumberException(String s)
    {
        // Call constructor of parent Exception
        super(s);
        
        System.err.print("InvalidCreditCardNumberException thrown: ");
    }
	
}
