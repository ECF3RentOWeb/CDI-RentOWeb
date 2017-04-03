package rtw.dao.gererAvis.daoAvis.daoAvisAgence;

import javax.ejb.Local;

import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;

/**
 * Interface de la facade de la DAO {@link AvisAgence}.
 * 
 * @author Aur�lien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface DaoAvisAgenceLocal {
	
	/**
	 * Persistance d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if persit OK.
	 */
	public boolean addAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Suppression d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 */
	public boolean deleteAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Recherche d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return avisAgence {@link AvisAgence} Null if not exist in db
	 */
	public AvisAgence findAvisAgence(AvisAgence avisAgence);

	/**
	 * Update d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK
	 */
	boolean updateAvisAgence(AvisAgence avisAgence);

	/**
	 * Recherche d'un {@link AvisAgence} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db
	 */
	AvisAgence findAvisAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Suppression d'un {@link AvisAgence} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 */
	boolean deleteAvisAgenceById(Utilisateur utilisateur, Item item);

	
	
}