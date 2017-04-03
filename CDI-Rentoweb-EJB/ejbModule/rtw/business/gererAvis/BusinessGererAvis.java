package rtw.business.gererAvis;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.collection.internal.PersistentBag;

import rtw.entity.gererAvis.avis.entity.Avis;
import rtw.entity.gererAvis.note.entity.Note;

/**
 * Class business de la fonctionnalit� g�rer avis.
 * 
 * @author Aur�lien Harl�
 * @version 1
 * @since 30/03/2017
 *
 */
public class BusinessGererAvis {
	
	/**
	 * M�thode de transformation d'un Avis provenant de la base de donn�es en Avis sans persistence bag.
	 * 
	 * @param avis {@link Avis}
	 * @return notesRetour {@link Collection} {@link Note}
	 * 
	 */
	public Collection<Note> convertNotePersistenceBagToNoteCollection(PersistentBag notes) {
		
		Collection<Note> notesRetour = new ArrayList<Note>();
		
		for (Object note : notes) {

			notesRetour.add((Note) note);
			
		}

		return notesRetour;
	}

}
