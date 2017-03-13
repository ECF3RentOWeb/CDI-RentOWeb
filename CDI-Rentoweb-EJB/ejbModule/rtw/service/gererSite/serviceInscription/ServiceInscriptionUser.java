/**
 * 
 */
package rtw.service.gererSite.serviceInscription;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import rtw.clientServer.gererSite.IUser;
import rtw.dao.gererSite.daoFacade.DaoFacade;

/**
 * @author Afpa
 *
 */
@LocalBean
@Singleton
public class ServiceInscriptionUser {
	@EJB private DaoFacade daoFacade;

	public void addUser(IUser user) {
		daoFacade.addUser(user);
		
	}
	public void updateUser(IUser user){
		daoFacade.updateUser(user);
	}
	public void delUser(IUser user){
		daoFacade.delUser(user);
	}
	public void delUser(int identifier){
		daoFacade.delUser(identifier);
	}
	
}
