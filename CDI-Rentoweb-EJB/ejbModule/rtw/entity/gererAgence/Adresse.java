package rtw.entity.gererAgence;
/**
 * @author olivier
 * Classe POJO permettant d'effectuer le mapping avec la BDD
 * 
 * 
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idAdresse;
	
	@Column(name="Voie", length=15, nullable=false)
	private String numVoie;
	
	@Column(name="Voie", length=10, nullable=false)
	private String typeVoie;
	
	@Column(name="Adresse", length=50, nullable=false)
	private String libelleAdresse;
	
	@Column(name="CP", length=5, nullable=false)
	private String codePostal;
	
	@Column(name="Ville", length=50, nullable=false)		
	private String ville;
	
	/**
	 * Génération des constructeurs
	 */
	public Adresse() {	
	}

	/**
	 * @param idAdresse
	 * @param numVoie
	 * @param typeVoie
	 * @param libelleAdresse
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(int idAdresse, String numVoie, String typeVoie, String libelleAdresse, String codePostal,
			String ville) {
		this.idAdresse = idAdresse;
		this.numVoie = numVoie;
		this.typeVoie = typeVoie;
		this.libelleAdresse = libelleAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * @param numVoie
	 * @param typeVoie
	 * @param libelleAdresse
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(String numVoie, String typeVoie, String libelleAdresse, String codePostal, String ville) {
		this.numVoie = numVoie;
		this.typeVoie = typeVoie;
		this.libelleAdresse = libelleAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	//**Genération des accesseurs**

	/**
	 * @return the idAdresse
	 */
	public int getIdAdresse() {
		return idAdresse;
	}

	/**
	 * @param idAdresse the idAdresse to set
	 */
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	/**
	 * @return the numVoie
	 */
	public String getNumVoie() {
		return numVoie;
	}

	/**
	 * @param numVoie the numVoie to set
	 */
	public void setNumVoie(String numVoie) {
		this.numVoie = numVoie;
	}

	/**
	 * @return the typeVoie
	 */
	public String getTypeVoie() {
		return typeVoie;
	}

	/**
	 * @param typeVoie the typeVoie to set
	 */
	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	/**
	 * @return the libelleAdresse
	 */
	public String getLibelleAdresse() {
		return libelleAdresse;
	}

	/**
	 * @param libelleAdresse the libelleAdresse to set
	 */
	public void setLibelleAdresse(String libelleAdresse) {
		this.libelleAdresse = libelleAdresse;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}
