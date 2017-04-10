package rtw.test.gererAvis.casNominaux;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
import rtw.technique.gererAvis.ListeAvisAgence;
import rtw.technique.gererAvis.ListeAvisAnnonce;
import rtw.util.gererAvis.Param;

public class JUnitFindListAvis {
	
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
	 * Test de récupération d'une {@link ArrayList} {@link AvisAnnonce} en BDD.
	 */
	@Test
	public void testFindListAvisAnnonce() {
		
		Item item = new Item();
		item.setIdItem("1");
		
		AvisAnnonce avisAnnonce1 = createAvisAnnonce("17", "17");
		AvisAnnonce avisAnnonce2 = createAvisAnnonce("18", "18");
		AvisAnnonce avisAnnonce3 = createAvisAnnonce("19", "19");
		AvisAnnonce avisAnnonce4 = createAvisAnnonce("20", "20");
		
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce1);
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce2);
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce3);
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce4);
		
		avisAnnonce1.setItem(item);
		avisAnnonce2.setItem(item);
		avisAnnonce3.setItem(item);
		avisAnnonce4.setItem(item);
		
		facadeServiceAvisRemote.modifierAvisAnnonce(avisAnnonce1);
		facadeServiceAvisRemote.modifierAvisAnnonce(avisAnnonce2);
		facadeServiceAvisRemote.modifierAvisAnnonce(avisAnnonce3);
		facadeServiceAvisRemote.modifierAvisAnnonce(avisAnnonce4);
		
		ListeAvisAnnonce listeAvisAnnonceExcepted = new ListeAvisAnnonce();
		
		listeAvisAnnonceExcepted.add(facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce1));
		listeAvisAnnonceExcepted.add(facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce2));
		listeAvisAnnonceExcepted.add(facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce3));
		listeAvisAnnonceExcepted.add(facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce4));
		
		ListeAvisAnnonce listeAvisAnnonceDao = facadeServiceAvisRemote.rechercheListeAvisAnnonce(item);
		
		Iterator<AvisAnnonce> iteratorDao = listeAvisAnnonceDao.iterator();
		Iterator<AvisAnnonce> iteratorExcepted = listeAvisAnnonceExcepted.iterator();
		
		while(iteratorDao.hasNext() && iteratorExcepted.hasNext()){
			
			AvisAnnonce avisAnnonce = iteratorDao.next();
			AvisAnnonce avisAnnonceExcepted = iteratorExcepted.next();
			
			assertEquals(avisAnnonce.getItem().getIdItem(), avisAnnonceExcepted.getItem().getIdItem());
			assertEquals(avisAnnonce.getUtilisateur().getIdUtilisateur(), avisAnnonceExcepted.getUtilisateur().getIdUtilisateur());
			assertEquals(avisAnnonce.getCommentaire().getContenu(), avisAnnonceExcepted.getCommentaire().getContenu());
			
			Collection<Note> notesExcepted = avisAnnonceExcepted.getNotes();
			Collection<Note> notes = avisAnnonceExcepted.getNotes();
			
			Iterator<Note> notesIterator = notes.iterator();
			Iterator<Note> notesExceptedIterator = notesExcepted.iterator();
			
			while (notesExceptedIterator.hasNext() && notesIterator.hasNext()) {
				
				Note noteExcepted = (Note) notesExceptedIterator.next();
				Note note = (Note) notesIterator.next();
				
				assertEquals(note.getIdNote(),noteExcepted.getIdNote());
				assertEquals(note.getValeur(),noteExcepted.getValeur());
				
			}
		}
	}

	/**
	 * Test de récupération d'une {@link ArrayList} {@link AvisAgence} en BDD.
	 */
	@Test
	public void testFindListAvisAgence() {
		
		Item item = new Item();
		item.setIdItem("1");
		
		AvisAgence avisAgence1 = createAvisAgence("17", "17");
		AvisAgence avisAgence2 = createAvisAgence("18", "18");
		AvisAgence avisAgence3 = createAvisAgence("19", "19");
		AvisAgence avisAgence4 = createAvisAgence("20", "20");
		
		facadeServiceAvisRemote.creerAvisAgence(avisAgence1);
		facadeServiceAvisRemote.creerAvisAgence(avisAgence2);
		facadeServiceAvisRemote.creerAvisAgence(avisAgence3);
		facadeServiceAvisRemote.creerAvisAgence(avisAgence4);
		
		avisAgence1.setItem(item);
		avisAgence2.setItem(item);
		avisAgence3.setItem(item);
		avisAgence4.setItem(item);
		
		facadeServiceAvisRemote.modifierAvisAgence(avisAgence1);
		facadeServiceAvisRemote.modifierAvisAgence(avisAgence2);
		facadeServiceAvisRemote.modifierAvisAgence(avisAgence3);
		facadeServiceAvisRemote.modifierAvisAgence(avisAgence4);
		
		ListeAvisAgence listeAvisAgenceExcepted = new ListeAvisAgence();
		
		listeAvisAgenceExcepted.add(facadeServiceAvisRemote.rechercheAvisAgence(avisAgence1));
		listeAvisAgenceExcepted.add(facadeServiceAvisRemote.rechercheAvisAgence(avisAgence2));
		listeAvisAgenceExcepted.add(facadeServiceAvisRemote.rechercheAvisAgence(avisAgence3));
		listeAvisAgenceExcepted.add(facadeServiceAvisRemote.rechercheAvisAgence(avisAgence4));
		
		ListeAvisAgence listeAvisAgenceDao = facadeServiceAvisRemote.rechercheListeAvisAgence(item);
		
		Iterator<AvisAgence> iteratorDao = listeAvisAgenceDao.iterator();
		Iterator<AvisAgence> iteratorExcepted = listeAvisAgenceExcepted.iterator();
		
		while(iteratorDao.hasNext() && iteratorExcepted.hasNext()){
			
			AvisAgence avisAgence = iteratorDao.next();
			AvisAgence avisAgenceExcepted = iteratorExcepted.next();
			
			assertEquals(avisAgence.getItem().getIdItem(), avisAgenceExcepted.getItem().getIdItem());
			assertEquals(avisAgence.getUtilisateur().getIdUtilisateur(), avisAgenceExcepted.getUtilisateur().getIdUtilisateur());
			assertEquals(avisAgence.getCommentaire().getContenu(), avisAgenceExcepted.getCommentaire().getContenu());
			
			Collection<Note> notesExcepted = avisAgenceExcepted.getNotes();
			Collection<Note> notes = avisAgenceExcepted.getNotes();
			
			Iterator<Note> notesIterator = notes.iterator();
			Iterator<Note> notesExceptedIterator = notesExcepted.iterator();
			
			while (notesExceptedIterator.hasNext() && notesIterator.hasNext()) {
				
				Note noteExcepted = (Note) notesExceptedIterator.next();
				Note note = (Note) notesIterator.next();
				
				assertEquals(note.getIdNote(),noteExcepted.getIdNote());
				assertEquals(note.getValeur(),noteExcepted.getValeur());
				
			}
		}
		
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
