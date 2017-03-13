package rtw.dao.gererAvis.daoAvisAnnonce;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.util.ParametreCommun;

/**
 * Classe qui g�re toute la DAO des avis annonce.
 * 
 * @author Aur�lien
 * @Version 1
 * @since 13/03/2017
 *
 */
public class DaoAvisAnnonce {
	
	@PersistenceContext(unitName=ParametreCommun.PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public DaoAvisAnnonce() {
		// TODO Auto-generated constructor stub
	}

	
}
