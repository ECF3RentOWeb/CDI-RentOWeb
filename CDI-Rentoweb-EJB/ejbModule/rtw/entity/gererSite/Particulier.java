/**
 * 
 */
package rtw.entity.gererSite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author souleymane
 * @see: user.java
 * @version 1
 * Un particulier est un User
 * voir la classe User pour plus de détails
 *
 */
@Entity
@Table(name="particulier")
public class Particulier extends User implements Serializable{

	/**
	 * @serial Numéro auto généré
	 */
	private static final long serialVersionUID = 6465790873182035796L;

	/**
	 * 
	 */
	public Particulier() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param identifier
	 * @param email
	 * @param password
	 * @param resetPassword
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Particulier(int identifier, String email, String password, String resetPassword, String firstName,
			String lastName, int phoneNumber) {
		super(identifier, email, password, resetPassword, firstName, lastName, phoneNumber);
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Particulier [toString()=" + super.toString() + "]";
	}
	
	
	

	

}
