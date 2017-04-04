/**
 * 
 */
package rtw.clientServer.gererSite;

/**
 * @author Souleymane
 *
 */
public class UserException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3526216641770015501L;
	private int code;
	/**
	 * @param message
	 * @param code
	 */
	public UserException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	/**
	 * @param message
	 */
	public UserException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @param code
	 */
	public UserException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}
	/**
	 * @param message
	 * @param cause
	 * @param code
	 */
	public UserException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
