package rtw.clientServer.gererAvis;

import java.util.ArrayList;

import javax.ejb.Remote;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.factory.FactoryAvis;
import rtw.service.gererAvis.factory.FactoryAvisGlobal;
import rtw.technique.gererAvis.ListeAvisAgence;
import rtw.technique.gererAvis.ListeAvisAnnonce;

/**
 * Interface de la facade service de la fonctionnalité gérer avis.
 * 
 * @author Aurélien
 * @version 1
 * @since 28/03/2017
 *
 */
@Remote
public interface FacadeServiceAvisRemote {
	
	/**
	 * Service de persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAgence {@link AvisAnnonce}
	 * @return true if insert OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean creerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if insert OK.
	 * @see DaoAvisAgence
	 */
	public boolean creerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAgence {@link AvisGlobalAnnonce}
	 * @return true if insert OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean creerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if insert OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean supprimerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 * @see DaoAvisAgence
	 */
	public boolean supprimerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean supprimerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean supprimerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	public AvisAnnonce rechercheAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	public AvisAgence rechercheAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAnnonce}
	 * @return avisAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	public AvisGlobalAnnonce rechercheAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAgence}
	 * @return avisAnnonce {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	public AvisGlobalAgence rechercheAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	
	/**
	 * Service de modification d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @return true if update OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean modifierAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Service de modification d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 * @see DaoAvisAgence
	 */
	public boolean modifierAvisAgence(AvisAgence avisAgence);

	/**
	 * Service de modification d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean modifierAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Service de modification d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAgence}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean modifierAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Service de recherche d'un {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	public AvisAnnonce rechercheAvisAnnonceById(Utilisateur utilisateur,Item item);
	
	/**
	 * Service de recherche d'un {@link AvisAgence} par son ID/Utilisateur grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	public AvisAgence rechercheAvisAgenceById(Utilisateur utilisateur,Item item);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} par son ID/Utilisateur grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	public AvisGlobalAnnonce rechercheAvisGlobalAnnonceById(Item item);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	public AvisGlobalAgence rechercheAvisGlobalAgenceById(Item item);
	
	/**
	 * Service de suppression d'un {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean supprimerAvisAnnonceById(Utilisateur utilisateur,Item item);
	
	/**
	 * Service de suppression d'un {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAgence
	 */
	public boolean supprimerAvisAgenceById(Utilisateur utilisateur,Item item);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean supprimerAvisGlobalAnnonceById(Item item);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean supprimerAvisGlobalAgenceById(Item item);
	
	/**
	 * Service d'instanciation d'un {@link AvisAnnonce} utilise la class {@link FactoryAvis}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisAnnonce}
	 */
	public AvisAnnonce getAvisAnnonce(Utilisateur utilisateur,Item item);
	
	/**
	 * Service d'instanciation d'un {@link AvisAgence} utilise la class {@link FactoryAvis}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisAgence}
	 */
	public AvisAgence getAvisAgence(Utilisateur utilisateur, Item item);
	
	/**
	 * Service d'instanciation d'un {@link AvisGlobalAgence} utilise la class {@link FactoryAvisGlobal}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisGlobalAgence}
	 */
	public AvisGlobalAgence getAvisGlobalAgence(Item item);
	
	/**
	 * Service d'instanciation d'un {@link AvisGlobalAnnonce} utilise la class {@link FactoryAvisGlobal}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisGlobalAnnonce}
	 */
	public AvisGlobalAnnonce getAvisGlobalAnnonce(Item item);
	
	/**
	 * Service de recherche d'une {@link ArrayList} d' {@link AvisAnnonce} lié a un {@link Item}
	 * 
	 * @param item {@link Item}
	 * @return listeAvisAnnonce {@link ArrayList} {@link AvisAnnonce}
	 */
	public ListeAvisAnnonce rechercheListeAvisAnnonce(Item item);
	
	/**
	 * Service de recherche d'une {@link ArrayList} d' {@link AvisAgence} lié a un {@link Item}
	 * 
	 * @param item {@link Item}
	 * @return listeAvisAgence {@link ArrayList} {@link AvisAgence}
	 */
	public ListeAvisAgence rechercheListeAvisAgence(Item item);

}
