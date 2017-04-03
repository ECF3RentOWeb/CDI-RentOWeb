package rtw.dao.gererAvis.daoAvisGlobal.daoAvisGlobalAgence;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;

/**
 * Classe qui gère toute la DAO des {@link AvisGlobalAgence}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisGlobalAgence implements DaoAvisGlobalAgenceLocal {
	
	//TODO persistence Name
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisGlobalAgence() {
		
	}

	/**
	 * Persistance d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if insert OK.
	 */
	@Override
	public boolean addAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

	boolean retour = true;
		
		try {
			
			em.persist(avisGlobalAgence);
			
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le persit :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Suppression d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		boolean retour = true;

		avisGlobalAgence = findAvisGlobalAgence(avisGlobalAgence);
		
		try {
			
			em.remove(avisGlobalAgence);
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete  :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Recherche d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 */
	@Override
	public AvisGlobalAgence findAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		AvisGlobalAgence avisGlobalAgenceRetour;

		try {
			
			avisGlobalAgenceRetour = em.find(AvisGlobalAgence.class, avisGlobalAgence.getId());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find  :3");
			avisGlobalAgenceRetour = null;
		}

		return avisGlobalAgenceRetour;	
				
	}
	
	/**
	 * Recherche un {@link AvisGlobalAgence} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisGlobalAgence {@link AvisGlobalAgence} Null if not exist in db.
	 * 
	 */
	@Override
	public AvisGlobalAgence findAvisGlobalAgenceById(Utilisateur utilisateur,Item item) {

		AvisGlobalAgence avisGlobalAgence;
		
		try {
			
			avisGlobalAgence = (AvisGlobalAgence) em.createQuery("select a from DtoAvis a where idUtilisateur = ?1 and idItem = ?2")
				.setParameter(1, utilisateur.getIdUtilisateur())
				.setParameter(2,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find by id :3");
			avisGlobalAgence = null;
		}

		return avisGlobalAgence;	

	}
	
	/**
	 * Suppression d'un {@link AvisGlobalAgence} par son ID.
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisGlobalAgenceById(Utilisateur utilisateur,Item item) {

		boolean retour = true;
		
		try {
			
			em.createQuery("delete from AvisGlobalAgence where idUtilisateur = ?1 and idItem = ?2")
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
	 * Update d'un {@link AvisGlobalAgence}
	 * 
	 * @param avisGlobalAgence {@link AvisGlobalAgence}
	 * @return true if update OK.
	 */
	@Override
	public boolean updateAvisGlobalAgence(AvisGlobalAgence avisGlobalAgence) {

		boolean retour = true;
		try {
			
			em.merge(avisGlobalAgence);
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le update  :3");
			retour = false;
		}
		
		return retour;
		
	}

	
}
