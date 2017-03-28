package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;



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
	@PersistenceContext(unitName="rentoweb")
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
	 */
	@Override
	public void addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		em.persist(avisGlobalAnnonce);
		
	}

	/**
	 * Suppression d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 */
	@Override
	public void deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		avisGlobalAnnonce = findAvisGlobalAnnonce(avisGlobalAnnonce);
		em.remove(avisGlobalAnnonce);
		
	}

	/**
	 * Recherche d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 */
	@Override
	public AvisGlobalAnnonce findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		return em.find(AvisGlobalAnnonce.class, avisGlobalAnnonce.getId());
		
	}
	
	/**
	 * Update d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce{@link AvisGlobalAnnonce}
	 */
	@Override
	public void updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		em.merge(avisGlobalAnnonce);
		
	}

	
}
