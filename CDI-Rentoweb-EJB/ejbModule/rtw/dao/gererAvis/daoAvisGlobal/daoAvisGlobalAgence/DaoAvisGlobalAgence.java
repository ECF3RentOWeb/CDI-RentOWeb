package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;

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
	@PersistenceContext(unitName="rentoweb")
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
	 */
	@Override
	public void addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		em.persist(avisGlobalAgence);
		
	}

	/**
	 * Suppression d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 */
	@Override
	public void deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		avisGlobalAgence = findAvisGlobalAgence(avisGlobalAgence);
		em.remove(avisGlobalAgence);
		
	}

	/**
	 * Recherche d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence}
	 */
	@Override
	public AvisGlobalAgence findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return em.find(AvisGlobalAgence.class, avisGlobalAgence.getId());
		
	}
	
	/**
	 * Update d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 */
	@Override
	public void updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		em.merge(avisGlobalAgence);
		
	}

	
}
