package rtw.dao.gererAvis.daoAvis.daoAvisAnnonce;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.entity.Avis;
import rtw.entity.gererAvis.entity.AvisAnnonce;
import rtw.util.ParametreCommun;

/**
 * Classe qui gère toute la DAO des avis annonce.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
public class DaoAvisAnnonce {
	
	@PersistenceContext(unitName=ParametreCommun.PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisAnnonce() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Trouve un {@link AvisAnnonce} a partir d'un {@link AvisAnnonce} 
	 * utiliser pour refresh le context, verification de doublons et modification.
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce}
	 */
	public AvisAnnonce find(AvisAnnonce avisAnnonce){
		
		
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
