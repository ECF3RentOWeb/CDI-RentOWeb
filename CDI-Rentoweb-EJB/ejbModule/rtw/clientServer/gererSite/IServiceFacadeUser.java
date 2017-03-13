/**
 * 
 */
package rtw.clientServer.gererSite;

import java.util.List;

/**
 * @author Afpa
 *
 */
public interface IServiceFacadeUser {
	public void inscrireUser(IUser user);
	public void modifierUser(IUser user);
	public void supprimerUser(IUser user);
	public List<IUser> getUserParNom(IUser user);
	

}
