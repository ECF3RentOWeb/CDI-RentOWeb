package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAgence;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;

/**
 * Facade de service pour les {@link AvisGlobalAgence}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Stateless
@LocalBean
public class ServiceAvisGlobalAgence implements ServiceAvisGlobalAgenceLocal {

	@EJB
	FacadeDaoAvis facadeDaoAvis;
	
    /**
     * Default constructor. 
     */
    public ServiceAvisGlobalAgence() {
        // TODO Auto-generated constructor stub
    }

    /**
	 * Service de persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		facadeDaoAvis.addAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void supprimerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		facadeDaoAvis.deleteAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void rechercheAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		facadeDaoAvis.findAvisGlobalAgence(avisGlobalAgence);
		
	}
	
	/**
	 * Service de modification d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void modifierAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		facadeDaoAvis.updateAvisGlobalAgence(avisGlobalAgence);
		
	}

}
