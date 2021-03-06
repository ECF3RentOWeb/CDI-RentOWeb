/**
 * 
 */
package rtw.test.gererAvis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import rtw.entity.gererAvis.avis.entity.Avis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.entity.AvisGlobal;
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

/**
 * Classe de test JUnit pour la DAO de la fonctionnalité Gérer Avis.
 * 
 * @author Aurélien
 * @version 1
 * @since 29/03/2017
 *
 */
public class JUnitDaoAvis {
	
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
		
		AvisAnnonce avisAnnonce1 = createAvisAnnonce("5","5");
		AvisAgence avisAgence1 = createAvisAgence("6","6");
		AvisGlobalAgence avisGlobalAgence1 = createAvisGlobalAgence("7","7");
		AvisGlobalAnnonce avisGlobalAnnonce1 = createAvisGlobalAnnonce("8","8");
		
		AvisAnnonce avisAnnonce2 = createAvisAnnonce("13","13");
		AvisAgence avisAgence2 = createAvisAgence("14","14");
		AvisGlobalAgence avisGlobalAgence2 = createAvisGlobalAgence("15","15");
		AvisGlobalAnnonce avisGlobalAnnonce2 = createAvisGlobalAnnonce("16","16");
		
		AvisAnnonce avisAnnonce3 = createAvisAnnonce("17", "17");
		AvisAnnonce avisAnnonce4 = createAvisAnnonce("18", "17");
		AvisAnnonce avisAnnonce5 = createAvisAnnonce("19", "17");
		AvisAnnonce avisAnnonce6 = createAvisAnnonce("20", "17");
		
		AvisAgence avisAgence3 = createAvisAgence("21", "21");
		AvisAgence avisAgence4 = createAvisAgence("22", "21");
		AvisAgence avisAgence5 = createAvisAgence("23", "21");
		AvisAgence avisAgence6 = createAvisAgence("24", "21");
		
		context.close();
		
	}
	
	/**
	 * Test d'insertion d'un {@link AvisAnnonce} en BDD Cas Nominal.
	 */
	@Test
	public void testInsertAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("1","1");
		
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		AvisAnnonce avisAnnonceExcepted = facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce);
		
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
		
		assertTrue(retour);

	}
	
	/**
	 * Test d'insertion d'un {@link AvisAgence} en BDD.
	 */
	@Test
	public void testInsertAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("2","2");
		
		boolean retour = facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		AvisAgence avisAgenceExcepted = facadeServiceAvisRemote.rechercheAvisAgence(avisAgence);
		
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
		
		assertTrue(retour);
		
	}

	/**
	 * Test d'insertion d'un {@link AvisGlobalAgence} en BDD.
	 */
	@Test
	public void testInsertAvisGlobalAgence() {
		
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("3","3");
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAgence(avisGlobalAgence);
		
		AvisGlobalAgence avisGlobalAgenceExcepted = facadeServiceAvisRemote.rechercheAvisGlobalAgence(avisGlobalAgence);
		
		assertEquals(avisGlobalAgence.getItem().getIdItem(), avisGlobalAgenceExcepted.getItem().getIdItem());
		
		Collection<Note> notesExcepted = avisGlobalAgenceExcepted.getNotes();
		Collection<Note> notes = avisGlobalAgenceExcepted.getNotes();
		
		Iterator<Note> notesIterator = notes.iterator();
		Iterator<Note> notesExceptedIterator = notesExcepted.iterator();
		
		while (notesExceptedIterator.hasNext() && notesIterator.hasNext()) {
			
			Note noteExcepted = (Note) notesExceptedIterator.next();
			Note note = (Note) notesIterator.next();

			assertEquals(note.getIdNote(),noteExcepted.getIdNote());
			assertEquals(note.getValeur(),noteExcepted.getValeur());
		}
		
		assertTrue(retour);
		
	}
	
	/**
	 * Test d'insertion d'un {@link AvisGlobalAnnonce} en BDD.
	 */
	@Test
	public void testInsertAvisGlobalAnnonce() {
		
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("4","4");
		
		boolean retour = facadeServiceAvisRemote.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		AvisGlobalAnnonce avisGlobalAnnonceExcepted = facadeServiceAvisRemote.rechercheAvisGlobalAnnonce(avisGlobalAnnonce);
		
		assertEquals(avisGlobalAnnonce.getItem().getIdItem(), avisGlobalAnnonceExcepted.getItem().getIdItem());

		
		Collection<Note> notesExcepted = avisGlobalAnnonceExcepted.getNotes();
		Collection<Note> notes = avisGlobalAnnonceExcepted.getNotes();
		
		
		Iterator<Note> notesIterator = notes.iterator();
		Iterator<Note> notesExceptedIterator = notesExcepted.iterator();
		
		while (notesExceptedIterator.hasNext() && notesIterator.hasNext()) {
			
			Note noteExcepted = (Note) notesExceptedIterator.next();
			Note note = (Note) notesIterator.next();

			assertEquals(note.getIdNote(),noteExcepted.getIdNote());
			assertEquals(note.getValeur(),noteExcepted.getValeur());
		}
		
		assertTrue(retour);
		
	}
	
	/**
	 * Test de recherche d'un {@link AvisAnnonce} en BDD.
	 */
	@Test
	public void testFindAvisAnnonce() {
		
		AvisAnnonce avisAnnonce = createAvisAnnonce("5","5");
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		AvisAnnonce avisAnnonceRetour = facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce);
				
		assertNotNull(avisAnnonceRetour);
		
	}
	
	/**
	 * Test de recherche d'un {@link AvisAgence} en BDD.
	 */
	@Test
	public void testFindAvisAgence() {
		
		AvisAgence avisAgence = createAvisAgence("6","6");
		facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		AvisAgence avisAgenceRetour = facadeServiceAvisRemote.rechercheAvisAgence(avisAgence);
		
		assertNotNull(avisAgenceRetour);
	
	}

	/**
	 * Test de recherche d'un {@link AvisGlobalAgence} en BDD.
	 */
	@Test
	public void testFindAvisGlobalAgence() {
		
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("7","7");
		facadeServiceAvisRemote.creerAvisGlobalAgence(avisGlobalAgence);
		
		AvisGlobalAgence avisGlobalAgenceRetour = facadeServiceAvisRemote.rechercheAvisGlobalAgence(avisGlobalAgence);
		
		assertNotNull(avisGlobalAgenceRetour);
		
	}
	
	/**
	 * Test de recherche d'un {@link AvisGlobalAnnonce} en BDD.
	 */
	@Test
	public void testFindAvisGlobalAnnonce() {
		
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("8","8");
		facadeServiceAvisRemote.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		AvisGlobalAnnonce avisGlobalAnnonceRetour = facadeServiceAvisRemote.rechercheAvisGlobalAnnonce(avisGlobalAnnonce);
		
		assertNotNull(avisGlobalAnnonceRetour);
		
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
	 * Test d'modification d'un {@link AvisAnnonce} en BDD.
	 */
	@Test
	public void testUpdateAvisAnnonce() {
		
		//Creation
		AvisAnnonce avisAnnonce = createAvisAnnonce("13","13");
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		//Récupération
		avisAnnonce = facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce);
		
		//Modification
		avisAnnonce = (AvisAnnonce) modificateAvis(avisAnnonce);
		boolean retour = facadeServiceAvisRemote.modifierAvisAnnonce(avisAnnonce);
		
		//Récupération modifier
		AvisAnnonce avisAnnonceDao = facadeServiceAvisRemote.rechercheAvisAnnonce(avisAnnonce);
		
		assertTrue(retour);
		
		//Test de l'integrité du contenu
		assertEquals(avisAnnonce.getItem().getIdItem(), avisAnnonceDao.getItem().getIdItem());
		assertEquals(avisAnnonce.getUtilisateur().getIdUtilisateur(), avisAnnonceDao.getUtilisateur().getIdUtilisateur());
		assertEquals(avisAnnonce.getCommentaire().getContenu(), avisAnnonceDao.getCommentaire().getContenu());
		
		Collection<Note> notesDao = avisAnnonceDao.getNotes();
		Collection<Note> notes = avisAnnonce.getNotes();
		
		
		Iterator<Note> notesIterator = notes.iterator();
		Iterator<Note> notesDaoIterator = notesDao.iterator();
		
		while (notesDaoIterator.hasNext() && notesIterator.hasNext()) {
			
			Note noteDao = (Note) notesDaoIterator.next();
			Note note = (Note) notesIterator.next();
			
			assertEquals(note.getIdNote(),noteDao.getIdNote());
			assertEquals(note.getValeur(),noteDao.getValeur());
		}
		
	}
	
	/**
	 * Test d'modification d'un {@link AvisAgence} en BDD.
	 */
	@Test
	public void testUpdateAvisAgence() {
		
		//Creation
		AvisAgence avisAgence = createAvisAgence("14","14");
		facadeServiceAvisRemote.creerAvisAgence(avisAgence);
		
		//Récupération
		avisAgence = facadeServiceAvisRemote.rechercheAvisAgence(avisAgence);
		
		//Modification
		avisAgence = (AvisAgence) modificateAvis(avisAgence);
		boolean retour = facadeServiceAvisRemote.modifierAvisAgence(avisAgence);
		
		//Récupération modifier
		AvisAgence avisAgenceDao = facadeServiceAvisRemote.rechercheAvisAgence(avisAgence);
		
		assertTrue(retour);
		
		//Test de l'integrité du contenu
		assertEquals(avisAgence.getItem().getIdItem(), avisAgenceDao.getItem().getIdItem());
		assertEquals(avisAgence.getUtilisateur().getIdUtilisateur(), avisAgenceDao.getUtilisateur().getIdUtilisateur());
		assertEquals(avisAgence.getCommentaire().getContenu(), avisAgenceDao.getCommentaire().getContenu());
		
		Collection<Note> notesDao = avisAgenceDao.getNotes();
		Collection<Note> notes = avisAgence.getNotes();
		
		
		Iterator<Note> notesIterator = notes.iterator();
		Iterator<Note> notesDaoIterator = notesDao.iterator();
		
		while (notesDaoIterator.hasNext() && notesIterator.hasNext()) {
			
			Note noteDao = (Note) notesDaoIterator.next();
			Note note = (Note) notesIterator.next();
			
			assertEquals(note.getIdNote(),noteDao.getIdNote());
			assertEquals(note.getValeur(),noteDao.getValeur());
		}
		
	}

	/**
	 * Test d'modification d'un {@link AvisGlobalAgence} en BDD.
	 */
	@Test
	public void testUpdateAvisGlobalAgence() {
		
		//Creation
		AvisGlobalAgence avisGlobalAgence = createAvisGlobalAgence("15","15");
		facadeServiceAvisRemote.creerAvisGlobalAgence(avisGlobalAgence);
		
		//Récupération
		avisGlobalAgence = facadeServiceAvisRemote.rechercheAvisGlobalAgence(avisGlobalAgence);
		
		//Modification
		avisGlobalAgence = (AvisGlobalAgence) modificateAvisGlobal(avisGlobalAgence);
		boolean retour = facadeServiceAvisRemote.modifierAvisGlobalAgence(avisGlobalAgence);
		
		//Récupération modifier
		AvisGlobalAgence avisGlobalAgenceDao = facadeServiceAvisRemote.rechercheAvisGlobalAgence(avisGlobalAgence);
		
		assertTrue(retour);
		
		//Test de l'integrité du contenu
		assertEquals(avisGlobalAgence.getItem().getIdItem(), avisGlobalAgenceDao.getItem().getIdItem());

		Collection<Note> notesDao = avisGlobalAgenceDao.getNotes();
		Collection<Note> notes = avisGlobalAgence.getNotes();
		
		Iterator<Note> notesIterator = notes.iterator();
		Iterator<Note> notesDaoIterator = notesDao.iterator();
		
		while (notesDaoIterator.hasNext() && notesIterator.hasNext()) {
			
			Note noteDao = (Note) notesDaoIterator.next();
			Note note = (Note) notesIterator.next();
						
			assertEquals(note.getIdNote(),noteDao.getIdNote());
			assertEquals(note.getValeur(),noteDao.getValeur());
		}
		
	}
	
	/**
	 * Test d'modification d'un {@link AvisGlobalAnnonce} en BDD.
	 */
	@Test
	public void testUpdateAvisGlobalAnnonce() {
		
		//Creation
		AvisGlobalAnnonce avisGlobalAnnonce = createAvisGlobalAnnonce("16","16");
		facadeServiceAvisRemote.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
		//Récupération
		avisGlobalAnnonce = facadeServiceAvisRemote.rechercheAvisGlobalAnnonce(avisGlobalAnnonce);
		
		//Modification
		avisGlobalAnnonce = (AvisGlobalAnnonce) modificateAvisGlobal(avisGlobalAnnonce);
		boolean retour = facadeServiceAvisRemote.modifierAvisGlobalAnnonce(avisGlobalAnnonce);
		
		//Récupération modifier
		AvisGlobalAnnonce avisGlobalAnnonceDao = facadeServiceAvisRemote.rechercheAvisGlobalAnnonce(avisGlobalAnnonce);
		
		assertTrue(retour);
		
		//Test de l'integrité du contenu
		assertEquals(avisGlobalAnnonce.getItem().getIdItem(), avisGlobalAnnonceDao.getItem().getIdItem());

		Collection<Note> notesDao = avisGlobalAnnonceDao.getNotes();
		Collection<Note> notes = avisGlobalAnnonce.getNotes();
		
		Iterator<Note> notesIterator = notes.iterator();
		Iterator<Note> notesDaoIterator = notesDao.iterator();
		
		while (notesDaoIterator.hasNext() && notesIterator.hasNext()) {
			
			Note noteDao = (Note) notesDaoIterator.next();
			Note note = (Note) notesIterator.next();

			assertEquals(note.getIdNote(),noteDao.getIdNote());
			assertEquals(note.getValeur(),noteDao.getValeur());
		}
	}
	
	/**
	 * Test de récupération d'une {@link ArrayList} {@link AvisAnnonce} en BDD.
	 */
	@Test
	public void testFindListAvisAnnonce() {
		
		Item item = new Item();
		item.setIdItem("17");
		
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
		item.setIdItem("21");
		
		AvisAgence avisAgence1 = createAvisAgence("21", "21");
		AvisAgence avisAgence2 = createAvisAgence("22", "22");
		AvisAgence avisAgence3 = createAvisAgence("23", "23");
		AvisAgence avisAgence4 = createAvisAgence("24", "24");
		
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
	
//	/**
//	 *  Test d'insertion d'un {@link AvisAnnonce} avec une Notes null en BDD.
//	 */
//	@Test
//	public void testInsertNullAvisAnnonce() {
//		
//		AvisAnnonce avisAnnonce = createAvisAnnonce("25","25");
//		
//		avisAnnonce.setCommentaire(null);
//		avisAnnonce.setNotes(null);
//		avisAnnonce.getCommentaire().setContenu(null);
//		
//		Collection<Note> notes = new ArrayList<Note>();
//		
//		for (Note note : avisAnnonce.getNotes()) {
//			note = null;
//			note.setValeur(0);
//			notes.add(note);  
//		}
//		
//		avisAnnonce.setNotes(notes);
//		
//		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
//		
//		assertTrue(!retour);
//		
//	}


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
	

	private Avis modificateAvis(Avis avis) {
		
		Collection<Note> notes = avis.getNotes();
		Commentaire commentaire = avis.getCommentaire();
		
		commentaire.setContenu("Commentaire modifier");
		
		for (Note note : notes) {
			
			note.setValeur(9);
			
		}
		
		return avis;
	}
	
	private AvisGlobal modificateAvisGlobal(AvisGlobal avisGlobal) {
		
		Collection<Note> notes = avisGlobal.getNotes();
		
		for (Note note : notes) {
			
			note.setValeur(9);
			
		}
		
		return avisGlobal;
	}


	
}
