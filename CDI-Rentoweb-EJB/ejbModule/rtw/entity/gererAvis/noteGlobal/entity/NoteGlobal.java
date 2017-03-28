package rtw.entity.gererAvis.noteGlobal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_idNoteGlobal")
	@SequenceGenerator(name="seq_idNoteGlobal",sequenceName="seq_idNoteGlobal",initialValue=1)
	private int idNoteGlobal;
	
	private int valeur;
	
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
}
