package rtw.dao.gererAvis.daoAvis.daoAvisAnnonce;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;
import rtw.technique.gererAvis.ListeAvisAnnonce;
import rtw.util.ParametreCommun;

/**
 * Classe qui gère toute la DAO des {@link AvisAnnonce}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisAnnonce implements DaoAvisAnnonceLocal {
	
	//TODO persistence Name
	@PersistenceContext(unitName=ParametreCommun.PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisAnnonce() {
		
	}
	
	/**
	 * Persistance d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if insert OK.
	 * @throws DoublonAvisException 
	 */
	public boolean addAvisAnnonce(AvisAnnonce avisAnnonce) throws DoublonAvisException {
		
		boolean retour = true;
		
		try {
			
			//TODO DELETE USED FOR TEST
			em.persist(avisAnnonce.getItem());
			em.persist(avisAnnonce.getUtilisateur());
			
			em.persist(avisAnnonce);			
			em.flush();
			
		}catch (PersistenceException eee) {
			
			retour = false;
			eee.printStackTrace();
		
			retour = false;
			eee.getMessage();
			eee.printStackTrace();
			
			Throwable t = eee.getCause();
			
			
			
			while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
				t = t.getCause();
			}
			
			if(t instanceof SQLIntegrityConstraintViolationException){

				throw new DoublonAvisException();
				//System.out.println("atcha je t'ai tout cassé dans le persit :3");
				//System.out.println("erk mais pourquoi ta fais ca -_-");
				
			}
		}
		return retour;
	}
	
	/**
	 * Suppression d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce{@link AvisAnnonce}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisAnnonce(AvisAnnonce avisAnnonce) {
		
		boolean retour = true;

		avisAnnonce = findAvisAnnonce(avisAnnonce);
		
		try {
			
			em.remove(avisAnnonce);
			em.flush();
			
		} catch (Exception e) {

			e.printStackTrace();
			//System.out.println("atcha j'ai tout cassé dans le delete  :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * TODO FindAvisAnnonceById
	 * 
	 * Recherche d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce} Null Si KO.
	 * 
	 */
	@Override
	public AvisAnnonce findAvisAnnonce(AvisAnnonce avisAnnonce) {
		
		AvisAnnonce avisAnnonceRetour;
		
		try {
			
			avisAnnonceRetour = em.find(AvisAnnonce.class, avisAnnonce.getUtilisateur().getIdUtilisateur());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			//System.out.println("atcha j'ai tout cassé dans le find  :3");
			avisAnnonceRetour = null;
			
		}
		
		return avisAnnonceRetour;

	}
	
	/**
	 * Recherche un {@link AvisAnnonce} par son ID et par l'ID de l'utilisateur.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * 
	 */
	@Override
	public AvisAnnonce findAvisAnnonceById(Utilisateur utilisateur,Item item) {

		AvisAnnonce avisAnnonce;
		
		try {
			
			avisAnnonce = (AvisAnnonce) em.createQuery("select a from Avis a where idUtilisateur = ?1 and idItem = ?2")
				.setParameter(1, utilisateur.getIdUtilisateur())
				.setParameter(2,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {

			e.getMessage();
			e.printStackTrace();
			//System.out.println("atcha j'ai tout cassé dans le find by id :3");
			avisAnnonce = null;
		}
		
		return avisAnnonce;

	}
	
	/**
	 * Suppression d'un {@link AvisAnnonce} par son ID.
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisAnnonceById(Utilisateur utilisateur,Item item) {

		boolean retour = true;
		
		try {
			
			em.createQuery("delete from AvisAnnonce where idUtilisateur = ?1 and idItem = ?2")
			.setParameter(1, utilisateur.getIdUtilisateur())
			.setParameter(2,item.getIdItem()).executeUpdate();
			
			em.flush();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			//System.out.println("atcha j'ai tout cassé dans le delete by id :3");
			retour = false;
			
		}
		
		return retour;
		
	}
	
	/**
	 * update d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if update OK.
	 */
	@Override
	public boolean updateAvisAnnonce(AvisAnnonce avisAnnonce) {

		boolean retour = true;
		
		try {
			
			em.merge(avisAnnonce);
			em.flush();
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			//System.out.println("atcha j'ai tout cassé dans le update  :3");
			retour = false;
		}
		
		return retour;
	}

	/**
	 * Récupération d'une liste d' {@link AvisAnnonce} en {@link ArrayList}
	 * 
	 * @param item {@link Item}
	 * @return listeAvisAnnonce {@link ArrayList}
	 */
	@Override
	public ListeAvisAnnonce listeAvisAnnonceByIdItem(Item item) {
		
		ListeAvisAnnonce listeAvisAnnonce = new ListeAvisAnnonce();
				
		 for (Object result : em.createQuery("select a from AvisAnnonce a where idItem = ?1")
					.setParameter(1, item.getIdItem()).getResultList()) {
			 if(result instanceof AvisAnnonce){
				 
				 listeAvisAnnonce.add((AvisAnnonce) result);
			 }
			
		}
		
		return listeAvisAnnonce;
		
	}
}
