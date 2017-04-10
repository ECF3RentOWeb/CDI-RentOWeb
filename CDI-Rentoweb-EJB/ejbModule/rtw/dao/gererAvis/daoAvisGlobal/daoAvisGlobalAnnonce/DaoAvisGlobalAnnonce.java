package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;
import rtw.util.ParametreCommun;



/**
 * Classe qui gère toute la DAO des {@link AvisGlobalAnnonce}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisGlobalAnnonce implements DaoAvisGlobalAnnonceLocal {
	
	//TODO persistence Name
	@PersistenceContext(unitName=ParametreCommun.PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisGlobalAnnonce() {
		
	}

	/**
	 * Persistance d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if insert OK.
	 * @throws DoublonAvisException 
	 */
	@Override
	public boolean addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) throws DoublonAvisException {

		boolean retour = true;
		
		try {
			
			//TODO DELETE USED FOR TEST
			em.persist(avisGlobalAnnonce.getItem());
			
			em.persist(avisGlobalAnnonce);			
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
	 * Suppression d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		boolean retour = true;

		avisGlobalAnnonce = findAvisGlobalAnnonce(avisGlobalAnnonce);
		
		try {
			
			em.remove(avisGlobalAnnonce);
			em.flush();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete  :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Recherche d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db
	 */
	@Override
	public AvisGlobalAnnonce findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		AvisGlobalAnnonce avisGlobalAnnonceRetour;
		
		try {
			
			avisGlobalAnnonceRetour = em.find(AvisGlobalAnnonce.class, avisGlobalAnnonce.getItem().getIdItem());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find  :3");
			avisGlobalAnnonceRetour = null;
		}
		
		return avisGlobalAnnonceRetour;
		
	}
	
	/**
	 * Recherche un {@link AvisGlobalAnnonce} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * 
	 */
	@Override
	public AvisGlobalAnnonce findAvisGlobalAnnonceById(Item item) {

		AvisGlobalAnnonce avisGlobalAnnonce;
		
		try {
			
			avisGlobalAnnonce = (AvisGlobalAnnonce) em.createQuery("select a from Avis a where idItem = ?1")
			.setParameter(1,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find by id :3");
			avisGlobalAnnonce = null;
		}
		
		return avisGlobalAnnonce;

	}
	
	/**
	 * Suppression d'un {@link AvisGlobalAnnonce} par son ID.
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAnnonceById(Item item) {

		boolean retour = true;
		
		try {
			
			em.createQuery("delete from AvisGlobalAnnonce where idItem = ?1")
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
	 * Update d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce{@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 */
	@Override
	public boolean updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		boolean retour = true;
		try {
			
			em.merge(avisGlobalAnnonce);
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
