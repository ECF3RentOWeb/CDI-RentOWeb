/**
 * 
 */
package rtw.dao.gererSite.daoInscription;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.clientServer.gererSite.IUser;
import rtw.entity.gererSite.User;

/**
 * @author Afpa
 *
 */
@LocalBean
@Singleton
public class DaoInscription {
	@PersistenceContext(unitName=rtw.util.gererSite.utilBdD.UtilBdD.PERSISTANCE_UNITNAME)
	private EntityManager em;
	
	public void addUser(IUser user) {
		em.persist(user);
	}
	
	public void updateUser(IUser user) {
		em.merge(user);
	}
	
	public void delUser(IUser user) {
		delUser(user.getIdentifierUser());
	}
	
	public void delUser(int identifier) {
		User user = em.find(User.class, identifier);
		em.remove(user);
	}
	
}
