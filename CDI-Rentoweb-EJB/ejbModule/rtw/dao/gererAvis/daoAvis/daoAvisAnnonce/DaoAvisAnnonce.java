package rtw.dao.gererAvis.daoAvis.daoAvisAnnonce;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;



/**
 * Classe qui gère toute la DAO des avis annonce.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
public class DaoAvisAnnonce {
	
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisAnnonce() {
		
	}
	
	/**
	 * Trouve un {@link AvisAnnonce} a partir d'un {@link AvisAnnonce} 
	 * utiliser pour refresh le context, et modification.
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce}
	 */
	public AvisAnnonce find(AvisAnnonce avisAnnonce){
		
		avisAnnonce = em.find(AvisAnnonce.class, avisAnnonce);
		
		return avisAnnonce;
		
	}
	
	/**
	 * Persistance d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 */
	public void addAvisAnnonce(AvisAnnonce avisAnnonce){
		
		//TODO Throw Exception + try catch au niveau du service
		
		//find pour verification de doublons
		find(avisAnnonce);
		
		em.persist(avisAnnonce);
		
	}
	
	/**
	 * Edition d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 */
	public void editAvisAnnonce(AvisAnnonce avisAnnonce){
		
		em.merge(avisAnnonce);
		
	}
	
	/**
	 * Suppression d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 */
	public void removeAvisAnnonce(AvisAnnonce avisAnnonce){
		
		em.remove(avisAnnonce);
		
	}
	
}
