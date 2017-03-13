/**
 * 
 */
package rtw.service.gererSite.serviceFacade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import rtw.clientServer.gererSite.IServiceFacadeUser;
import rtw.clientServer.gererSite.IUser;
import rtw.service.gererSite.serviceInscription.ServiceInscriptionUser;

/**
 * @author Afpa
 *
 */
@Stateless
@Remote(IServiceFacadeUser.class)
public class ServiceFacadeUser implements IServiceFacadeUser {
	@EJB private ServiceInscriptionUser serviceInscriptionUser;

	@Override
	public void inscrireUser(IUser user) {
		serviceInscriptionUser.addUser(user);;
		
	}

	@Override
	public void modifierUser(IUser user) {
		serviceInscriptionUser.updateUser(user);
		
	}

	@Override
	public void supprimerUser(IUser user) {
		serviceInscriptionUser.delUser(user);
		
	}

	@Override
	public List<IUser> getUserParNom(IUser user) {
		
		return null;
	}

}
