package rtw.dao.gererAvis.daoAvis.daoAvisAgence;

import javax.ejb.Local;

import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;

/**
 * Interface de la facade de la DAO {@link AvisAgence}.
 * 
 * @author Aurélien
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
	 */
	public void addAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Suppression d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 */
	public void deleteAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Recherche d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return 
	 */
	public AvisAgence findAvisAgence(AvisAgence avisAgence);

	/**
	 * Update d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 */
	void updateAvisAgence(AvisAgence avisAgence);
	
}
