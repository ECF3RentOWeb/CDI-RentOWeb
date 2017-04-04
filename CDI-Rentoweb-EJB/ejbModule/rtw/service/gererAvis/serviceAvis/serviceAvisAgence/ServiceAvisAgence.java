package rtw.service.gererAvis.serviceAvis.serviceAvisAgence;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.factory.FactoryAvis;

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
     * @return true if insert OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean creerAvisAgence(AvisAgence avisAgence) {

		return facadeDaoAvis.addAvisAgence(avisAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean supprimerAvisAgence(AvisAgence avisAgence) {

		return facadeDaoAvis.deleteAvisAgence(avisAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	@Override
	public AvisAgence rechercheAvisAgence(AvisAgence avisAgence) {

		AvisAgence daoAvisAgence = facadeDaoAvis.findAvisAgence(avisAgence);
		FactoryAvis factoryAvis = new FactoryAvis();
		
		return (AvisAgence) factoryAvis.getAvisWithoutPersistentBag(daoAvisAgence);
		
	}
	
	/**
	 * Service de modification d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean modifierAvisAgence(AvisAgence avisAgence) {

		return facadeDaoAvis.updateAvisAgence(avisAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	@Override
	public AvisAgence rechercheAvisAgenceById(Utilisateur utilisateur, Item item) {
		
		AvisAgence daoAvisAgence = facadeDaoAvis.findAvisAgenceById(utilisateur, item);
		FactoryAvis factoryAvis = new FactoryAvis();
		
		return (AvisAgence) factoryAvis.getAvisWithoutPersistentBag(daoAvisAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean supprimerAvisAgenceById(Utilisateur utilisateur, Item item) {
		
		return facadeDaoAvis.deleteAvisAnnonceById(utilisateur, item);
		
	}
	
	/**
	 * Service d'instanciation d'un {@link AvisAgence} utilise la class {@link FactoryAvis}
	 * 
	 * @return {@link AvisAgence}
	 */
	@Override
	public AvisAgence getAvisAgence(Utilisateur utilisateur,Item item) {
		FactoryAvis factoryAvis = new FactoryAvis();
		return factoryAvis.getAvisAgence(utilisateur,item);
	}

}
