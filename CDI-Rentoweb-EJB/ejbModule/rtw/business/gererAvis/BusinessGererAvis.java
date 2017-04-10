package rtw.business.gererAvis;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.collection.internal.PersistentBag;

import rtw.entity.gererAvis.avis.entity.Avis;
import rtw.entity.gererAvis.avisGlobal.entity.AvisGlobal;
import rtw.entity.gererAvis.note.entity.Note;
import rtw.exception.gererAvis.NullAvisException;

/**
 * Class business de la fonctionnalité gérer avis.
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 30/03/2017
 *
 */
public class BusinessGererAvis {
	
	/**
	 * Méthode de transformation d'un Avis provenant de la base de données en Avis sans persistence bag.
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
	/**
	 * TODO Transformation Avis
	 * 
	 * Méthode qui contrôle si un {@link Avis} contient un null a tout niveau ou une note a 0 (non noté).
	 * @param avis {@link Avis}
	 */
	public void controleAvis(Avis avis) throws NullAvisException {

		if(avis == null){
			throw new NullAvisException();
		}else if(avis.getItem() == null){
			throw new NullAvisException();
		}else if(avis.getUtilisateur() == null){
			throw new NullAvisException();
		}else if(avis.getCommentaire() == null){
			throw new NullAvisException();
		}else if(avis.getNotes() == null){
			throw new NullAvisException();
		}else if(avis.getCommentaire().getContenu() == null){
			throw new NullAvisException();
		}
		
		for (Note note : avis.getNotes()) {
			if(note == null){
				throw new NullAvisException();
			}else if(note.getValeur() == 0){
				throw new NullAvisException();
			}
		}
		
	}
	public void controleAvisGlobal(AvisGlobal avisGlobal) throws NullAvisException {
		
		if(avisGlobal == null){
			throw new NullAvisException();
		}else if(avisGlobal.getItem() == null){
			throw new NullAvisException();
		}else if(avisGlobal.getNotes() == null){
			throw new NullAvisException();
		}
		
		for (Note note : avisGlobal.getNotes()) {
			if(note == null){
				throw new NullAvisException();
			}else if(note.getValeur() == 0){
				throw new NullAvisException();
			}
		}
		
	}

}
