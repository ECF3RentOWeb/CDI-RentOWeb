package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAnnonce;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;



/**
 * Classe qui gère toute la DAO des {@link AvisGlobalAnnonce}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisGlobalAnnonce implements DaoAvisGlobalAnnonceLocal {
	
	//TODO persistence Name
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisGlobalAnnonce() {
		
	}

	/**
	 * Persistance d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if insert OK.
	 */
	@Override
	public boolean addAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		boolean retour = true;
		
		try {
			
			em.persist(avisGlobalAnnonce);
			
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le persit :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Suppression d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		boolean retour = true;

		avisGlobalAnnonce = findAvisGlobalAnnonce(avisGlobalAnnonce);
		
		try {
			
			em.remove(avisGlobalAnnonce);
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete  :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Recherche d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db
	 */
	@Override
	public AvisGlobalAnnonce findAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		AvisGlobalAnnonce avisGlobalAnnonceRetour;
		
		try {
			
			avisGlobalAnnonceRetour = em.find(AvisGlobalAnnonce.class, avisGlobalAnnonce.getId());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find  :3");
			avisGlobalAnnonceRetour = null;
		}
		
		return avisGlobalAnnonceRetour;
		
	}
	
	/**
	 * Recherche un {@link AvisGlobalAnnonce} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAnnonce {@link AvisGlobalAnnonce} Null if not exist in db.
	 * 
	 */
	@Override
	public AvisGlobalAnnonce findAvisGlobalAnnonceById(Utilisateur utilisateur,Item item) {

		AvisGlobalAnnonce avisGlobalAnnonce;
		
		try {
			
			avisGlobalAnnonce = (AvisGlobalAnnonce) em.createQuery("select a from DtoAvis a where idUtilisateur = ?1 and idItem = ?2")
				.setParameter(1, utilisateur.getIdUtilisateur())
				.setParameter(2,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find by id :3");
			avisGlobalAnnonce = null;
		}
		
		return avisGlobalAnnonce;

	}
	
	/**
	 * Suppression d'un {@link AvisGlobalAnnonce} par son ID.
	 * 
	 * @param avisGlobalAnnonce {@link AvisGlobalAnnonce}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAnnonceById(Utilisateur utilisateur,Item item) {

		boolean retour = true;
		
		try {
			
			em.createQuery("delete from AvisGlobalAnnonce where idUtilisateur = ?1 and idItem = ?2")
			.setParameter(1, utilisateur.getIdUtilisateur())
			.setParameter(2,item.getIdItem()).executeUpdate();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete by id :3");
			retour = false;
			
		}
		
		return retour;
		
	}
	
	/**
	 * Update d'un {@link AvisGlobalAnnonce}
	 * 
	 * @param avisGlobalAnnonce{@link AvisGlobalAnnonce}
	 * @return true if update OK.
	 */
	@Override
	public boolean updateAvisGlobalAnnonce(AvisGlobalAnnonce avisGlobalAnnonce) {

		boolean retour = true;
		try {
			
			em.merge(avisGlobalAnnonce);
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le update  :3");
			retour = false;
		}
		
		return retour;
		
	}

	
}
