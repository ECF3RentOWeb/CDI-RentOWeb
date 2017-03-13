/**
 * 
 */
package rtw.dao.gererSite.daoFacade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import rtw.clientServer.gererSite.IUser;
import rtw.dao.gererSite.daoInscription.DaoInscription;

/**
 * @author Afpa
 *
 */
@LocalBean
@Singleton
public class DaoFacade {
	@EJB private DaoInscription daoInscription;
	
	public void addUser(IUser user){
		daoInscription.addUser(user);
	}
	public void updateUser(IUser user){
		daoInscription.updateUser(user);
	}
	public void delUser(IUser user){
		daoInscription.delUser(user);
	}
	public void delUser(int identifier){
		daoInscription.delUser(identifier);
	}
	

}
