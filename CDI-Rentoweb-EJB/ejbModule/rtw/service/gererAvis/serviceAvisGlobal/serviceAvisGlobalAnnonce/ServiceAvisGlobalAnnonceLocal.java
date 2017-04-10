package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAnnonce;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.service.gererAvis.factory.FactoryAvisGlobal;

/**
 * Interface de la facade de service pour les {@link AvisGlobalAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface ServiceAvisGlobalAnnonceLocal {

	/**
	 * Service de persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if insert OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean creerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean supprimerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist.
	 * @see DaoAvisGlobalAnnonce
	 */
	public AvisGlobalAnnonce rechercheAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Service de modification d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean modifierAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	AvisGlobalAnnonce rechercheAvisGlobalAnnonceById(Item item);

	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	boolean supprimerAvisGlobalAnnonceById(Item item);

	/**
	 * Service d'instanciation d'un {@link AvisGlobalAnnonce} utilise la class {@link FactoryAvisGlobal}
	 * 
	 * @param item {@link Item}
	 * @return {@link AvisGlobalAnnonce}
	 */
	AvisGlobalAnnonce getAvisGlobalAnnonce(Item item);

	
	
}
