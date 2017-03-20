package rtw.entity.gererAgence;
/**
 * @author olivier
 * 
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agence implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int idAgence;
	
	@Column(name="Agence")
	private String nomAgence;
	@ManyToOne
	private Adresse adresse;
	private String numTel;
	private String libelleAgence;
	private String siteAgence;
	private String numSiren;
	//@ManyToOne
	//private ChefAgence chefAgence;
	@ManyToOne
	private AgentImmobilier agentImmobilier;
	/**
	 *  Génération des constructeurs
	 */
	public Agence() {
	}
	/**
	 * @param idAgence
	 * @param nomAgence
	 * @param adresse
	 * @param numTel
	 * @param libelleAgence
	 * @param siteAgence
	 * @param numSiren
	 * @param chefAgence
	 * @param agentImmobilier
	 */
	public Agence(int idAgence, String nomAgence, Adresse adresse, String numTel, String libelleAgence,
			String siteAgence, String numSiren,  AgentImmobilier agentImmobilier) {
		super();
		this.idAgence = idAgence;
		this.nomAgence = nomAgence;
		this.adresse = adresse;
		this.numTel = numTel;
		this.libelleAgence = libelleAgence;
		this.siteAgence = siteAgence;
		this.numSiren = numSiren;
	//	this.chefAgence = chefAgence;
		this.agentImmobilier = agentImmobilier;
	}
	/**
	 * @param nomAgence
	 * @param adresse
	 * @param numTel
	 * @param libelleAgence
	 * @param siteAgence
	 * @param numSiren
	 * @param chefAgence
	 * @param agentImmobilier
	 */
	public Agence(String nomAgence, Adresse adresse, String numTel, String libelleAgence, String siteAgence,
			String numSiren,  AgentImmobilier agentImmobilier) {
		super();
		this.nomAgence = nomAgence;
		this.adresse = adresse;
		this.numTel = numTel;
		this.libelleAgence = libelleAgence;
		this.siteAgence = siteAgence;
		this.numSiren = numSiren;
		//this.chefAgence = chefAgence;
		this.agentImmobilier = agentImmobilier;
	}
	/**
	 * @return the idAgence
	 */
	public Integer getIdAgence() {
		return idAgence;
	}
	/**
	 * @param idAgence the idAgence to set
	 */
	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}
	/**
	 * @return the nomAgence
	 */
	public String getNomAgence() {
		return nomAgence;
	}
	/**
	 * @param nomAgence the nomAgence to set
	 */
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the numTel
	 */
	public String getNumTel() {
		return numTel;
	}
	/**
	 * @param numTel the numTel to set
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	/**
	 * @return the libelleAgence
	 */
	public String getLibelleAgence() {
		return libelleAgence;
	}
	/**
	 * @param libelleAgence the libelleAgence to set
	 */
	public void setLibelleAgence(String libelleAgence) {
		this.libelleAgence = libelleAgence;
	}
	/**
	 * @return the siteAgence
	 */
	public String getSiteAgence() {
		return siteAgence;
	}
	/**
	 * @param siteAgence the siteAgence to set
	 */
	public void setSiteAgence(String siteAgence) {
		this.siteAgence = siteAgence;
	}
	/**
	 * @return the numSiren
	 */
	public String getNumSiren() {
		return numSiren;
	}
	/**
	 * @param numSiren the numSiren to set
	 */
	public void setNumSiren(String numSiren) {
		this.numSiren = numSiren;
	}
	/**
	 * @return the chefAgence
	 */
//	public ChefAgence getChefAgence() {
//		return chefAgence;
//	}
//	/**
//	 * @param chefAgence the chefAgence to set
//	 */
//	public void setChefAgence(ChefAgence chefAgence) {
//		this.chefAgence = chefAgence;
//	}
	/**
	 * @return the agentImmobilier
	 */
	public AgentImmobilier getAgentImmobilier() {
		return agentImmobilier;
	}
	/**
	 * @param agentImmobilier the agentImmobilier to set
	 */
	public void setAgentImmobilier(AgentImmobilier agentImmobilier) {
		this.agentImmobilier = agentImmobilier;
	}
	

}
