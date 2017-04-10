package rtw.entity.gererAvis.avisGlobal.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.interfaces.IAvisGlobal;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.note.entity.Note;

/**
 * Entity {@link AvisGlobal} class mere abstraite de {@link AvisGlobalAgence} et {@link AvisGlobalAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class AvisGlobal implements IAvisGlobal,Serializable {

	
	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = -5377843581640163194L;

	@Id
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Item item;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Collection<Note> notes = new ArrayList<Note>();		
	
	/**
	 * Default constructor
	 */
	public AvisGlobal(){
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AvisGlobal [getItem()=" + getItem() + ", getNotes()=" + getNotes() + "]";
	}
	

}
