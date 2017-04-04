/**
 * 
 */
package rtw.exception.gererSite;

/**
 * @author souleymane
 * Gestion des exceptions de doublon
 *
 */
public class DoublonException extends DaoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8866852160658895995L;
	public static final String MESSAGE1 = "Le user existe déjà en base";
	public static final String MESSAGE2 = "Le profil existe déjà en base";
	public static final String MESSAGE3 = "Le ou les droits existent déjà en base";
	/**
	 * 
	 */
	public DoublonException() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DoublonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param cause
	 */
	public DoublonException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 */
	public DoublonException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cause
	 */
	public DoublonException(Throwable cause) {
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
	 * @return the message1
	 */
	public static String getMessage1() {
		return MESSAGE1;
	}
	/**
	 * @return the message2
	 */
	public static String getMessage2() {
		return MESSAGE2;
	}
	/**
	 * @return the message3
	 */
	public static String getMessage3() {
		return MESSAGE3;
	}
	

}
