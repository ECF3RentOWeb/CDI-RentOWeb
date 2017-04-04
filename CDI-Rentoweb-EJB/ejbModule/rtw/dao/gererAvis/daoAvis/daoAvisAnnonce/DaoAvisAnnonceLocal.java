package rtw.dao.gererAvis.daoAvis.daoAvisAnnonce;

import javax.ejb.Local;

import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;

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
	 * @return true if insert OK.
	 * @throws DoublonAvisException 
	 */
	public boolean addAvisAnnonce(AvisAnnonce avisAnnonce) throws DoublonAvisException;
	
	/**
	 * Suppression d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if delete OK.
	 */
	public boolean deleteAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Recherche d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db
	 */
	public AvisAnnonce findAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * update d'un {@link AvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if update OK.
	 */
	boolean updateAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Recherche d'un {@link AvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db
	 */
	AvisAnnonce findAvisAnnonceById(Utilisateur utilisateur, Item item);

	/**
	 * Suppression d'un {@link AvisAnnonce} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 */
	boolean deleteAvisAnnonceById(Utilisateur utilisateur, Item item);

}
