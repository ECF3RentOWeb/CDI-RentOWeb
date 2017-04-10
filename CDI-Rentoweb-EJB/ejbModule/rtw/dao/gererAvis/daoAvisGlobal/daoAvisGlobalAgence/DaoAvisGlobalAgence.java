package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;
import rtw.util.ParametreCommun;

/**
 * Classe qui gère toute la DAO des {@link AvisGlobalAgence}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisGlobalAgence implements DaoAvisGlobalAgenceLocal {
	
	//TODO persistence Name
	@PersistenceContext(unitName=ParametreCommun.PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisGlobalAgence() {
		
	}

	/**
	 * Persistance d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if insert OK.
	 * @throws DoublonAvisException 
	 */
	@Override
	public boolean addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) throws DoublonAvisException {

		boolean retour = true;
		
		try {
			
			//TODO DELETE USED FOR TEST
			em.persist(avisGlobalAgence.getItem());
			
			em.persist(avisGlobalAgence);			
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
	 * Suppression d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		boolean retour = true;

		avisGlobalAgence = findAvisGlobalAgence(avisGlobalAgence);
		
		try {
			
			em.remove(avisGlobalAgence);
			em.flush();
			
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete  :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Recherche d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 */
	@Override
	public AvisGlobalAgence findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		AvisGlobalAgence avisGlobalAgenceRetour;

		try {
			
			avisGlobalAgenceRetour = em.find(AvisGlobalAgence.class, avisGlobalAgence.getItem().getIdItem());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find  :3");
			avisGlobalAgenceRetour = null;
		}

		return avisGlobalAgenceRetour;	
				
	}
	
	/**
	 * Recherche un {@link AvisGlobalAgence} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 * 
	 */
	@Override
	public AvisGlobalAgence findAvisGlobalAgenceById(Item item) {

		AvisGlobalAgence avisGlobalAgence;
		
		try {
			
			avisGlobalAgence = (AvisGlobalAgence) em.createQuery("select a from Avis a where idItem = ?1")
			.setParameter(1,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find by id :3");
			avisGlobalAgence = null;
		}

		return avisGlobalAgence;	

	}
	
	/**
	 * Suppression d'un {@link AvisGlobalAgence} par son ID.
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAgenceById(Item item) {

		boolean retour = true;
		
		try {
			
			em.createQuery("delete from AvisGlobalAgence where idItem = ?1")
			.setParameter(1,item.getIdItem()).executeUpdate();
			
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
	 * Update d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if update OK.
	 */
	@Override
	public boolean updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		boolean retour = true;
		try {
			
			em.merge(avisGlobalAgence);
			em.flush();
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le update  :3");
			retour = false;
		}
		
		return retour;
		
	}

	
}
