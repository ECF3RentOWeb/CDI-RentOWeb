/**
 * 
 */
package rtw.clientServer.gererSite;

import rtw.entity.gererSite.User;

/**
 * @author Afpa
 *
 */
public interface IServiceFacade {
	public User ajouterUser(User user);
	public User modifierUser(User user);
	public void supprimerUser(int identifier);

}
