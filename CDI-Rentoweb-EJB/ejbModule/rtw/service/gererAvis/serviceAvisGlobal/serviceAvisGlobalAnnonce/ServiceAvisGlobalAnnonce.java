package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAnnonce;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;

/**
 * Interface de la facade de service pour les {@link AvisGlobalAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Stateless
@LocalBean
public class ServiceAvisGlobalAnnonce implements ServiceAvisGlobalAnnonceLocal {

	@EJB
	FacadeDaoAvis facadeDaoAvis;
	
    /**
     * Default constructor. 
     */
    public ServiceAvisGlobalAnnonce() {
       
    }

    /**
	 * Service de persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void creerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {
		
		facadeDaoAvis.addAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void supprimerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		facadeDaoAvis.deleteAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void rechercheAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		facadeDaoAvis.findAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}
	
	/**
	 * Service de modification d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void modifierAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		facadeDaoAvis.updateAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

}
