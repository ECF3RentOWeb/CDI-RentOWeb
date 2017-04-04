package rtw.dao.gererAvis.daoAvis.daoAvisAnnonce;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;
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
	public boolean addAvisAnnonce(AvisAnnonce avisAnnonce) throws DoublonAvisException{
		
		boolean retour = true;
		
		try {
			
			em.persist(avisAnnonce);
			
			
		} catch (PersistenceException e) {
			
			retour = false;
			e.getMessage();
			e.printStackTrace();
			
			Throwable t = e.getCause();
			
			while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
				t = t.getCause();
			}
			
			if(t instanceof SQLIntegrityConstraintViolationException){
				
				t.getMessage();
				System.out.println("atcha j'ai tout cassé dans le persit :3");
				throw new DoublonAvisException(t.getCause());
				
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
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete  :3");
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
			
			avisAnnonceRetour = em.find(AvisAnnonce.class, avisAnnonce.getId());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find  :3");
			avisAnnonceRetour = null;
			
		}
		
		return avisAnnonceRetour;

	}
	
	/**
	 * Recherche un {@link AvisAnnonce} par son ID.
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
			
			avisAnnonce = (AvisAnnonce) em.createQuery("select a from DtoAvis a where idUtilisateur = ?1 and idItem = ?2")
				.setParameter(1, utilisateur.getIdUtilisateur())
				.setParameter(2,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find by id :3");
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
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le update  :3");
			retour = false;
		}
		
		return retour;
	}
	
	
}
