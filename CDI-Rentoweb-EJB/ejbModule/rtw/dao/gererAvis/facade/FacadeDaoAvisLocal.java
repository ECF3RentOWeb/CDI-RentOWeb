package rtw.dao.gererAvis.facade;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;

/**
 * Interface de la facade de la DAO de la fonctionnalité gérer avis.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface FacadeDaoAvisLocal {

	/**
	 * Persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void addAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void addAvisAnnonce(AvisAnnonce avisAnnonce);
		
	/**
	 * Persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Delete {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void deleteAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Delete {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void deleteAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Delete {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Delete {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Find {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void findAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Find {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void findAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Find {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Find {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Update {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void updateAvisAgence(AvisAgence avisAgence);

	/**
	 * Update {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void updateAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Update {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Update {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	
}
