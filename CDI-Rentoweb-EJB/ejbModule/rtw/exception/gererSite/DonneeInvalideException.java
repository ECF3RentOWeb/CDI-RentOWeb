/**
 * 
 */
package rtw.exception.gererSite;

/**
 * @author Afpa
 *
 */
public class DonneeInvalideException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5497428954486395393L;
	
	public static final String MESSAGE1 = 
			"Le user que vous essayer d'ajouter a une ou des champs"
			+ " qui ne respectent pas les règles d'inscription";
	
	public static final String MESSAGE2 = 
			"Merci de bien vouloir vérifier que le profil comporte"
			 + " un identifiant et que le nom du profil est particulier ou professionnel";
	
	public static final String MESSAGE3 = " Les droits ne peuvent êtres null  "
			 + " au moins un type de droit  est requis";
	/**
	 * 
	 */
	public DonneeInvalideException() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DonneeInvalideException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param cause
	 */
	public DonneeInvalideException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 */
	public DonneeInvalideException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cause
	 */
	public DonneeInvalideException(Throwable cause) {
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
