package rtw.service.gererAvis.facade;

import java.util.ArrayList;

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
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.factory.FactoryAvis;
import rtw.service.gererAvis.factory.FactoryAvisGlobal;
import rtw.service.gererAvis.serviceAvis.serviceAvisAgence.ServiceAvisAgence;
import rtw.service.gererAvis.serviceAvis.serviceAvisAnnonce.ServiceAvisAnnonce;
import rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAgence.ServiceAvisGlobalAgence;
import rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAnnonce.ServiceAvisGlobalAnnonce;
import rtw.technique.gererAvis.ListeAvisAgence;
import rtw.technique.gererAvis.ListeAvisAnnonce;

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

    /*
     * TODO creation d'une facade optimal
     * service(DtoAvis?,action,typeService)
     * 
     */
    
    /**
	 * Service de persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
     * @return true if insert OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean creerAvisAnnonce(AvisAnnonce avisAnnonce) {

		return serviceAvisAnnonce.creerAvisAnnonce(avisAnnonce);
		
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

		return serviceAvisAgence.creerAvisAgence(avisAgence);
		
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

		return serviceAvisGlobalAnnonce.creerAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Service de persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if insert OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return serviceAvisGlobalAgence.creerAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean supprimerAvisAnnonce(AvisAnnonce avisAnnonce) {

		return serviceAvisAnnonce.supprimerAvisAnnonce(avisAnnonce);
		
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

		return serviceAvisAgence.supprimerAvisAgence(avisAgence);
		
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

		return serviceAvisGlobalAnnonce.supprimerAvisGlobalAnnonce(avisGlobalAnnonce);
		
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

		return serviceAvisGlobalAgence.supprimerAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public AvisAnnonce rechercheAvisAnnonce(AvisAnnonce avisAnnonce) {

		return serviceAvisAnnonce.rechercheAvisAnnonce(avisAnnonce);
		
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

		return serviceAvisAgence.rechercheAvisAgence(avisAgence);
		
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

		return serviceAvisGlobalAnnonce.rechercheAvisGlobalAnnonce(avisGlobalAnnonce);
		
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
		
		return serviceAvisGlobalAgence.rechercheAvisGlobalAgence(avisGlobalAgence);
		
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

		return serviceAvisAnnonce.modifierAvisAnnonce(avisAnnonce);
		
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

		return serviceAvisAgence.modifierAvisAgence(avisAgence);
		
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

		return serviceAvisGlobalAnnonce.modifierAvisGlobalAnnonce(avisGlobalAnnonce);
		
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
		
		return serviceAvisGlobalAgence.modifierAvisGlobalAgence(avisGlobalAgence);
		
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
		
		return serviceAvisAnnonce.rechercheAvisAnnonceById(utilisateur,item);
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
		
		return serviceAvisAgence.rechercheAvisAgenceById(utilisateur,item);
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
	public AvisGlobalAnnonce rechercheAvisGlobalAnnonceById(Item item) {
		
		return serviceAvisGlobalAnnonce.rechercheAvisGlobalAnnonceById(item);
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
	public AvisGlobalAgence rechercheAvisGlobalAgenceById(Item item) {
		
		return serviceAvisGlobalAgence.rechercheAvisGlobalAgenceById(item);
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
		
		return serviceAvisAnnonce.supprimerAvisAnnonceById(utilisateur, item);
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
		
		return serviceAvisAgence.supprimerAvisAgenceById(utilisateur, item);
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
	public boolean supprimerAvisGlobalAnnonceById(Item item) {
		
		return serviceAvisGlobalAnnonce.supprimerAvisGlobalAnnonceById(item);
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
	public boolean supprimerAvisGlobalAgenceById(Item item) {
		
		return serviceAvisGlobalAgence.supprimerAvisGlobalAgenceById(item);
	}
	
	/**
	 * Service d'instanciation d'un {@link AvisAnnonce} utilise la class {@link FactoryAvis}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisAnnonce}
	 */
	@Override
	public AvisAnnonce getAvisAnnonce(Utilisateur utilisateur,Item item) {
		
		return serviceAvisAnnonce.getAvisAnnonce(utilisateur,item);
	}

	/**
	 * Service d'instanciation d'un {@link AvisAgence} utilise la class {@link FactoryAvis}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisAgence}
	 */
	@Override
	public AvisAgence getAvisAgence(Utilisateur utilisateur,Item item) {
		
		return serviceAvisAgence.getAvisAgence(utilisateur,item);
	}

	/**
	 * Service d'instanciation d'un {@link AvisGlobalAgence} utilise la class {@link FactoryAvisGlobal}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisGlobalAgence}
	 */
	@Override
	public AvisGlobalAgence getAvisGlobalAgence(Item item) {
		
		return serviceAvisGlobalAgence.getAvisGlobalAgence(item);	
	
	}

	/**
	 * Service d'instanciation d'un {@link AvisGlobalAnnonce} utilise la class {@link FactoryAvisGlobal}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisGlobalAnnonce}
	 */
	@Override
	public AvisGlobalAnnonce getAvisGlobalAnnonce(Item item) {
		
		return serviceAvisGlobalAnnonce.getAvisGlobalAnnonce(item);
	}

	/**
	 * Service de recherche d'une {@link ArrayList} d' {@link AvisAnnonce} lié a un {@link Item}
	 * 
	 * @param item {@link Item}
	 * @return listeAvisAnnonce {@link ArrayList} {@link AvisAnnonce}
	 */
	@Override
	public ListeAvisAnnonce rechercheListeAvisAnnonce(Item item) {
		
		return serviceAvisAnnonce.rechercheListeAvisAnnonce(item);
	}

	/**
	 * Service de recherche d'une {@link ArrayList} d' {@link AvisAgence} lié a un {@link Item}
	 * 
	 * @param item {@link Item}
	 * @return listeAvisAgence {@link ArrayList} {@link AvisAgence}
	 */
	@Override
	public ListeAvisAgence rechercheListeAvisAgence(Item item) {
		
		return serviceAvisAgence.rechercheListeAvisAgence(item);
	}

}
