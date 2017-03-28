package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce;

import javax.ejb.Local;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;

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
	 */
	public void addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Suppression d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 */
	public void deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
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
	 */
	void updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
}
