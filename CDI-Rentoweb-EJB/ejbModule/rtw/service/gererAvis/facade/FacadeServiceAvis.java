package rtw.service.gererAvis.facade;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import rtw.clientServer.gererAvis.FacadeServiceAvisRemote;
import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avis.entity.Avis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.service.gererAvis.serviceAvis.serviceAvisAgence.ServiceAvisAgence;
import rtw.service.gererAvis.serviceAvis.serviceAvisAnnonce.ServiceAvisAnnonce;
import rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAgence.ServiceAvisGlobalAgence;
import rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAnnonce.ServiceAvisGlobalAnnonce;

/**
 * Facade des service de la fonctionnalité gérer {@link Avis}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Stateless
@Remote(FacadeServiceAvisRemote.class)
public class FacadeServiceAvis implements FacadeServiceAvisRemote {

	@EJB
	ServiceAvisAgence serviceAvisAgence;
	@EJB
	ServiceAvisAnnonce serviceAvisAnnonce;
	@EJB
	ServiceAvisGlobalAnnonce serviceAvisGlobalAnnonce;
	@EJB
	ServiceAvisGlobalAgence serviceAvisGlobalAgence;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceAvis() {
       
    }

    /**
	 * Service de persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void creerAvisAnnonce(AvisAnnonce avisAnnonce) {

		serviceAvisAnnonce.creerAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void creerAvisAgence(AvisAgence avisAgence) {

		serviceAvisAgence.creerAvisAgence(avisAgence);
		
	}

	/**
	 * Service de persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void creerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		serviceAvisGlobalAnnonce.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		serviceAvisGlobalAgence.creerAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void supprimerAvisAnnonce(AvisAnnonce avisAnnonce) {

		serviceAvisAnnonce.supprimerAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void supprimerAvisAgence(AvisAgence avisAgence) {

		serviceAvisAgence.supprimerAvisAgence(avisAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void supprimerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		serviceAvisGlobalAnnonce.supprimerAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void supprimerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		serviceAvisGlobalAgence.supprimerAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void rechercheAvisAnnonce(AvisAnnonce avisAnnonce) {

		serviceAvisAnnonce.rechercheAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void rechercheAvisAgence(AvisAgence avisAgence) {

		serviceAvisAgence.rechercheAvisAgence(avisAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void rechercheAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		serviceAvisGlobalAnnonce.rechercheAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void rechercheAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {
		
		serviceAvisGlobalAgence.rechercheAvisGlobalAgence(avisGlobalAgence);
		
	}
	
	/**
	 * Service de modification d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	@Override
	public void modifierAvisAnnonce(AvisAnnonce avisAnnonce) {

		serviceAvisAnnonce.modifierAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de modification d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	@Override
	public void modifierAvisAgence(AvisAgence avisAgence) {

		serviceAvisAgence.modifierAvisAgence(avisAgence);
		
	}

	/**
	 * Service de modification d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public void modifierAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		serviceAvisGlobalAnnonce.modifierAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de modification d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public void modifierAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {
		
		serviceAvisGlobalAgence.modifierAvisGlobalAgence(avisGlobalAgence);
		
	}

}
