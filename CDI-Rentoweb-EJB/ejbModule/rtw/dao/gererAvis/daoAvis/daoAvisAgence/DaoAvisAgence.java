package rtw.dao.gererAvis.daoAvis.daoAvisAgence;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;

/**
 * Classe qui gère toute la DAO des {@link AvisAgence}.
 * 
 * @author Aurélien
 * @Version 1
 * @since 13/03/2017
 *
 */
@LocalBean
@Singleton
public class DaoAvisAgence implements DaoAvisAgenceLocal {

	//TODO persistence Name
	@PersistenceContext(unitName="rentoweb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public DaoAvisAgence() {
		
	}
	
	
	/**
	 * Persistance d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if insert OK.
	 */
	public boolean addAvisAgence(AvisAgence avisAgence){

		boolean retour = true;
		
		try {
			
			em.persist(avisAgence);
			
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le persit :3");
			retour = false;
			
		}
		
		return retour;
		
	}


	/**
	 * Suppression d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisAgence(AvisAgence avisAgence) {

		boolean retour = true;

		avisAgence = findAvisAgence(avisAgence);
		
		try {
			
			em.remove(avisAgence);
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le delete  :3");
			retour = false;
			
		}
		
		return retour;
		
	}

	/**
	 * Recherche d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * 
	 */ 
	@Override
	public AvisAgence findAvisAgence(AvisAgence avisAgence) {

		AvisAgence avisAgenceRetour;
		
		try {
			
			avisAgenceRetour = em.find(AvisAgence.class, avisAgence.getId());
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find :3");
			avisAgenceRetour = null;
		}
				
		return avisAgenceRetour;
		
	}
	
	/**
	 * Recherche un {@link AvisAgence} par son ID.
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 * 
	 * @return avisAgence {@link AvisAgence} Null if not exist in db.
	 * 
	 */
	@Override
	public AvisAgence findAvisAgenceById(Utilisateur utilisateur,Item item) {
		
		AvisAgence avisAgence;
		
		try {
			
			avisAgence = (AvisAgence) em.createQuery("select a from DtoAvis a where idUtilisateur = ?1 and idItem = ?2")
				.setParameter(1, utilisateur.getIdUtilisateur())
				.setParameter(2,item.getIdItem()).getSingleResult();
			
		} catch (Exception e) {
			
			//TODO test int
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le find by id :3");
			avisAgence = null;
		}
		
		return avisAgence;

	}
	
	/**
	 * Suppression d'un {@link AvisAgence} par son ID.
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if delete OK.
	 */
	@Override
	public boolean deleteAvisAgenceById(Utilisateur utilisateur,Item item) {

		boolean retour = true;
		
		try {
			
			em.createQuery("delete from AvisAgence where idUtilisateur = ?1 and idItem = ?2")
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
	 * Update d'un {@link AvisAgence}
	 * 
	 * @param avisAgence {@link AvisAgence}
	 * @return true if update OK.
	 */
	@Override
	public boolean updateAvisAgence(AvisAgence avisAgence) {

		boolean retour = true;
		try {
			
			em.merge(avisAgence);
			
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
			System.out.println("atcha j'ai tout cassé dans le update  :3");
			retour = false;
		}
		
		return retour;
		
	}
	
	
}
