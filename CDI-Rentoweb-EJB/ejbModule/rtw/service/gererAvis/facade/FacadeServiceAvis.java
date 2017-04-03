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
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.serviceAvis.serviceAvisAgence.ServiceAvisAgence;
import rtw.service.gererAvis.serviceAvis.serviceAvisAnnonce.ServiceAvisAnnonce;
import rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAgence.ServiceAvisGlobalAgence;
import rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAnnonce.ServiceAvisGlobalAnnonce;

/**
 * Facade des service de la fonctionnalit� g�rer {@link Avis}.
 * 
 * @author Aur�lien
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
	public AvisGlobalAnnonce rechercheAvisGlobalAnnonceById(Utilisateur utilisateur, Item item) {
		
		return serviceAvisGlobalAnnonce.rechercheAvisGlobalAnnonceById(utilisateur,item);
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
		
		return serviceAvisGlobalAgence.rechercheAvisGlobalAgenceById(utilisateur,item);
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
	public boolean supprimerAvisGlobalAnnonceById(Utilisateur utilisateur, Item item) {
		
		return serviceAvisGlobalAnnonce.supprimerAvisGlobalAnnonceById(utilisateur,item);
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
		
		return serviceAvisGlobalAgence.supprimerAvisGlobalAgenceById(utilisateur,item);
	}
	
	//TODO Service Factory

}