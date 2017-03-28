package rtw.service.gererAvis.serviceAvisGlobal.serviceAvisGlobalAnnonce;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;

/**
 * Interface de la facade de service pour les {@link AvisGlobalAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Local
public interface ServiceAvisGlobalAnnonceLocal {

	/**
	 * Service de persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void creerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void supprimerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void rechercheAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Service de modification d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void modifierAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
}
