/**
 * 
 */
package rtw.entity.gererSite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Souleymane
 * @version Première version
 * La classe de référence pour un compte utilisateur
 * Tous les utilisateurs devrons avoir au moins ces attributs
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="user")
public abstract class User implements Serializable{
	/**
	 * @serial Numéro auto généré
	 */
	private static final long serialVersionUID = 2782130596881117904L;
	@Id
	private int identifier;
	@Column(name = "email",length=30, nullable = false)
	private String email;
	@Column(name = "password",length=20, nullable = false)
	private String password;
	@Column(name = "resetPassword",length=20, nullable = false)
	private String resetPassword;
	@Column(name = "firstName",length=30, nullable = false)
	private String firstName;
	@Column(name = "LastName",length=30, nullable = false)
	private String lastName;
	@Column(name = "phoneNumber",length=10, nullable = false)
	private int phoneNumber;
	/**
	 * 
	 */
	public User() {
		super();
	}
	/**
	 * @param identifier C'est la clef d'un utilisateur, elle unique
	 * @param email La forme et la longueur de l'émail doivent être vérifiées
	 * @param password Le mot de passe est obligatoire lors de la création d'un utilisateur
	 * @param resetPassword 
	 * @param firstName Le prénom de l'utilisateur
	 * @param lastName  Le nom de famille de l'utilisateur
	 * @param phoneNumber Le numéro de téléphone est obligatoire
	 * @since 13/03/2017
	 * Le constructeur avec tous les paramètres
	 */
	public User(int identifier, String email, String password, String resetPassword, String firstName, String lastName,
			int phoneNumber) {
		this.identifier = identifier;
		this.email = email;
		this.password = password;
		this.resetPassword = resetPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the identifier
	 */
	public int getIdentifier() {
		return identifier;
	}
	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the resetPassword
	 */
	public String getResetPassword() {
		return resetPassword;
	}
	/**
	 * @param resetPassword the resetPassword to set
	 */
	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		return "User [identifier=" + identifier + ", email=" + email + ", password=" + password + ", resetPassword="
				+ resetPassword + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
