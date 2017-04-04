package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAnnonce;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.dao.gererAvis.facade.FacadeDaoAvis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.factory.FactoryAvisGlobal;

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
     * @return true if insert OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean creerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {
		
		return facadeDaoAvis.addAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean supprimerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		return facadeDaoAvis.deleteAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public AvisGlobalAnnonce rechercheAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {
		
		AvisGlobalAnnonce daoAvisGlobalAnnonce = facadeDaoAvis.findAvisGlobalAnnonce(avisGlobalAnnonce);
		FactoryAvisGlobal factoryAvisGlobal = new FactoryAvisGlobal();
		
		return (AvisGlobalAnnonce) factoryAvisGlobal.getAvisGlobalWithoutPersistentBag(daoAvisGlobalAnnonce);
		
	}
	
	/**
	 * Service de modification d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean modifierAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		return facadeDaoAvis.updateAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public AvisGlobalAnnonce rechercheAvisGlobalAnnonceById(Utilisateur utilisateur, Item item) {

		AvisGlobalAnnonce daoAvisGlobalAnnonce = facadeDaoAvis.findAvisGlobalAnnonceById(utilisateur, item);
		FactoryAvisGlobal factoryAvisGlobal = new FactoryAvisGlobal();
		
		return (AvisGlobalAnnonce) factoryAvisGlobal.getAvisGlobalWithoutPersistentBag(daoAvisGlobalAnnonce);
	}

	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean supprimerAvisGlobalAnnonceById(Utilisateur utilisateur, Item item) {
		// TODO Auto-generated method stub
		return facadeDaoAvis.deleteAvisAnnonceById(utilisateur, item);
	}

	/**
	 * Service d'instanciation d'un {@link AvisGlobalAnnonce} utilise la class {@link FactoryAvisGlobal}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * @return {@link AvisGlobalAnnonce}
	 */
	@Override
	public AvisGlobalAnnonce getAvisGlobalAnnonce(Utilisateur utilisateur,Item item) {
		
		FactoryAvisGlobal factoryAvisGlobal = new FactoryAvisGlobal();
		return factoryAvisGlobal.getAvisGlobalAnnonce(utilisateur,item);
		
	}

}
