package rtw.service.gererAvis.serviceAvis.serviceAvisAgence;

import java.util.ArrayList;

import javax.ejb.Local;

import rtw.dao.gererAvis.daoAvis.daoAvisAgence.DaoAvisAgence;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.service.gererAvis.factory.FactoryAvis;
import rtw.technique.gererAvis.ListeAvisAgence;


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
	 * @return true if persit OK.
	 * @see DaoAvisAgence
	 */
	public boolean creerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de suppression d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 * @see DaoAvisAgence
	 */
	public boolean supprimerAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Service de recherche d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	public AvisAgence rechercheAvisAgence(AvisAgence avisAgence);

	/**
	 * Service de modification d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 * @see DaoAvisAgence
	 */
	public boolean modifierAvisAgence(AvisAgence avisAgence);

	/**
	 * Service de recherche d'un {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	public AvisAgence rechercheAvisAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Service de suppression d'un {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAgence
	 */
	public boolean supprimerAvisAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Service d'instanciation d'un {@link AvisAgence} utilise la class {@link FactoryAvis}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @Param item {@link Item}
	 * @return {@link AvisAgence}
	 * 
	 */
	AvisAgence getAvisAgence(Utilisateur utilisateur, Item item);
	
	/**
	 * Service de recherche d'une {@link ArrayList} d' {@link AvisAgence} lié a un {@link Item}
	 * 
	 * @param item {@link Item}
	 * @return listeAvisAgence {@link ArrayList} {@link AvisAgence}
	 */
	public ListeAvisAgence rechercheListeAvisAgence(Item item);
}
