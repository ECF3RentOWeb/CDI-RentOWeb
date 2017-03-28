package rtw.dao.gererAvis.daoAvis.daoAvisAnnonce;

import javax.ejb.Local;

import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;

/** 
 * Interface de la facade de la DAO {@link AvisAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface DaoAvisAnnonceLocal {

	/**
	 * Persistance d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 */
	public void addAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Suppression d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 */
	public void deleteAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Recherche d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce}
	 */
	public AvisAnnonce findAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * update d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 */
	void updateAvisAnnonce(AvisAnnonce avisAnnonce);

}
