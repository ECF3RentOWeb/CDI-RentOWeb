package rtw.service.gererAvis.factory;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.collection.internal.PersistentBag;

import rtw.business.gererAvis.BusinessGererAvis;
import rtw.entity.gererAvis.avis.entity.Avis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.entity.AvisGlobal;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.entity.gererAvis.note.entity.Note;
import rtw.entity.gererAvis.note.entity.NoteBruitExterieur;
import rtw.entity.gererAvis.note.entity.NoteBruitInterieur;
import rtw.entity.gererAvis.note.entity.NoteEtatGeneral;
import rtw.entity.gererAvis.note.entity.NoteHumidite;
import rtw.entity.gererAvis.note.entity.NoteIsolationChaud;
import rtw.entity.gererAvis.note.entity.NoteIsolationFroid;
import rtw.entity.gererAvis.note.entity.NoteLuminosite;
import rtw.entity.gererAvis.note.entity.NoteRelationBailleur;

/**
 * Factory qui creer des {@link Avis}
 * @author Aurélien Harlé
 * @version 1
 * @since 30/03/2017
 * 
 */
public class FactoryAvisGlobal {

	public AvisGlobal getAvisGlobalWithoutPersistentBag(AvisGlobal avisGlobalDao) {
		
		BusinessGererAvis businessGererAvis = new BusinessGererAvis();
		AvisGlobal avisGlobal = null; 
		
		if(avisGlobalDao instanceof AvisGlobalAnnonce){
			avisGlobal = new AvisGlobalAnnonce();
		}else if(avisGlobalDao instanceof AvisGlobalAgence){
			avisGlobal = new AvisGlobalAgence();
		}

		avisGlobal.setId(avisGlobalDao.getUtilisateur(), avisGlobalDao.getItem());

		avisGlobal.setItem(avisGlobalDao.getItem());
		avisGlobal.setUtilisateur(avisGlobalDao.getUtilisateur());
		avisGlobal.setNotes(businessGererAvis.convertNotePersistenceBagToNoteCollection((PersistentBag) avisGlobalDao.getNotes()));
		
		return avisGlobal;
		
	}

	/**
	 * Creation d'un {@link AvisGlobalAgence} avec son ID et toute les valeurs vide.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * @return avisAnnonce {@link AvisGlobalAgence}
	 */
	public AvisGlobalAgence getAvisGlobalAgence(Utilisateur utilisateur, Item item) {
		
		AvisGlobalAgence avisGlobalAgence = new AvisGlobalAgence();
		
		
		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteLuminosite noteLuminite = new NoteLuminosite();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		Collection<Note> notes = new ArrayList<Note>();
		
		notes.add(noteBruitExterieur);
		notes.add(noteBruitInterieur);
		notes.add(noteEtatGeneral);
		notes.add(noteHumidite);
		notes.add(noteIsolationChaud);
		notes.add(noteIsolationFroid);
		notes.add(noteLuminite);
		notes.add(noteRelationBailleur);
		
		avisGlobalAgence.setNotes(notes);
		
		avisGlobalAgence.setId(utilisateur, item);
		avisGlobalAgence.setUtilisateur(utilisateur);
		avisGlobalAgence.setItem(item);
		
		return avisGlobalAgence;
	}
	
	/**
	 * Creation d'un {@link AvisGlobalAnnonce} avec son ID et toute les valeurs vide.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * @return avisAnnonce {@link AvisGlobalAnnonce}
	 */
	public AvisGlobalAnnonce getAvisGlobalAnnonce(Utilisateur utilisateur, Item item) {
		
		AvisGlobalAnnonce avisGlobalAnnonce = new AvisGlobalAnnonce();
		
		
		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteLuminosite noteLuminite = new NoteLuminosite();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		Collection<Note> notes = new ArrayList<Note>();
		
		notes.add(noteBruitExterieur);
		notes.add(noteBruitInterieur);
		notes.add(noteEtatGeneral);
		notes.add(noteHumidite);
		notes.add(noteIsolationChaud);
		notes.add(noteIsolationFroid);
		notes.add(noteLuminite);
		notes.add(noteRelationBailleur);
		
		avisGlobalAnnonce.setNotes(notes);
		
		avisGlobalAnnonce.setId(utilisateur, item);
		avisGlobalAnnonce.setUtilisateur(utilisateur);
		avisGlobalAnnonce.setItem(item);
		
		return avisGlobalAnnonce;
	}

}
