/**
 * 
 */
package rtw.service.gererSite.serviceInscription;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import org.omg.CORBA.UserException;

import rtw.dao.gererSite.facade.DaoFacade;
import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;
import rtw.exception.gererSite.DaoException;
import rtw.exception.gererSite.DonneeInvalideException;
import rtw.exception.gererSite.DoublonException;
import rtw.exception.gererSite.NonTrouveException;
import rtw.exception.gererSite.ObjetNullException;

/**
 * @author souleymane
 * @version 1
 * Le service d'inscription le plus simple au monde
 *
 */
@Singleton
@LocalBean
public class ServiceInscription {

	@EJB
	DaoFacade daoFacade;

	public User ajouterUser(User user) throws UserException, DaoException, DonneeInvalideException{
		try {
			user = daoFacade.addUser(user);
		} catch (DoublonException e) {
			System.out.println(DoublonException.getMessage1());

		}catch (ObjetNullException e1){
			user = null;
			System.out.println(ObjetNullException.getMessage1());	
		}catch(DonneeInvalideException e2){
			System.out.println(DonneeInvalideException.getMessage1());
		}
		return user;
	}
	public User updateUser(User user){
		try {
			user = daoFacade.updateUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			user = daoFacade.updateUser(user);
		} catch (ObjetNullException | DoublonException | DonneeInvalideException | NonTrouveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * En supprimant un user on supprime en cascade le profil et les droits qui sont associés à ce profil
	 * @param identifier
	 */
	public void supprimerUser(int identifier){
		System.out.println("attention vous vous appretez à supprimer un profil ainsi que les droits liés à ce profil");

			try {
				daoFacade.delUser(identifier);
			} catch (ObjetNullException e) {
				System.out.println("ServiceInscription : erreur : " + e.getMessage());
			} catch (NonTrouveException e) {
				System.out.println("ServiceInscription : erreur : " + e.getMessage());
			}


	}

	public Profil addProfil(Profil profil){
		try {
			profil = daoFacade.addProfil(profil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return profil;

	}

	public Profil updateProfil(Profil profil){

		try {
			return daoFacade.updateProfil(profil);
		} catch (ObjetNullException | DoublonException | DonneeInvalideException | NonTrouveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profil;

	}

	/**
	 * En supprimant un profil on supprime le user qui lui est associé et les droits qui sont associés à ce profil
	 * @param id
	 */

	public void supprimerProfil(int id){

		System.out.println("attention vous vous appretez à supprimer un profil ainsi que les droits liés à ce profil");
		try {
			daoFacade.delProfil(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	public Collection<Droit> addDroit(Collection<Droit> droitsProfil){

		try {
			return daoFacade.addDroit(droitsProfil);
		} catch (ObjetNullException | DoublonException | DonneeInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return droitsProfil;

	}

	public Droit addDroit(Droit droit){

		try {
			return daoFacade.addDroit(droit);
		} catch (ObjetNullException | DoublonException | DonneeInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return droit;

	}

	public Droit updateDroit(Droit droit){

		try {
			return daoFacade.updateDroit(droit);
		} catch (ObjetNullException | DoublonException | DonneeInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return droit;

	}

	public void supprimerDroit(int id){
		try {
			daoFacade.delDroit(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


}
