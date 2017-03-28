package rtw.service.gererAvis.serviceAvis.serviceAvisAnnonce;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;

/**
 * Facade de service pour les {@link AvisAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Stateless
@LocalBean
public class ServiceAvisAnnonce implements ServiceAvisAnnonceLocal {

	@EJB
	FacadeDaoAvis facadeDaoAvis;
	
    /**
     * Default constructor. 
     */
    public ServiceAvisAnnonce() {
        
    }

    /**
	 * Service de persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAgence {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void creerAvisAnnonce(AvisAnnonce avisAnnonce) {

		facadeDaoAvis.addAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAgence {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void supprimerAvisAnnonce(AvisAnnonce avisAnnonce) {

		facadeDaoAvis.deleteAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAgence {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void rechercheAvisAnnonce(AvisAnnonce avisAnnonce) {

		facadeDaoAvis.findAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de modification d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void modifierAvisAnnonce(AvisAnnonce avisAnnonce) {

		facadeDaoAvis.updateAvisAnnonce(avisAnnonce);
		
	}
	

}
