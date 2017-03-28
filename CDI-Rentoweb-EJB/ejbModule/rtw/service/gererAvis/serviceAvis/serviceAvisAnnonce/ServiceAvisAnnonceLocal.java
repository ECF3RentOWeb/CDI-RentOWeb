package rtw.service.gererAvis.serviceAvis.serviceAvisAnnonce;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;

/**
 * Interface de la facade de service pour les {@link AvisAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface ServiceAvisAnnonceLocal {

	/**
	 * Service de persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void creerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void supprimerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void rechercheAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Service de modification d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void modifierAvisAnnonce(AvisAnnonce avisAnnonce);
	
}
