package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAgence;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;

/**
 * Interface de la facade de service pour les {@link AvisGlobalAgence}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface ServiceAvisGlobalAgenceLocal {

	/**
	 * Service de persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if persit OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean supprimerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence} null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	public AvisGlobalAgence rechercheAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Service de modification d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean modifierAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	AvisGlobalAgence rechercheAvisGlobalAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisGlobalAgence
	 */
	boolean supprimerAvisGlobalAgenceById(Utilisateur utilisateur, Item item);
	
}
