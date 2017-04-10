package rtw.dao.gererAvis.daoAvis.daoAvisAgence;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;
import rtw.technique.gererAvis.ListeAvisAgence;
import rtw.util.ParametreCommun;

/**
 * Classe qui gère toute la DAO des {@link AvisAgence}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisAgence implements DaoAvisAgenceLocal {

	@PersistenceContext(unitName=ParametreCommun.PERSISTENCE_UNIT_NAME)
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public DaoAvisAgence() {
		
	}
	
	/**
	 * Persistance d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if insert OK.
	 * @throws DoublonAvisException 
	 */
	public boolean addAvisAgence(AvisAgence avisAgence) throws DoublonAvisException{

		boolean retour = true;
		
		try {
			
			//TODO DELETE USED FOR TEST
			em.persist(avisAgence.getItem());
			em.persist(avisAgence.getUtilisateur());
			
			em.persist(avisAgence);			
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
				
			}
		}
		return retour;
		
	}


	/**
	 * Suppression d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisAgence(AvisAgence avisAgence) {

		boolean retour = true;
		
		avisAgence = findAvisAgence(avisAgence);
		
		try {

			em.remove(avisAgence);
			em.flush();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete  :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Recherche d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * 
	 */ 
	@Override
	public AvisAgence findAvisAgence(AvisAgence avisAgence) {

		AvisAgence avisAgenceRetour;
		
		try {
			
			avisAgenceRetour = em.find(AvisAgence.class, avisAgence.getUtilisateur().getIdUtilisateur());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find :3");
			avisAgenceRetour = null;
		}
				
		return avisAgenceRetour;
		
	}
	
	/**
	 * Recherche un {@link AvisAgence} par son ID et par l'ID de l'utilisateur.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * 
	 */
	@Override
	public AvisAgence findAvisAgenceById(Utilisateur utilisateur,Item item) {
		
		AvisAgence avisAgence;
		
		try {
			
			avisAgence = (AvisAgence) em.createQuery("select a from Avis a where idUtilisateur = ?1 and idItem = ?2")
				.setParameter(1, utilisateur.getIdUtilisateur())
				.setParameter(2,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find by id :3");
			avisAgence = null;
		}
		
		return avisAgence;

	}
	
	/**
	 * Suppression d'un {@link AvisAgence} par son ID.
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisAgenceById(Utilisateur utilisateur,Item item) {

		boolean retour = true;
		
		try {
			
			em.createQuery("delete from AvisAgence where idUtilisateur = ?1 and idItem = ?2")
			.setParameter(1, utilisateur.getIdUtilisateur())
			.setParameter(2,item.getIdItem()).executeUpdate();
			
			em.flush();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete by id :3");
			retour = false;
			
		}
		
		return retour;
		
	}
	
	/**
	 * Update d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 */
	@Override
	public boolean updateAvisAgence(AvisAgence avisAgence) {

		boolean retour = true;
		
		try {
			
			em.merge(avisAgence);
			em.flush();
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le update  :3");
			retour = false;
		}
		
		return retour;
		
	}

	/**
	 * Récupération d'une liste d' {@link AvisAgence} en {@link ArrayList}
	 * 
	 * @param item {@link Item}
	 * @return listeAvisAgence {@link ArrayList}
	 */
	@Override
	public ListeAvisAgence listeAvisAgenceByIdItem(Item item) {
		
		ListeAvisAgence listeAvisAgence = new ListeAvisAgence();
		
		 for (Object result : em.createQuery("select a from AvisAgence a where idItem = ?1")
					.setParameter(1, item.getIdItem()).getResultList()) {
			 if(result instanceof AvisAgence){
				 
				 listeAvisAgence.add((AvisAgence) result);
			 }
			
		}
	
		return listeAvisAgence;
		
	}
	
	
}
