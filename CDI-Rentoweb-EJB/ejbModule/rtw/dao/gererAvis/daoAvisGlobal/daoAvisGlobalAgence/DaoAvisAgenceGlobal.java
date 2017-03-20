package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;

/**
 * Classe qui gère toute la DAO des avis agence global.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
public class DaoAvisAgenceGlobal {
	
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisAgenceGlobal() {
		
	}

	
	/**
	 * Trouve un {@link AvisGlobalAgence} a partir d'un {@link AvisGlobalAgence} 
	 * utiliser pour refresh le context, et modification.
	 * 
	 * @param avisAgenceGlobal{@link AvisGlobalAgence}
	 * @return avisAgenceGlobal{@link AvisGlobalAgence}
	 */
	public AvisGlobalAgence find(AvisGlobalAgence avisAgenceGlobal){
		
		avisAgenceGlobal= em.find(AvisGlobalAgence.class, avisAgenceGlobal);
		
		return avisAgenceGlobal;
		
	}
	
	/**
	 * Persistance d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisAgenceGlobal{@link AvisGlobalAgence}
	 */
	public void addAvisAgenceGlobal(AvisGlobalAgence avisAgenceGlobal){
		
		//TODO Throw Exception + try catch au niveau du service
		
		//find pour verification de doublons
		find(avisAgenceGlobal);
		
		em.persist(avisAgenceGlobal);
		
	}
	
	/**
	 * Edition d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisAgenceGlobal{@link AvisGlobalAgence}
	 */
	public void editAvisAgenceGlobal(AvisGlobalAgence avisAgenceGlobal){
		
		em.merge(avisAgenceGlobal);
		
	}
	
	/**
	 * Suppression d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisAgenceGlobal{@link AvisGlobalAgence}
	 */
	public void removeAvisAgenceGlobal(AvisGlobalAgence avisAgenceGlobal){
		
		em.remove(avisAgenceGlobal);
		
	}
	
}
