package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce;

import javax.ejb.Local;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;

/**
 * Interface de la facade de la DAO {@link AvisGlobalAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface DaoAvisGlobalAnnonceLocal {
	
	/**
	 * Persistance d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if insert OK.
	 */
	public boolean addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Suppression d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 */
	public boolean deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Recherche d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 */
	public AvisGlobalAnnonce findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Update d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 */
	boolean updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Recherche d'un {@link AvisGlobalAnnonce} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 */
	boolean deleteAvisGlobalAnnonceById(Utilisateur utilisateur, Item item);

	/**
	 * Recherche d'un {@link AvisGlobalAnnonce} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} null if no exist in db.
	 */
	AvisGlobalAnnonce findAvisGlobalAnnonceById(Utilisateur utilisateur, Item item);
	
}
