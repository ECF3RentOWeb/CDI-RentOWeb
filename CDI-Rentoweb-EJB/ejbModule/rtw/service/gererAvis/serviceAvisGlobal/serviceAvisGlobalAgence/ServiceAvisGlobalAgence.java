package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAgence;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.factory.FactoryAvisGlobal;

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
        
    }

    /**
	 * Service de persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
     * @return true if insert OK.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return facadeDaoAvis.addAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean supprimerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return facadeDaoAvis.deleteAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public AvisGlobalAgence rechercheAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		AvisGlobalAgence daoAvisGlobalAgence = facadeDaoAvis.findAvisGlobalAgence(avisGlobalAgence);
		FactoryAvisGlobal factoryAvisGlobal = new FactoryAvisGlobal();
		
		return (AvisGlobalAgence) factoryAvisGlobal.getAvisGlobalWithoutPersistentBag(daoAvisGlobalAgence);
		
	}
	
	/**
	 * Service de modification d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean modifierAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return facadeDaoAvis.updateAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public AvisGlobalAgence rechercheAvisGlobalAgenceById(Utilisateur utilisateur, Item item) {
		
		AvisGlobalAgence daoAvisGlobalAgence = facadeDaoAvis.findAvisGlobalAgenceById(utilisateur, item);
		FactoryAvisGlobal factoryAvisGlobal = new FactoryAvisGlobal();
		
		return (AvisGlobalAgence) factoryAvisGlobal.getAvisGlobalWithoutPersistentBag(daoAvisGlobalAgence);
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean supprimerAvisGlobalAgenceById(Utilisateur utilisateur, Item item) {
	
		return facadeDaoAvis.deleteAvisAgenceById(utilisateur, item);
	}
	
	/**
	 * Service d'instanciation d'un {@link AvisGlobalAgence} utilise la class {@link FactoryAvisGlobal}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * @return {@link AvisGlobalAgence}
	 */
	@Override
	public AvisGlobalAgence getAvisGlobalAgence(Utilisateur utilisateur,Item item) {
		
		FactoryAvisGlobal factoryAvisGlobal = new FactoryAvisGlobal();
		
		return factoryAvisGlobal.getAvisGlobalAgence(utilisateur,item);
	}

}
