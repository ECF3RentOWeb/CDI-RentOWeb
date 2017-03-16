/**
 * 
 */
package rtw.service.gererSite.serviceInscription;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import rtw.dao.gererSite.facade.DaoFacade;
import rtw.entity.gererSite.User;

/**
 * @author Afpa
 *
 */
@Singleton
@LocalBean
public class ServiceInscription {
	@EJB
	DaoFacade daoFacade;
	
	public User addUser(User user){
		user = daoFacade.addUser(user);
		return user;
	}
	public User updateUser(User user){
		user = daoFacade.updateUser(user);
		return user;
	}
	public void supprimerUser(int identifier){
		daoFacade.delUser(identifier);
	}
	

}
