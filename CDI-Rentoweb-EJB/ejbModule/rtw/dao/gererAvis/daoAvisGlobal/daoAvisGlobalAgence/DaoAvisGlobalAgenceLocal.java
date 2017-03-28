package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence;

import javax.ejb.Local;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;

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
	 */
	public void addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Suppression d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 */
	public void deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Recherche d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence}
	 */
	public AvisGlobalAgence findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Update d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 */
	void updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
}
