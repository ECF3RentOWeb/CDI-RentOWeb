/**
 * 
 */
package rtw.entity.gererSite;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Afpa
 *
 */
@Entity
@Table(name="professionnel")
public class Professionnel extends User{

	/**
	 * @serial auto généré
	 */
	private static final long serialVersionUID = 4148300080304626778L;

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
