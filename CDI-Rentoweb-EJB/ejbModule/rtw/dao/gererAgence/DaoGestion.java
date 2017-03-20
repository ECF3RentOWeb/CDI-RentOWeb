package rtw.dao.gererAgence;

/**
 * 
 * @author Olivier 
 * Classe metier permettant de regrouper les traitements 
 * gestion m�tiers concernant les fiches agences
 *
 */

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererAgence.Agence;
import rtw.util.ParametreCommun;



@LocalBean
@Singleton
public class DaoGestion {
	@PersistenceContext(unitName=ParametreCommun.PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	/**
	 * Methode permettant d'ajouter une fiche agence en base
	 * @param d'entr�e : Agence
	 * 
	 */
	public void addAgence(Agence agence) {
		if (agence != null) {
			em.persist(agence);
		}
	}

	/**
	 * M�thode permettant de supprimer une fiche agence en BDD
	 * en fonction du nom de l'agence
	 * @param d'entr�e : nomAgence
	 */
	public void deleteAgenceByNAme(String nomAgence) {
		Agence agence = em.find(Agence.class, nomAgence);
		if (agence == null)

			throw new RuntimeException("Agence : " + nomAgence + " introuvable ");
		em.remove(agence);

	}

	/**
	 * M�thode permettant de supprimer une fiche agence en fonction 
	 * de la r�f�rence de la fiche.
	 * @param d'entr�e : idAgence
	 */
	public void deleteAgenceByRef(int idAgence) {
		Agence agence = em.find(Agence.class, idAgence);
		if (agence == null)

			throw new RuntimeException("Agence r�f : " + idAgence + " introuvable ");
		em.remove(agence);

	}

	/**
	 * M�thode permettant de supprimer une fiche agence en fonction 
	 * du num�ro SIREN de l'agence.
	 * @param d'entr�e : numSiren
	 */
	public void deleteAgenceByNumSIREN(String numSiren) {

		Agence agence = em.find(Agence.class, numSiren);
		if (agence == null)

			throw new RuntimeException("Agence num�ro SIREN : " + numSiren + " introuvable ");
		em.remove(agence);
	}

	/**
	 * M�thode permettant de mettre � jour une agence
	 * @param d'entr�e : agence
	 */
	public void updateAgence(Agence agence) {
		em.merge(agence);
	}
}
