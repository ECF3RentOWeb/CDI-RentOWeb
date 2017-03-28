package rtw.clientServer.gererAvis;

import javax.ejb.Remote;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.dao.gererAvis.daoAvis.daoAvisAnnonce.DaoAvisAnnonce;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence.DaoAvisGlobalAgence;
import rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce.DaoAvisGlobalAnnonce;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;

/**
 * Interface de la facade service de la fonctionnalité gérer avis.
 * 
 * @author Aurélien
 * @version 1
 * @since 28/03/2017
 *
 */
@Remote
public interface FacadeServiceAvisRemote {
	
	/**
	 * Service de persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAgence {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void creerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void creerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAgence {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void creerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void creerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Service de suppression d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void supprimerAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void supprimerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void supprimerAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de suppression d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void supprimerAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Service de recherche d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void rechercheAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void rechercheAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void rechercheAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Service de recherche d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void rechercheAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	
	/**
	 * Service de modification d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @see DaoAvisAnnonce
	 */
	public void modifierAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Service de modification d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @see DaoAvisAgence
	 */
	public void modifierAvisAgence(AvisAgence avisAgence);

	/**
	 * Service de modification d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAnnonce}
	 * @see DaoAvisGlobalAnnonce
	 */
	public void modifierAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Service de modification d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisAnnonce {@link AvisGlobalAgence}
	 * @see DaoAvisGlobalAgence
	 */
	public void modifierAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
}
