package rtw.service.gererAvis.serviceAvis.serviceAvisAgence;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;

/**
 * Facade de service pour les {@link AvisAgence}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Stateless
@LocalBean
public class ServiceAvisAgence implements ServiceAvisAgenceLocal {

	@EJB
	FacadeDaoAvis facadeDaoAvis;
	
    /**
     * Default constructor. 
     */
    public ServiceAvisAgence() {
        
    }

    /**
	 * Service de persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void creerAvisAgence(AvisAgence avisAgence) {

		facadeDaoAvis.addAvisAgence(avisAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void supprimerAvisAgence(AvisAgence avisAgence) {

		facadeDaoAvis.deleteAvisAgence(avisAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void rechercheAvisAgence(AvisAgence avisAgence) {

		facadeDaoAvis.findAvisAgence(avisAgence);
		
	}
	
	/**
	 * Service de modification d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void modifierAvisAgence(AvisAgence avisAgence) {

		facadeDaoAvis.updateAvisAgence(avisAgence);
		
	}

}
