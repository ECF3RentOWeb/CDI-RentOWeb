/**
 * 
 */
package rtw.entity.gererSite;

import javax.persistence.Entity;

/**
 * @author Afpa
 *
 */
@Entity
public class Particulier extends User{

	/**
	 * @serial Numéro auto généré
	 */
	private static final long serialVersionUID = 6465790873182035796L;

	/**
	 * 
	 */
	public Particulier() {
		super();
		// Voir la classe mère User
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
		// voir la classe mère User
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
