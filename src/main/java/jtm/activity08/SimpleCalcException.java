package jtm.activity08;

public class SimpleCalcException extends Exception {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6179282700169273374L;

	public SimpleCalcException(String string){
		super(string);
	}
	
	public SimpleCalcException(String string, Exception cause) {
		super(string, cause);
	}
}
