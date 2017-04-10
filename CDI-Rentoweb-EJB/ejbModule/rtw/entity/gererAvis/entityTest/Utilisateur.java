package rtw.entity.gererAvis.entityTest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur_test_avis")
public class Utilisateur implements Serializable{

	
	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = -1103610134725231932L;
	@Id
	private String idUtilisateur;

	public Utilisateur() {
		
	}
	
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [getIdUtilisateur()=" + getIdUtilisateur() + "]";
	}
	
}
