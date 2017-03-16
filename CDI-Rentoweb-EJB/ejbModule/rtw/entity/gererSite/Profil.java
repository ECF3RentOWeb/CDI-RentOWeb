/**
 * 
 */
package rtw.entity.gererSite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Afpa
 * @version Première version
 * Les profils des utilisateurs
 * Profil particulier
 * profil professionnel
 * @see Gérer Agence pour les classes filles du profil professionnel
 *
 */
@Entity
@Table(name="profil")
public class Profil implements Serializable{
	/**
	 * Numéro auto-généré
	 */
	private static final long serialVersionUID = 6957387217946118350L;
	@Id
	private int id;
	@Column(name = "nomProfil",length=30, nullable = false)
	private String nomProfil;
	@OneToMany (mappedBy ="profil", cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	private Collection<Droit> droits = new ArrayList<Droit>();
	/**
	 * 
	 */
	public Profil() {
		super();
	}
	/**
	 * @param id
	 * @param nomProfil
	 * @param droits
	 */
	public Profil(int id, String nomProfil, Collection<Droit> droits) {
		super();
		this.id = id;
		this.nomProfil = nomProfil;
		this.droits = droits;
	}
	/**
	 * @param id
	 * @param droits
	 */
	public Profil(int id, Collection<Droit> droits) {
		super();
		this.id = id;
		this.droits = droits;
	}
	/**
	 * @param id
	 * @param nomProfil
	 */
	public Profil(int id, String nomProfil) {
		super();
		this.id = id;
		this.nomProfil = nomProfil;
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
	 * @return the nomProfil
	 */
	public String getNomProfil() {
		return nomProfil;
	}
	/**
	 * @param nomProfil the nomProfil to set
	 */
	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}
	/**
	 * @return the droits
	 */
	public Collection<Droit> getDroits() {
		return droits;
	}
	/**
	 * @param droits the droits to set
	 */
	public void setDroits(Collection<Droit> droits) {
		this.droits = droits;
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
		return "Profil [id=" + id + ", nomProfil=" + nomProfil + ", droits=" + droits + "]";
	}
	
	
	
	
}
