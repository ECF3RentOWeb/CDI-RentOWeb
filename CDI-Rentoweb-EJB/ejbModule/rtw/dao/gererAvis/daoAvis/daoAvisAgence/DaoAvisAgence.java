package rtw.dao.gererAvis.daoAvis.daoAvisAgence;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;

/**
 * Classe qui gère toute la DAO des {@link AvisAgence}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisAgence implements DaoAvisAgenceLocal {

	//TODO persistence Name
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public DaoAvisAgence() {
		
	}
	
	
	/**
	 * Persistance d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 */
	public void addAvisAgence(AvisAgence avisAgence){

		em.persist(avisAgence);
		
	}


	/**
	 * Suppression d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 */
	@Override
	public void deleteAvisAgence(AvisAgence avisAgence) {

		avisAgence = findAvisAgence(avisAgence);
		em.remove(avisAgence);
		
	}

	/**
	 * Recherche d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return 
	 */
	@Override
	public AvisAgence findAvisAgence(AvisAgence avisAgence) {

		return em.find(AvisAgence.class, avisAgence.getId());
		
	}
	
	/**
	 * Update d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 */
	@Override
	public void updateAvisAgence(AvisAgence avisAgence) {

		em.merge(avisAgence);
		
	}
	
	
}
