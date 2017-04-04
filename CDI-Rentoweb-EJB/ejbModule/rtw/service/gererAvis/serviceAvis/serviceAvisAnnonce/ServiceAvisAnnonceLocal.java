package rtw.service.gererAvis.serviceAvis.serviceAvisAnnonce;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.factory.FactoryAvis;

/**
 * Interface de la facade de service pour les {@link AvisAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface ServiceAvisAnnonceLocal {

	/**
	 * Service de persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if persit OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean creerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean supprimerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	public AvisAnnonce rechercheAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Service de modification d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if persit OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean modifierAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Service de recherche d'un {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	AvisAnnonce rechercheAvisAnnonceById(Utilisateur utilisateur, Item item);

	/**
	 * Service de suppression d'un {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	boolean supprimerAvisAnnonceById(Utilisateur utilisateur, Item item);

	/**
	 * Service d'instanciation d'un {@link AvisAnnonce} utilise la class {@link FactoryAvis}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisAnnonce}
	 */
	AvisAnnonce getAvisAnnonce(Utilisateur utilisateur, Item item);

	
	
}
