package rtw.entity.gererAvis.commentaire.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import rtw.entity.gererAvis.commentaire.interfaces.ICommentaire;

/**
 * Entity {@link Commentaire} contient le commentaire de l'utilisateur.
 * 
 * @author Aur�lien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
public class Commentaire implements ICommentaire,Serializable {

	
	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = 666865946866504925L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_idCommentaire")
	@SequenceGenerator(name="seq_idCommentaire",sequenceName="seq_idCommentaire",initialValue=1)
	private int idCommentaire;
	
	@Column(length=4000,nullable=false)
	private String contenu;
	
	/**
	 * @return the idCommentaire
	 */
	public int getIdCommentaire() {
		return idCommentaire;
	}
	/**
	 * @param idCommentaire the idCommentaire to set
	 */
	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}
	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[getIdCommentaire()=" + getIdCommentaire() + ", getContenu()=" + getContenu() + "]";
	}
	
}
