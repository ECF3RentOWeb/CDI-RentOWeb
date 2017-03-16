package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;



/**
 * Classe qui gère toute la DAO des avis annonce global.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
public class DaoAvisAnnonceGlobal {
	
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisAnnonceGlobal() {
		
	}

	
	/**
	 * Trouve un {@link AvisGlobalAnnonce} a partir d'un {@link AvisGlobalAnnonce} 
	 * utiliser pour refresh le context, et modification.
	 * 
	 * @param avisAnnonceGlobal{@link AvisGlobalAnnonce}
	 * @return avisAnnonceGlobal{@link AvisGlobalAnnonce}
	 */
	public AvisGlobalAnnonce find(AvisGlobalAnnonce avisGlobalAnnonce){
		
		avisGlobalAnnonce= em.find(AvisGlobalAnnonce.class, avisGlobalAnnonce);
		
		return avisGlobalAnnonce;
		
	}
	
	/**
	 * Persistance d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisAnnonceGlobal{@link AvisGlobalAnnonce}
	 */
	public void addAvisAnnonceGlobal(AvisGlobalAnnonce avisGlobalAnnonce){
		
		//TODO Throw Exception + try catch au niveau du service
		
		//find pour verification de doublons
		find(avisGlobalAnnonce);
		
		em.persist(avisGlobalAnnonce);
		
	}
	
	/**
	 * Edition d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisAnnonceGlobal{@link AvisGlobalAnnonce}
	 */
	public void editAvisAnnonceGlobal(AvisGlobalAnnonce avisGlobalAnnonce){
		
		em.merge(avisGlobalAnnonce);
		
	}
	
	/**
	 * Suppression d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisAnnonceGlobal{@link AvisGlobalAnnonce}
	 */
	public void removeAvisAnnonceGlobal(AvisGlobalAnnonce avisGlobalAnnonce){
		
		em.remove(avisGlobalAnnonce);
		
	}
	
}
