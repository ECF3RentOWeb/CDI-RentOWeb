/**
 * 
 */
package rtw.clientServer.gererSite;

import java.util.Collection;
import java.util.List;

import org.omg.CORBA.UserException;

import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;
import rtw.exception.gererSite.DaoException;

/**
 * @author souleymane
 * @version 1
 * Contrôle aux frontières
 * Vos papiers s'il vous plait
 *
 */
public interface IServiceFacade {
	// Service User
	public User ajouterUser(User user) throws UserException, DaoException;
	public User modifierUser(User user) throws UserException, DaoException;;
	public void supprimerUser(int identifier) throws UserException, DaoException;;
	public List<User> getUserByNom() throws UserException, DaoException;;
	public Profil ajouterProfil(Profil profil) throws UserException, DaoException;;
	public Profil modifierProfil(Profil profil) throws UserException, DaoException;;
	public void supprimerProfil(int id) throws UserException, DaoException;;
	public List<Profil> getProfilById() throws UserException, DaoException;;
	public Droit ajouterDroit(Droit droit) throws UserException, DaoException;;
	public Collection<Droit> addDroit(Collection<Droit> droitsProfil) throws UserException, DaoException;;
	public Droit modifierDroit(Droit droit) throws UserException, DaoException;;
	public void supprimerDroit(int id) throws UserException, DaoException;;
	public List<Droit> getDroitById() throws UserException, DaoException;;

}
