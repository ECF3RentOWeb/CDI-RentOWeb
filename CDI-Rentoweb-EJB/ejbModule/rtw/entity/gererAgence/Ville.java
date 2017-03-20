package rtw.entity.gererAgence;

/**
 *  POJO Ville, permettant de faire le mapping en base de
 *  l'entité Ville.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ville implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idVille;
	
	@Column(name="ville", length=50, nullable=false)
	private String nomVille;

	/**
	 *  Constructeur sans paramètres.
	 */
	public Ville() {
		super();
	}

	/**
	 * Constructeur avec paramètres
	 * @param nomVille
	 */
	public Ville(String nomVille) {
		super();
		this.nomVille = nomVille;
	}

	/**
	 * @param idVille
	 * @param nomVille
	 */
	public Ville(Integer idVille, String nomVille) {
		super();
		this.idVille = idVille;
		this.nomVille = nomVille;
	}
	
	// Génération des accesseurs

	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", nomVille=" + nomVille + "]";
	}

}
