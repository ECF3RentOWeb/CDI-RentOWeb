package rtw.entity.gererAvis.note.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import rtw.entity.gererAvis.note.interfaces.INote;


/**
 * Entity {@link Note} class mere abstraite de TODO
 * 
 * @author Aurélien
 * @version 1
 * @since 15/03/2017
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Note implements INote,Serializable {
	
	
	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = -161691499887409986L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_idNote")
	@SequenceGenerator(name="seq_idNote",sequenceName="seq_idNote",initialValue=1)
	private int idNote;
	
	@Column(nullable=false)
	private int valeur;

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the idNote
	 */
	public int getIdNote() {
		return idNote;
	}

	/**
	 * @param idNote the idNote to set
	 */
	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "[getValeur()=" + getValeur() + ", getIdNote()=" + getIdNote() + "]";
	}

}
