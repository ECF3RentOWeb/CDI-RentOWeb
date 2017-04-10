package rtw.test.gererAvis.casNominaux;

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

public class JUnitDeleteAvis {
	
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
	 * Test de suppression d'un {@link AvisAnnonce} en BDD.
	 */
	@Test
	public void testDeleteAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("9","9");
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		boolean retour = facadeServiceAvisRemote.supprimerAvisAnnonce(avisAnnonce);
		
		//AvisAnnonce avisAnnonceRetour = facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce);
		
		assertTrue(retour);
		//assertNull(avisAnnonceRetour);
		
	}

	/**
	 * Test de suppression d'un {@link AvisAgence} en BDD.
	 */
	@Test
	public void testDeleteAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("10","10");
		facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		boolean retour = facadeServiceAvisRemote.supprimerAvisAgence(avisAgence);
		
		assertTrue(retour);
		
	}

	/**
	 * Test de suppression d'un {@link AvisGlobalAgence} en BDD.
	 */
	@Test
	public void testDeleteAvisGlobalAgence() {
		
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("11","11");
		facadeServiceAvisRemote.creerAvisGlobalAgence(avisGlobalAgence);
		boolean retour = facadeServiceAvisRemote.supprimerAvisGlobalAgence(avisGlobalAgence);
		
		assertTrue(retour);
		
	}

	/**
	 * Test de suppression d'un {@link AvisGlobalAnnonce} en BDD.
	 */
	@Test
	public void testDeleteAvisGlobalAnnonce() {
		
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("12","12");
		facadeServiceAvisRemote.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		boolean retour = facadeServiceAvisRemote.supprimerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		assertTrue(retour);
		
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
