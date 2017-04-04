package rtw.service.gererAvis.factory;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.collection.internal.PersistentBag;

import rtw.business.gererAvis.BusinessGererAvis;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avis.entity.Avis;
import rtw.entity.gererAvis.commentaire.entity.Commentaire;
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
public class FactoryAvis {

	public Avis getAvisWithoutPersistentBag(Avis avisDao) {
		
		BusinessGererAvis businessGererAvis = new BusinessGererAvis();
		Avis avis = null; 
		
		if(avisDao instanceof AvisAnnonce){
			avis = new AvisAnnonce();
		}else if(avisDao instanceof AvisAgence){
			avis = new AvisAgence();
		}

		avis.setId(avisDao.getUtilisateur(), avisDao.getItem());
		avis.setCommentaire(avisDao.getCommentaire());
		avis.setItem(avisDao.getItem());
		avis.setUtilisateur(avisDao.getUtilisateur());
		avis.setNotes(businessGererAvis.convertNotePersistenceBagToNoteCollection((PersistentBag) avisDao.getNotes()));
		
		return avis;
		
	}

	/**
	 * Creation d'un {@link AvisAnnonce} avec son ID et toute les valeurs vide.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * @return avisAnnonce {@link AvisAnnonce}
	 */
	public AvisAnnonce getAvisAnnonce(Utilisateur utilisateur,Item item) {

		AvisAnnonce avisAnnonce = new AvisAnnonce();
		
		Commentaire commentaire = new Commentaire();
		
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
		
		avisAnnonce.setCommentaire(commentaire);
		avisAnnonce.setNotes(notes);
		
		avisAnnonce.setId(utilisateur, item);
		avisAnnonce.setUtilisateur(utilisateur);
		avisAnnonce.setItem(item);
		
		return avisAnnonce;
	}
	/**
	 * Creation d'un {@link AvisAgence} avec son ID et toute les valeurs vide.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * @return avisAgence {@link AvisAgence}
	 */
	public AvisAgence getAvisAgence(Utilisateur utilisateur,Item item) {

		AvisAgence avisAgence = new AvisAgence();
		
		Commentaire commentaire = new Commentaire();
		
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
		
		avisAgence.setCommentaire(commentaire);
		avisAgence.setNotes(notes);
		
		avisAgence.setId(utilisateur, item);
		avisAgence.setItem(item);
		avisAgence.setUtilisateur(utilisateur);
		
		return avisAgence;
		
	}
	

}
