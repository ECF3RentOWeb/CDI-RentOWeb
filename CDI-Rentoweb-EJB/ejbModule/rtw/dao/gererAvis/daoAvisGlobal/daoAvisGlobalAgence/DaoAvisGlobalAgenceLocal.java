package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence;

import javax.ejb.Local;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;

/**
 * Interface de la facade de la DAO {@link AvisGlobalAgence}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface DaoAvisGlobalAgenceLocal {
	
	/**
	 * Persistance d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if insert OK.
	 */
	public boolean addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Suppression d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 */
	public boolean deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Recherche d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 */
	public AvisGlobalAgence findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Update d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if update OK.
	 */
	public boolean updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Suppression d'un {@link AvisGlobalAgence} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 */
	public boolean deleteAvisGlobalAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Recherche d'un {@link AvisGlobalAgence} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return AvisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 */
	public AvisGlobalAgence findAvisGlobalAgenceById(Utilisateur utilisateur, Item item);
	
}
