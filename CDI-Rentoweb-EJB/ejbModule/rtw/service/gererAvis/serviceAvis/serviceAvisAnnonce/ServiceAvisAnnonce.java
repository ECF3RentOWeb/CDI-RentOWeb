package rtw.service.gererAvis.serviceAvis.serviceAvisAnnonce;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;
import rtw.service.gererAvis.factory.FactoryAvis;

/**
 * Facade de service pour les {@link AvisAnnonce}.
 * 
 * @author Aur�lien
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
     * @return true if insert OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean creerAvisAnnonce(AvisAnnonce avisAnnonce) {
		
		boolean retour = true;
		
		try {
			
			return facadeDaoAvis.addAvisAnnonce(avisAnnonce);
			
		} catch (DoublonAvisException e) {
			
			e.printStackTrace();
			retour = false;
			
		}
		return retour;
	}

	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAgence {@link AvisAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean supprimerAvisAnnonce(AvisAnnonce avisAnnonce) {

		return facadeDaoAvis.deleteAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAgence {@link AvisAnnonce}
	 * @return avisAgence {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public AvisAnnonce rechercheAvisAnnonce(AvisAnnonce avisAnnonce) {
		
		AvisAnnonce daoAvisAnnonce = facadeDaoAvis.findAvisAnnonce(avisAnnonce);
		FactoryAvis factoryAvis = new FactoryAvis();
		
		return (AvisAnnonce) factoryAvis.getAvisWithoutPersistentBag(daoAvisAnnonce);
		
	}

	/**
	 * Service de modification d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean modifierAvisAnnonce(AvisAnnonce avisAnnonce) {

		return facadeDaoAvis.updateAvisAnnonce(avisAnnonce);
		
	}
	
	/**
	 * Service de recherche d'un {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public AvisAnnonce rechercheAvisAnnonceById(Utilisateur utilisateur, Item item) {
		
		AvisAnnonce daoAvisAnnonce = facadeDaoAvis.findAvisAnnonceById(utilisateur, item);
		FactoryAvis factoryAvis = new FactoryAvis();
		
		return (AvisAnnonce) factoryAvis.getAvisWithoutPersistentBag(daoAvisAnnonce);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean supprimerAvisAnnonceById(Utilisateur utilisateur, Item item) {
		
		return facadeDaoAvis.deleteAvisAnnonceById(utilisateur, item);
		
	}
	

}
