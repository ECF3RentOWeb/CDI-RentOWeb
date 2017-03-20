/**
 * 
 */
package rtw.dao.gererSite.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import rtw.dao.gererSite.inscription.DaoInscription;
import rtw.entity.gererSite.User;


/**
 * @author Afpa
 *
 */
@Singleton
@LocalBean
public class DaoFacade {
	@EJB
	DaoInscription daoInscription;
	
	public User addUser(User user) {
		return daoInscription.addUser(user);
	}
	
	public User updateUser(User user) {
		return daoInscription.updateUser(user);
	}
	public void delUser(int identifier){
		daoInscription.delUser(identifier);
	}

}
