/**
 * 
 */
package rtw.dao.gererSite.inscription;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererSite.User;


/**
 * @author Afpa
 *
 */
@LocalBean
@Singleton
public class DaoInscription {
	@PersistenceContext(unitName="rentoweb")
	private EntityManager em;
	
	public User addUser(User user) {
		em.persist(user);
		return user;
	}
	
	public User updateUser(User user) {
		em.merge(user);
		return user;
	}
		
	public void delUser(int identifier) {
		User user = em.find(User.class, identifier);
		em.remove(user);
	}
	

}
