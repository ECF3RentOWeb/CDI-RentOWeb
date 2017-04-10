package rtw.test.gererAvis.casAlternatif;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import rtw.clientServer.gererAvis.FacadeServiceAvisRemote;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
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
import rtw.util.gererAvis.Param;

public class JUnitInsertNull {
	
	private static Context context;
	private static FacadeServiceAvisRemote facadeServiceAvisRemote;
	
	/**
	 * Méthode lancer avant tout, initialise la connection au serveur EJB.
	 * 
	 * @throws NamingException
	 */
	@BeforeClass
	public static void init() throws NamingException{
		
		context = new InitialContext();
		facadeServiceAvisRemote = (FacadeServiceAvisRemote) context.lookup(Param.FACADE_EJB);
		
	}
	
	/**
	 * Méthode lancer avant tout, finalize la connection au serveur EJB,remet les tables leur état initial.
	 * 
	 * @throws NamingException
	 */
	@AfterClass
	public static void finalizeur() throws NamingException{
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("1","1");
		AvisAgence avisAgence = createAvisAgence("2","2");
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("3","3");
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("4","4");
		
		facadeServiceAvisRemote.supprimerAvisAnnonce(avisAnnonce);
		facadeServiceAvisRemote.supprimerAvisAgence(avisAgence);
		facadeServiceAvisRemote.supprimerAvisGlobalAgence(avisGlobalAgence);
		facadeServiceAvisRemote.supprimerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		context.close();
		
	}
	
	/**
	 * Test d'insertion d'un {@link AvisAnnonce} en doublon BDD.
	 */
	@Test
	public void testInsertDoublonAvisAnnonce() {
		
		AvisAnnonce avisAnnonce1 = createAvisAnnonce("17","17");
		AvisAnnonce avisAnnonce2 = createAvisAnnonce("17","17");
		
		boolean retour1 = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce1);
		boolean retour2 = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce2);
		
		assertTrue(retour1);
		assertTrue(!retour2);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAnnonce} avec un Commentaire null en BDD.
	 */
	@Test
	public void testInsertCommentaireNullAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("25","25");
		
		avisAnnonce.setCommentaire(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAnnonce} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertNotesNullAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("26","26");
	
		avisAnnonce.setNotes(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAnnonce} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertContenuCommentaireNullAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("27","27");
	
		avisAnnonce.getCommentaire().setContenu(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAnnonce} avec une Note null en BDD.
	 */
	@Test
	public void testInsertNoteNullAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("28","28");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisAnnonce.getNotes()) {
			
			note = null;
			notes.add(note);  
			
		}
		
		avisAnnonce.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAnnonce} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertValeurNoteNullAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("29","29");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisAnnonce.getNotes()) {
	
			note.setValeur(0);
			notes.add(note);  
			
		}
		
		avisAnnonce.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAgence} avec un Commentaire null en BDD.
	 */
	@Test
	public void testInsertCommentaireNullAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("25","25");
		
		avisAgence.setCommentaire(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAgence} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertNotesNullAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("26","26");
	
		avisAgence.setNotes(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAgence} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertContenuCommentaireNullAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("27","27");
	
		avisAgence.getCommentaire().setContenu(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAgence} avec une Note null en BDD.
	 */
	@Test
	public void testInsertNoteNullAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("28","28");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisAgence.getNotes()) {
			
			note = null;
			notes.add(note);  
			
		}
		
		avisAgence.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisAgence} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertValeurNoteNullAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("29","29");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisAgence.getNotes()) {
	
			note.setValeur(0);
			notes.add(note);  
			
		}
		
		avisAgence.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisGlobalAnnonce} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertNotesNullAvisGlobalAnnonce() {
		
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("26","26");
	
		avisGlobalAnnonce.setNotes(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisGlobalAnnonce} avec une Note null en BDD.
	 */
	@Test
	public void testInsertNoteNullAvisGlobalAnnonce() {
		
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("28","28");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisGlobalAnnonce.getNotes()) {
			
			note = null;
			notes.add(note);  
			
		}
		
		avisGlobalAnnonce.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisGlobalAnnonce} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertValeurNoteNullAvisGlobalAnnonce() {
		
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("29","29");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisGlobalAnnonce.getNotes()) {
	
			note.setValeur(0);
			notes.add(note);  
			
		}
		
		avisGlobalAnnonce.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisGlobalAgence} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertNotesNullAvisGlobalAgence() {
		
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("26","26");
	
		avisGlobalAgence.setNotes(null);
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAgence(avisGlobalAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisGlobalAgence} avec une Note null en BDD.
	 */
	@Test
	public void testInsertNoteNullAvisGlobalAgence() {
		
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("28","28");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisGlobalAgence.getNotes()) {
			
			note = null;
			notes.add(note);  
			
		}
		
		avisGlobalAgence.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAgence(avisGlobalAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 *  Test d'insertion d'un {@link AvisGlobalAgence} avec une Notes null en BDD.
	 */
	@Test
	public void testInsertValeurNoteNullAvisGlobalAgence() {
		
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("29","29");
		
		Collection<Note> notes = new ArrayList<Note>();
		
		for (Note note : avisGlobalAgence.getNotes()) {
	
			note.setValeur(0);
			notes.add(note);  
			
		}
		
		avisGlobalAgence.setNotes(notes);
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAgence(avisGlobalAgence);
		
		assertTrue(!retour);
		
	}

	/**
	 * Creer un {@link AvisAnnonce} avec tout son contenu.
	 * @param idItem 
	 * @param idUtilisateur 
	 * @return avisAnnonce {@link AvisAnnonce}
	 */
	private static AvisAnnonce createAvisAnnonce(String idUtilisateur, String idItem) {

		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteLuminosite noteLuminite = new NoteLuminosite();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		noteBruitExterieur.setValeur(5);
		noteBruitInterieur.setValeur(5);
		noteEtatGeneral.setValeur(5);
		noteHumidite.setValeur(5);
		noteIsolationChaud.setValeur(5);
		noteIsolationFroid.setValeur(5);
		noteLuminite.setValeur(5);
		noteRelationBailleur.setValeur(5);
		
		Collection<Note> notes = new ArrayList<Note>();
		
		notes.add(noteBruitExterieur);
		notes.add(noteBruitInterieur);
		notes.add(noteEtatGeneral);
		notes.add(noteHumidite);
		notes.add(noteIsolationChaud);
		notes.add(noteIsolationFroid);
		notes.add(noteLuminite);
		notes.add(noteRelationBailleur);
		
		Commentaire commentaire = new Commentaire();
		commentaire.setContenu("Commentaire d'un Avis Annonce");
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(idUtilisateur);
		
		Item item = new Item();
		item.setIdItem(idItem);
		
		AvisAnnonce avisAnnonce = new AvisAnnonce();
		
		avisAnnonce.setNotes(notes);
		avisAnnonce.setCommentaire(commentaire);
		avisAnnonce.setUtilisateur(utilisateur);
		avisAnnonce.setItem(item);
		
		return avisAnnonce;
		
	}
	
	/**
	 * Creer un {@link AvisAnnonce} avec tout son contenu.
	 * @param string2 
	 * @param string 
	 * @return avisAnnonce {@link AvisAnnonce}
	 */
	private static AvisAgence createAvisAgence(String idUtilisateur, String idItem) {
		
		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteLuminosite noteLuminite = new NoteLuminosite();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		noteBruitExterieur.setValeur(5);
		noteBruitInterieur.setValeur(5);
		noteEtatGeneral.setValeur(5);
		noteHumidite.setValeur(5);
		noteIsolationChaud.setValeur(5);
		noteIsolationFroid.setValeur(5);
		noteLuminite.setValeur(5);
		noteRelationBailleur.setValeur(5);
		
		Collection<Note> notes = new ArrayList<Note>();
		
		notes.add(noteBruitExterieur);
		notes.add(noteBruitInterieur);
		notes.add(noteEtatGeneral);
		notes.add(noteHumidite);
		notes.add(noteIsolationChaud);
		notes.add(noteIsolationFroid);
		notes.add(noteLuminite);
		notes.add(noteRelationBailleur);
		
		Commentaire commentaire = new Commentaire();
		commentaire.setContenu("Commentaire d'un Avis Agence");
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(idUtilisateur);
		
		Item item = new Item();
		item.setIdItem(idItem);
		
		AvisAgence avisAgence = new AvisAgence();
		
		avisAgence.setNotes(notes);
		avisAgence.setCommentaire(commentaire);
		avisAgence.setUtilisateur(utilisateur);
		avisAgence.setItem(item);
		
		return avisAgence;
		
	}
	
	private static AvisGlobalAgence createAvisGlobalAgence(String idUtilisateur, String idItem) {
		
		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteLuminosite noteLuminite = new NoteLuminosite();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		noteBruitExterieur.setValeur(5);
		noteBruitInterieur.setValeur(5);
		noteEtatGeneral.setValeur(5);
		noteHumidite.setValeur(5);
		noteIsolationChaud.setValeur(5);
		noteIsolationFroid.setValeur(5);
		noteLuminite.setValeur(5);
		noteRelationBailleur.setValeur(5);
		
		Collection<Note> notes = new ArrayList<Note>();
		
		notes.add(noteBruitExterieur);
		notes.add(noteBruitInterieur);
		notes.add(noteEtatGeneral);
		notes.add(noteHumidite);
		notes.add(noteIsolationChaud);
		notes.add(noteIsolationFroid);
		notes.add(noteLuminite);
		notes.add(noteRelationBailleur);
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(idUtilisateur);
		
		Item item = new Item();
		item.setIdItem(idItem);
		
		AvisGlobalAgence avisGlobalAgence = new AvisGlobalAgence();
		
		avisGlobalAgence.setNotes(notes);
		avisGlobalAgence.setItem(item);
		
		return avisGlobalAgence;
		
	}
	
	private static AvisGlobalAnnonce createAvisGlobalAnnonce(String idUtilisateur, String idItem) {
		
		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteLuminosite noteLuminite = new NoteLuminosite();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		noteBruitExterieur.setValeur(5);
		noteBruitInterieur.setValeur(5);
		noteEtatGeneral.setValeur(5);
		noteHumidite.setValeur(5);
		noteIsolationChaud.setValeur(5);
		noteIsolationFroid.setValeur(5);
		noteLuminite.setValeur(5);
		noteRelationBailleur.setValeur(5);
		
		Collection<Note> notes = new ArrayList<Note>();
		
		notes.add(noteBruitExterieur);
		notes.add(noteBruitInterieur);
		notes.add(noteEtatGeneral);
		notes.add(noteHumidite);
		notes.add(noteIsolationChaud);
		notes.add(noteIsolationFroid);
		notes.add(noteLuminite);
		notes.add(noteRelationBailleur);
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(idUtilisateur);
		
		Item item = new Item();
		item.setIdItem(idItem);
		
		AvisGlobalAnnonce avisGlobalAnnonce = new AvisGlobalAnnonce();
		
		avisGlobalAnnonce.setNotes(notes);
		avisGlobalAnnonce.setItem(item);

		return avisGlobalAnnonce;
	}

}
