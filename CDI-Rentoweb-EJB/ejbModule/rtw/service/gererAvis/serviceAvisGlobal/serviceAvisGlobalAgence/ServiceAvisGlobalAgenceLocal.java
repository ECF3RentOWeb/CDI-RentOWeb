package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAgence;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;

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
	 * @see DaoAvisGlobalAgence
	 */
	public void creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void supprimerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void rechercheAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Service de modification d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void modifierAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
}
