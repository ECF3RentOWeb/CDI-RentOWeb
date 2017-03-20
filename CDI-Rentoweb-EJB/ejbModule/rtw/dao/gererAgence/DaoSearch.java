package rtw.dao.gererAgence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rtw.entity.gererAgence.Agence;
import rtw.util.ParametreCommun;

/**
 * 
 * @author Olivier Classe DAO permettant la persistance des données en base.
 * 
 * 
 *
 */
@LocalBean
@Singleton
public class DaoSearch {
	@PersistenceContext(unitName = ParametreCommun.PERSISTENCE_UNIT_NAME)
	private EntityManager em;
	List<Agence> listAgences;

	/**
	 * 
	 */

	public Agence searchAgenceByRef(int idAgence) {
		Agence agence = em.find(Agence.class, idAgence);
		if (agence == null)
			throw new RuntimeException("agence réf: " + idAgence + " introuvable");
		return agence;
	}

	/**
	 * 
	 */

	public List<Agence> searchAgenceByName(String nomAgence) {
		Query query = em.createQuery("select a from Agence a where a.nomAgence asc");
		for (Object a : query.getResultList()) {
			if (a instanceof Agence) {
				listAgences.add((Agence) a);
			}
		}
		return listAgences;
	}

	/**
	 * 
	 */
	public List<Agence> searchAgenceByCP(String codePostal) {
		Query query = em.createQuery("select a from Agence a where a.nomAgence asc");
		for (Object a : query.getResultList()) {
			if (a instanceof Agence) {
				listAgences.add((Agence) a);
			}
		}
		return listAgences;

	}
	
	/**
	 * 
	 */
	public List<Agence> searchAgenceAll(){
		Query query = em.createQuery("select a from Agence a where a.codePostal asc");
		for (Object a : query.getResultList()) {
			if (a instanceof Agence) {
				listAgences.add((Agence) a);
			}
		}
		return listAgences;
		
	}
}
