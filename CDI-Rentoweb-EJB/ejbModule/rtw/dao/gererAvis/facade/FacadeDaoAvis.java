package rtw.dao.gererAvis.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
 * Session bean facade de la DAO de la fonctionnalité gérer avis.
 * 
 * @author Aurélien
 * @version 1
 * @since 27/03/2017
 *
 */
@Stateless
@LocalBean
public class FacadeDaoAvis implements FacadeDaoAvisLocal {

	@EJB
	DaoAvisAgence daoAvisAgence;
	@EJB
	DaoAvisAnnonce daoAvisAnnonce;
	@EJB
	DaoAvisGlobalAgence daoAvisGlobalAgence;
	@EJB
	DaoAvisGlobalAnnonce daoAvisGlobalAnnonce;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoAvis() {
        
    }

    /*
     * TODO creation d'une facade optimal
     * dao(DtoAvis?,action)
     * 
     */
    
    
    /**
	 * Persistence d'un {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
     * @return true if insert OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean addAvisAgence(AvisAgence avisAgence) {

		return daoAvisAgence.addAvisAgence(avisAgence);
		
	}

	/**
	 * Persistence d'un {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if insert OK.
	 * @throws DoublonAvisException 
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean addAvisAnnonce(AvisAnnonce avisAnnonce) throws DoublonAvisException {

		return daoAvisAnnonce.addAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Persistence d'un {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if insert OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		return daoAvisGlobalAnnonce.addAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}

	/**
	 * Persistence d'un {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if insert OK.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return daoAvisGlobalAgence.addAvisGlobalAgence(avisGlobalAgence);
		
	}
	

	/**
	 * Delete {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean deleteAvisAgence(AvisAgence avisAgence) {

		return daoAvisAgence.deleteAvisAgence(avisAgence);
		
	}

	/**
	 * Delete {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean deleteAvisAnnonce(AvisAnnonce avisAnnonce) {
			
		return daoAvisAnnonce.deleteAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Delete {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return daoAvisGlobalAgence.deleteAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Delete {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {
			
		return daoAvisGlobalAnnonce.deleteAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}
	
	/**
	 * Delete {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean deleteAvisAgenceById(Utilisateur utilisateur,Item item) {

		return daoAvisAgence.deleteAvisAgenceById(utilisateur,item);
		
	}

	/**
	 * Delete {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean deleteAvisAnnonceById(Utilisateur utilisateur,Item item) {
			
		return daoAvisAnnonce.deleteAvisAnnonceById(utilisateur,item);
		
	}

	/**
	 * Delete {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean deleteAvisGlobalAgenceById(Utilisateur utilisateur,Item item) {

		return daoAvisGlobalAgence.deleteAvisGlobalAgenceById(utilisateur,item);
		
	}

	/**
	 * Delete {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return true if delete OK
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean deleteAvisGlobalAnnonceById(Utilisateur utilisateur,Item item) {
			
		return daoAvisGlobalAnnonce.deleteAvisGlobalAnnonceById(utilisateur,item);
		
	}

	/**
	 * Find {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	@Override
	public AvisAgence findAvisAgence(AvisAgence avisAgence) {
		
		return daoAvisAgence.findAvisAgence(avisAgence);

	}

	/**
	 * Find {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public AvisAnnonce findAvisAnnonce(AvisAnnonce avisAnnonce) {

		return daoAvisAnnonce.findAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Find {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public AvisGlobalAgence findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return daoAvisGlobalAgence.findAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Find {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public AvisGlobalAnnonce findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		return daoAvisGlobalAnnonce.findAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}
	

	/**
	 * Find {@link AvisAgence} par son ID grace a la class {@link DaoAvisAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * @see DaoAvisAgence
	 */
	@Override
	public AvisAgence findAvisAgenceById(Utilisateur utilisateur,Item item) {
		
		return daoAvisAgence.findAvisAgenceById(utilisateur,item);

	}

	/**
	 * Find {@link AvisAnnonce} par son ID grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAnnonce {@link AvisAnnonce} Null if not exist in db.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public AvisAnnonce findAvisAnnonceById(Utilisateur utilisateur,Item item) {

		return daoAvisAnnonce.findAvisAnnonceById(utilisateur,item);
		
	}

	/**
	 * Find {@link AvisGlobalAgence} par son ID grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public AvisGlobalAgence findAvisGlobalAgenceById(Utilisateur utilisateur,Item item) {

		return daoAvisGlobalAgence.findAvisGlobalAgenceById(utilisateur,item);
		
	}

	/**
	 * Find {@link AvisGlobalAnnonce} par son ID grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public AvisGlobalAnnonce findAvisGlobalAnnonceById(Utilisateur utilisateur,Item item) {

		return daoAvisGlobalAnnonce.findAvisGlobalAnnonceById(utilisateur,item);
		
	}
    
	/**
	 * Update {@link AvisAgence} grace a la class {@link DaoAvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 * @see DaoAvisAgence
	 */
	@Override
	public boolean updateAvisAgence(AvisAgence avisAgence) {
		
		return daoAvisAgence.updateAvisAgence(avisAgence);

	}

	/**
	 * Update {@link AvisAnnonce} grace a la class {@link DaoAvisAnnonce}
	 * 
	 * @param avisAnnonce {@link AvisAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisAnnonce
	 */
	@Override
	public boolean updateAvisAnnonce(AvisAnnonce avisAnnonce) {

		return daoAvisAnnonce.updateAvisAnnonce(avisAnnonce);
		
	}

	/**
	 * Update {@link AvisGlobalAgence} grace a la class {@link DaoAvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAgence
	 */
	@Override
	public boolean updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		return daoAvisGlobalAgence.updateAvisGlobalAgence(avisGlobalAgence);
		
	}

	/**
	 * Update {@link AvisGlobalAnnonce} grace a la class {@link DaoAvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 * @see DaoAvisGlobalAnnonce
	 */
	@Override
	public boolean updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		return daoAvisGlobalAnnonce.updateAvisGlobalAnnonce(avisGlobalAnnonce);
		
	}
    

}
