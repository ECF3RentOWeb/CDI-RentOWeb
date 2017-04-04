/**
 * 
 */
package rtw.entity.gererSite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Souleymane
 * @version 1
 * @see User.java
 * Voir la classe User.java pour plus de détails
 *
 */
@Entity
@Table(name="professionnel")
public class Professionnel extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7333784320205328620L;


	/**
	 * 
	 */
	public Professionnel() {
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
	public Professionnel(int identifier, String email, String password, String resetPassword, String firstName,
			String lastName, int phoneNumber) {
		super(identifier, email, password, resetPassword, firstName, lastName, phoneNumber);
		// TODO Auto-generated constructor stub
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
		return "Professionnel [toString()=" + super.toString() + "]";
	}

	
}
