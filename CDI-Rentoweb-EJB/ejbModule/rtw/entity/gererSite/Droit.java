/**
 * 
 */
package rtw.entity.gererSite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Afpa
 * @version Première version
 *
 */
@Entity
@Table(name="droit")
public class Droit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2974552136333453956L;
	@Id
	private int id;
	@Column(name = "inscription",length=30, nullable = true)
	private String inscription;
	@Column(name = "connexion",length=30, nullable = true)
	private String connexion;
	@Column(name = "gererPassword",length=30, nullable = true)
	private String gererPassword;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idProfil", nullable = true)
	private Profil profil;
	/**
	 * 
	 */
	public Droit() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param inscription
	 * @param connexion
	 * @param gererPassword
	 * @param profil
	 */
	public Droit(int id, String inscription, String connexion, String gererPassword, Profil profil) {
		this.id = id;
		this.inscription = inscription;
		this.connexion = connexion;
		this.gererPassword = gererPassword;
		this.profil = profil;
	}
	/**
	 * @param id
	 * @param inscription
	 * @param profil
	 */
	public Droit(int id, String inscription, Profil profil) {
		this.id = id;
		this.inscription = inscription;
		this.profil = profil;
	}
	/**
	 * @param id
	 * @param connexion
	 * @param gererPassword
	 * @param profil
	 */
	public Droit(int id, String connexion, String gererPassword, Profil profil) {
		this.id = id;
		this.connexion = connexion;
		this.gererPassword = gererPassword;
		this.profil = profil;
	}
	/**
	 * @param id
	 * @param connexion
	 */
	public Droit(int id, String connexion) {
		this.id = id;
		this.connexion = connexion;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the inscription
	 */
	public String getInscription() {
		return inscription;
	}
	/**
	 * @param inscription the inscription to set
	 */
	public void setInscription(String inscription) {
		this.inscription = inscription;
	}
	/**
	 * @return the connexion
	 */
	public String getConnexion() {
		return connexion;
	}
	/**
	 * @param connexion the connexion to set
	 */
	public void setConnexion(String connexion) {
		this.connexion = connexion;
	}
	/**
	 * @return the gererPassword
	 */
	public String getGererPassword() {
		return gererPassword;
	}
	/**
	 * @param gererPassword the gererPassword to set
	 */
	public void setGererPassword(String gererPassword) {
		this.gererPassword = gererPassword;
	}
	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}
	/**
	 * @param profil the profil to set
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
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
		return "Droit [id=" + id + ", inscription=" + inscription + ", connexion=" + connexion + ", gererPassword="
				+ gererPassword + ", profil=" + profil + "]";
	}
	
	
	
	
	
	
	
}
