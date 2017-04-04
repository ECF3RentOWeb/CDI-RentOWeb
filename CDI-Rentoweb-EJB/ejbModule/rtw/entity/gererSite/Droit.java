/**
 * 
 */
package rtw.entity.gererSite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Souleymane
 * @version 1
 * Tout ce qui concerne le droit des profils utilisateurs
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
	private boolean inscription;
	@Column(name = "connexion",length=30, nullable = true)
	private boolean connexion;
	@Column(name = "gererPassword",length=30, nullable = true)
	private boolean gererPassword;
	@Column(name = "gererAgence",length=30, nullable = true)
	private boolean gererAgence;
	@Column(name = "gererFavoris",length=30, nullable = true)
	private boolean gererFavoris;
	@Column(name = "gererAvis",length=30, nullable = true)
	private boolean gererAvis;
	@Column(name = "gererAnnonce",length=30, nullable = true)
	private boolean gererAnnonce;
	@Column(name = "gererAgenda",length=30, nullable = true)
	private boolean gererAgenda;
//	@ManyToOne(fetch=FetchType.EAGER, cascade = { CascadeType.ALL })
//	@JoinColumn(name = "idProfil", nullable = false)
	@Transient
	private Profil profil;

	/**
	 * 
	 */
	public Droit() {
		super();
	}
	/**
	 * @param id 
	 * @param inscription
	 * @param connexion
	 * @param gererPassword
	 * @param gererAgence
	 * @param gererFavoris
	 * @param gererAvis
	 * @param gererAnnonce
	 * @param gererAgenda
	 * @param profil
	 */
	public Droit(int id, boolean inscription, boolean connexion, boolean gererPassword, boolean gererAgence,
			boolean gererFavoris, boolean gererAvis, boolean gererAnnonce, boolean gererAgenda, Profil profil) {
		this.id = id;
		this.inscription = inscription;
		this.connexion = connexion;
		this.gererPassword = gererPassword;
		this.gererAgence = gererAgence;
		this.gererFavoris = gererFavoris;
		this.gererAvis = gererAvis;
		this.gererAnnonce = gererAnnonce;
		this.gererAgenda = gererAgenda;
		//this.profil = profil;
	}
	/**
	 * @param id
	 * @param inscription
	 * @param connexion
	 * @param gererPassword
	 * @param gererAgence
	 * @param gererFavoris
	 * @param gererAvis
	 * @param gererAnnonce
	 * @param gererAgenda
	 */
	public Droit(int id, boolean inscription, boolean connexion, boolean gererPassword, boolean gererAgence,
			boolean gererFavoris, boolean gererAvis, boolean gererAnnonce, boolean gererAgenda) {
		super();
		this.id = id;
		this.inscription = inscription;
		this.connexion = connexion;
		this.gererPassword = gererPassword;
		this.gererAgence = gererAgence;
		this.gererFavoris = gererFavoris;
		this.gererAvis = gererAvis;
		this.gererAnnonce = gererAnnonce;
		this.gererAgenda = gererAgenda;
	}
	/**
	 * @param id
	 * @param inscription
	 * @param connexion
	 * @param gererPassword
	 * @param gererFavoris
	 * @param gererAvis
	 */
	public Droit(int id, boolean inscription, boolean connexion, boolean gererPassword, boolean gererFavoris,
			boolean gererAvis) {
		super();
		this.id = id;
		this.inscription = inscription;
		this.connexion = connexion;
		this.gererPassword = gererPassword;
		this.gererFavoris = gererFavoris;
		this.gererAvis = gererAvis;
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
	public boolean isInscription() {
		return inscription;
	}
	/**
	 * @param inscription the inscription to set
	 */
	public void setInscription(boolean inscription) {
		this.inscription = inscription;
	}
	/**
	 * @return the connexion
	 */
	public boolean isConnexion() {
		return connexion;
	}
	/**
	 * @param connexion the connexion to set
	 */
	public void setConnexion(boolean connexion) {
		this.connexion = connexion;
	}
	/**
	 * @return the gererPassword
	 */
	public boolean isGererPassword() {
		return gererPassword;
	}
	/**
	 * @param gererPassword the gererPassword to set
	 */
	public void setGererPassword(boolean gererPassword) {
		this.gererPassword = gererPassword;
	}
	/**
	 * @return the gererAgence
	 */
	public boolean isGererAgence() {
		return gererAgence;
	}
	/**
	 * @param gererAgence the gererAgence to set
	 */
	public void setGererAgence(boolean gererAgence) {
		this.gererAgence = gererAgence;
	}
	/**
	 * @return the gererFavoris
	 */
	public boolean isGererFavoris() {
		return gererFavoris;
	}
	/**
	 * @param gererFavoris the gererFavoris to set
	 */
	public void setGererFavoris(boolean gererFavoris) {
		this.gererFavoris = gererFavoris;
	}
	/**
	 * @return the gererAvis
	 */
	public boolean isGererAvis() {
		return gererAvis;
	}
	/**
	 * @param gererAvis the gererAvis to set
	 */
	public void setGererAvis(boolean gererAvis) {
		this.gererAvis = gererAvis;
	}
	/**
	 * @return the gererAnnonce
	 */
	public boolean isGererAnnonce() {
		return gererAnnonce;
	}
	/**
	 * @param gererAnnonce the gererAnnonce to set
	 */
	public void setGererAnnonce(boolean gererAnnonce) {
		this.gererAnnonce = gererAnnonce;
	}
	/**
	 * @return the gererAgenda
	 */
	public boolean isGererAgenda() {
		return gererAgenda;
	}
	/**
	 * @param gererAgenda the gererAgenda to set
	 */
	public void setGererAgenda(boolean gererAgenda) {
		this.gererAgenda = gererAgenda;
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
		return "Droit [getId()=" + getId() + ", isInscription()=" + isInscription() + ", isConnexion()=" + isConnexion()
				+ ", isGererPassword()=" + isGererPassword() + ", isGererAgence()=" + isGererAgence()
				+ ", isGererFavoris()=" + isGererFavoris() + ", isGererAvis()=" + isGererAvis() + ", isGererAnnonce()="
				+ isGererAnnonce() + ", isGererAgenda()=" + isGererAgenda() + "]";
	}

	
	
	
}
