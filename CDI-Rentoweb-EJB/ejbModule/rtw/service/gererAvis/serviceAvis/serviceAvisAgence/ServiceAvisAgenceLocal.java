package rtw.service.gererAvis.serviceAvis.serviceAvisAgence;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;


/**
 * Interface de la facade de service pour les {@link AvisAgence}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface ServiceAvisAgenceLocal {

	/**
	 * Service de persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void creerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de suppression d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void supprimerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de recherche d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void rechercheAvisAgence(AvisAgence avisAgence);

	/**
	 * Service de modification d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void modifierAvisAgence(AvisAgence avisAgence);

	
}
