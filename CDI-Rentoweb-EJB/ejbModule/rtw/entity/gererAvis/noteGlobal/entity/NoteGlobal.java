package rtw.entity.gererAvis.noteGlobal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import rtw.entity.gererAvis.noteGlobal.interfaces.INoteGlobal;

/**
 * TODO
 * @author Afpa
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class NoteGlobal implements INoteGlobal {

	@Id
	private String idNote;
	private int valeur;
	
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
}
