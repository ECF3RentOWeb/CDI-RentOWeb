package rtw.exception.gererAvis;

public class DoublonAvisException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 180044693974298339L;
	
	public DoublonAvisException(Throwable cause){
		
		super("Doublon Dans la base de données",cause);
		
	}

}
