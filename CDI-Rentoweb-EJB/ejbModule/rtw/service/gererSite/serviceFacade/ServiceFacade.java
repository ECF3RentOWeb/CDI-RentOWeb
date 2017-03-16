/**
 * 
 */
package rtw.service.gererSite.serviceFacade;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import rtw.clientServer.gererSite.IServiceFacade;
import rtw.entity.gererSite.User;
import rtw.service.gererSite.serviceInscription.ServiceInscription;

/**
 * @author Afpa
 *
 */
@Stateless
@Remote(IServiceFacade.class)
public class ServiceFacade implements IServiceFacade{
	
	@EJB
	ServiceInscription serviceInscription;

	@Override
	public User ajouterUser(User user) {
		return serviceInscription.addUser(user);
		
	}

	@Override
	public User modifierUser(User user) {
		return serviceInscription.updateUser(user);
		
	}

	@Override
	public void supprimerUser(int identifier) {
		serviceInscription.supprimerUser(identifier);
		
	}

	
	
	
}
