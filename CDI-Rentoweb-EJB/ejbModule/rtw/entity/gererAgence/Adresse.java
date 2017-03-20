package rtw.entity.gererAgence;
/**
 * @author olivier
 * Classe POJO permettant d'effectuer le mapping avec la BDD
 * 
 * 
 */
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adresses")
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAdresse;
	
	@Column(name="numero", length=15, nullable=false)
	private String numVoie;
	
	@Column(name="Voie", length=10, nullable=false)
	private String typeVoie;
	
	@Column(name="libelle", length=50, nullable=false)
	private String libelleAdresse;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="adresses_cpId")
	private CodePostal cp;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="adresses_idVille")
	private Ville ville;

	/**
	 *  Génération des accesseurs
	 */
	public Adresse() {
		super();
	}

	/**
	 * @param numVoie
	 * @param typeVoie
	 * @param libelleAdresse
	 * @param cp
	 * @param ville
	 */
	public Adresse(String numVoie, String typeVoie, String libelleAdresse, CodePostal cp, Ville ville) {
		super();
		this.numVoie = numVoie;
		this.typeVoie = typeVoie;
		this.libelleAdresse = libelleAdresse;
		this.cp = cp;
		this.ville = ville;
	}

	/**
	 * @param idAdresse
	 * @param numVoie
	 * @param typeVoie
	 * @param libelleAdresse
	 * @param cp
	 * @param ville
	 */
	public Adresse(Integer idAdresse, String numVoie, String typeVoie, String libelleAdresse, CodePostal cp,
			Ville ville) {
		super();
		this.idAdresse = idAdresse;
		this.numVoie = numVoie;
		this.typeVoie = typeVoie;
		this.libelleAdresse = libelleAdresse;
		this.cp = cp;
		this.ville = ville;
	}

	/**
	 * @return the idAdresse
	 */
	public Integer getIdAdresse() {
		return idAdresse;
	}

	/**
	 * @param idAdresse the idAdresse to set
	 */
	public void setIdAdresse(Integer idAdresse) {
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
	 * @return the cp
	 */
	public CodePostal getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(CodePostal cp) {
		this.cp = cp;
	}

	/**
	 * @return the ville
	 */
	public Ville getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	
	

}
