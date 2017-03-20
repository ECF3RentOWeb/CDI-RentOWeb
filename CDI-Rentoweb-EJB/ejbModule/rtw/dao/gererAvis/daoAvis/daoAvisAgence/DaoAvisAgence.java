package rtw.dao.gererAvis.daoAvis.daoAvisAgence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;


/**
 * Classe qui gère toute la DAO des avis agence.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
public class DaoAvisAgence {
	
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisAgence() {
		
	}

	
	/**
	 * Trouve un {@link AvisAnnonce} a partir d'un {@link AvisAnnonce} 
	 * utiliser pour refresh le context, et modification.
	 * 
	 * @param avisAgence{@link AvisAnnonce}
	 * @return avisAgence{@link AvisAnnonce}
	 */
	public AvisAgence find(AvisAgence avisAgence){
		
		avisAgence= em.find(AvisAgence.class, avisAgence);
		
		return avisAgence;
		
	}
	
	/**
	 * Persistance d'un {@link AvisAnnonce}
	 * 
	 * @param avisAgence{@link AvisAnnonce}
	 */
	public void addAvisAnnonce(AvisAgence avisAgence){
		
		//TODO Throw Exception + try catch au niveau du service
		
		//find pour verification de doublons
		find(avisAgence);
		
		em.persist(avisAgence);
		
	}
	
	/**
	 * Edition d'un {@link AvisAnnonce}
	 * 
	 * @param avisAgence{@link AvisAnnonce}
	 */
	public void editAvisAnnonce(AvisAgence avisAgence){
		
		em.merge(avisAgence);
		
	}
	
	/**
	 * Suppression d'un {@link AvisAnnonce}
	 * 
	 * @param avisAgence{@link AvisAnnonce}
	 */
	public void removeAvisAnnonce(AvisAgence avisAgence){
		
		em.remove(avisAgence);
		
	}
	
}
