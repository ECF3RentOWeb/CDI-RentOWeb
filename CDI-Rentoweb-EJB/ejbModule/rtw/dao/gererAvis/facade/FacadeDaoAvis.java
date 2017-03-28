package rtw.dao.gererAvis.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;

/**
 * Session bean facade de la DAO de la fonctionnalité gérer avis.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Stateless
@LocalBean
public class FacadeDaoAvis implements FacadeDaoAvisLocal {

	@EJB
	DaoAvisAgence daoAvisAgence;
	@EJB
	DaoAvisAnnonce daoAvisAnnonce;
	@EJB
	DaoAvisGlobalAgence daoAvisGlobalAgence;
	@EJB
	DaoAvisGlobalAnnonce daoAvisGlobalAnnonce;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoAvis() {
        
    }

    /**
	 * Persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void addAvisAgence(AvisAgence avisAgence) {

		daoAvisAgence.addAvisAgence(avisAgence);
		
	}

	/**
	 * Persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void addAvisAnnonce(AvisAnnonce avisAnnonce) {

		daoAvisAnnonce.addAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		daoAvisGlobalAnnonce.addAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		daoAvisGlobalAgence.addAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Delete {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void deleteAvisAgence(AvisAgence avisAgence) {

		daoAvisAgence.deleteAvisAgence(avisAgence);
		
	}

	/**
	 * Delete {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void deleteAvisAnnonce(AvisAnnonce avisAnnonce) {
			
		daoAvisAnnonce.deleteAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Delete {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		daoAvisGlobalAgence.deleteAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Delete {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {
			
		daoAvisGlobalAnnonce.deleteAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Find {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void findAvisAgence(AvisAgence avisAgence) {
		
		daoAvisAgence.findAvisAgence(avisAgence);

	}

	/**
	 * Find {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void findAvisAnnonce(AvisAnnonce avisAnnonce) {

		daoAvisAnnonce.findAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Find {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		daoAvisGlobalAgence.findAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Find {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		daoAvisGlobalAnnonce.findAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}
    
	/**
	 * Update {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void updateAvisAgence(AvisAgence avisAgence) {
		
		daoAvisAgence.updateAvisAgence(avisAgence);

	}

	/**
	 * Update {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void updateAvisAnnonce(AvisAnnonce avisAnnonce) {

		daoAvisAnnonce.updateAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Update {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		daoAvisGlobalAgence.updateAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Update {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		daoAvisGlobalAnnonce.updateAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}
    

}
