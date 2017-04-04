/**
 * 
 */
package rtw.exception.gererSite;

/**
 * @author admin
 *
 */
public class NonTrouveException extends DaoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6032755217061197992L;
	
	public static final String MESSAGE = "l'objet en question n'existe pas";

	/**
	 * 
	 */
	public NonTrouveException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NonTrouveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NonTrouveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NonTrouveException(String message) {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NonTrouveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the message
	 */
	public  String getMessage() {
		return MESSAGE;
	}

	
}
