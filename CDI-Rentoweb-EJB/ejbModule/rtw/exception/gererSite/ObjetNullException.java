/**
 * 
 */
package rtw.exception.gererSite;

import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;

/**
 * @author admin
 *
 */
public class ObjetNullException extends DaoException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2623020152108319486L;
	public static final String MESSAGE1 = "le user est null ";
	public static final String MESSAGE2 = "le profil est null ";
	public static final String MESSAGE3 = "le droit est null ";

	
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ObjetNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param cause
	 */
	public ObjetNullException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 */
	public ObjetNullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param cause
	 */
	public ObjetNullException(Throwable cause) {
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
	/**
	 * 
	 */	
	public ObjetNullException(){
		super();
		User user = null;
		Profil profil = null;
		Droit droit = null;
		if (user == null) {
			try {
				throw new ObjetNullException(MESSAGE1);
			} catch (ObjetNullException e) {
				e.printStackTrace();
			}				
		}
		if (profil == null) {
			try {
				throw new ObjetNullException(MESSAGE2);
			} catch (ObjetNullException e) {
				e.printStackTrace();
			}			
		}
		if (droit == null) {
			try {
				throw new ObjetNullException(MESSAGE3);
			} catch (ObjetNullException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	
	
	
	

}
