package rtw.entity.gererAvis.avis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.interfaces.IAvis;
import rtw.entity.gererAvis.commentaire.entity.Commentaire;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.entity.gererAvis.note.entity.Note;


/**
 * Entity {@link Avis} class mere abstraite de {@link AvisAgence} et {@link AvisItem}.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public abstract class Avis implements IAvis,Serializable{
	
	
	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = 6100178318002055413L;

	//TODO a modifier utiliser que pour test
	@Id
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idUtilisateur",referencedColumnName="idUtilisateur")
	private Utilisateur utilisateur;
	
	//TODO CascadeType a modifier utiliser que pour test
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idItem",referencedColumnName="idItem",unique=false)
	private Item item;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Collection<Note> notes = new ArrayList<Note>();
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Commentaire commentaire;

	/**
	 * Default constructor
	 */
	public Avis() {
		
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the notes
	 */
	public Collection<Note> getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}

	/**
	 * @return the commentaire
	 */
	public Commentaire getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Avis [getUtilisateur()=" + getUtilisateur() + ", getItem()=" + getItem() + ", getNotes()=" + getNotes()
				+ ", getCommentaire()=" + getCommentaire() + "]";
	}

}
