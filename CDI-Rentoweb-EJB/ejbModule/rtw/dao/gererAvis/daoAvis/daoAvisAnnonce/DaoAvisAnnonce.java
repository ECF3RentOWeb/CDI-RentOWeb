package rtw.dao.gererAvis.daoAvis.daoAvisAnnonce;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;

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
	@PersistenceContext(unitName="rentoweb")
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
	 */
	public void addAvisAnnonce(AvisAnnonce avisAnnonce){
		
		em.persist(avisAnnonce);
		
	}
	
	/**
	 * Suppression d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce{@link AvisAnnonce}
	 */
	@Override
	public void deleteAvisAnnonce(AvisAnnonce avisAnnonce) {

		avisAnnonce = findAvisAnnonce(avisAnnonce);
		em.remove(avisAnnonce);
		
	}

	/**
	 * TODO FindAvisAnnonceById
	 * 
	 * Recherche d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce}
	 * 
	 */
	@Override
	public AvisAnnonce findAvisAnnonce(AvisAnnonce avisAnnonce) {

		return em.find(AvisAnnonce.class, avisAnnonce.getId());
		
	}
	
	/**
	 * update d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 */
	@Override
	public void updateAvisAnnonce(AvisAnnonce avisAnnonce) {

		em.merge(avisAnnonce);
		
	}
	
	
}
