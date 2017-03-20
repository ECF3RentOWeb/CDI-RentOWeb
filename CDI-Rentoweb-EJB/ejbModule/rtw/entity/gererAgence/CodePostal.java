package rtw.entity.gererAgence;

/**
 * POJO permettant de faire le mapping avec la BDD
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="codePostal")
public class CodePostal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCodePostal;

	@Column(name = "cp", length=5, nullable=false)
	private String codePostal;

	/**
	 * Généraration des constructeurs
	 */
	public CodePostal() {
		super();
	}

	/**
	 * @param idCodePostal
	 * @param codePostal
	 */
	public CodePostal(Integer idCodePostal, String codePostal) {
		super();
		this.idCodePostal = idCodePostal;
		this.codePostal = codePostal;
	}

	/**
	 * @param codePostal
	 */
	public CodePostal(String codePostal) {
		super();
		this.codePostal = codePostal;
	}
	
	// Génération des accesseurs

	/**
	 * @return the idCodePostal
	 */
	public Integer getIdCodePostal() {
		return idCodePostal;
	}

	/**
	 * @param idCodePostal the idCodePostal to set
	 */
	public void setIdCodePostal(Integer idCodePostal) {
		this.idCodePostal = idCodePostal;
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

	@Override
	public String toString() {
		return "CodePostal [idCodePostal=" + idCodePostal + ", codePostal=" + codePostal + "]";
	}

}
