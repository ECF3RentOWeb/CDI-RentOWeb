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
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.exception.gererAvis.DoublonAvisException;

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
	 * @return true if insert OK.
	 * @see DaoAvisAgence
	 */
	public boolean addAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if insert OK.
	 * @throws DoublonAvisException 
	 * @see DaoAvisAnnonce
	 */
	public boolean addAvisAnnonce(AvisAnnonce avisAnnonce) throws DoublonAvisException;
		
	/**
	 * Persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if insert OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if insert OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Delete {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if insert OK.
	 * @see DaoAvisAgence
	 */
	public boolean deleteAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Delete {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if delete OK. 
	 * @see DaoAvisAnnonce
	 */
	public boolean deleteAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Delete {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK. 
	 * @see DaoAvisGlobalAgence
	 */
	public boolean deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Delete {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK. 
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);
	
	/**
	 * Find {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK. 
	 * @see DaoAvisAgence
	 */
	public AvisAgence findAvisAgence(AvisAgence avisAgence);
	
	/**
	 * Find {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	public AvisAnnonce findAvisAnnonce(AvisAnnonce avisAnnonce);
	
	/**
	 * Find {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	public AvisGlobalAgence findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);
	
	/**
	 * Find {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	public AvisGlobalAnnonce findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Update {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 * @see DaoAvisAgence
	 */
	public boolean updateAvisAgence(AvisAgence avisAgence);

	/**
	 * Update {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisAnnonce
	 */
	public boolean updateAvisAnnonce(AvisAnnonce avisAnnonce);

	/**
	 * Update {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAgence
	 */
	public boolean updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence);

	/**
	 * Update {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	public boolean updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce);

	/**
	 * Delete {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK. 
	 * @see DaoAvisGlobalAnnonce
	 */
	boolean deleteAvisGlobalAnnonceById(Utilisateur utilisateur, Item item);

	/**
	 * Delete {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK. 
	 * @see DaoAvisGlobalAgence
	 */
	boolean deleteAvisGlobalAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Delete {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	boolean deleteAvisAnnonceById(Utilisateur utilisateur, Item item);

	/**
	 * Delete {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK. 
	 * @see DaoAvisAgence
	 */
	boolean deleteAvisAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Find {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	AvisAgence findAvisAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Find {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	AvisAnnonce findAvisAnnonceById(Utilisateur utilisateur, Item item);

	/**
	 * Find {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	AvisGlobalAgence findAvisGlobalAgenceById(Utilisateur utilisateur, Item item);

	/**
	 * Find {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	AvisGlobalAnnonce findAvisGlobalAnnonceById(Utilisateur utilisateur, Item item);
	
	
}
