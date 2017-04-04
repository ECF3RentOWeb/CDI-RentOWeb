/**
 * 
 */
package rtw.dao.gererSite.facade;

import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import rtw.dao.gererSite.consultation.DaoListe;
import rtw.dao.gererSite.inscription.DaoInscription;
import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;
import rtw.exception.gererSite.DonneeInvalideException;
import rtw.exception.gererSite.DoublonException;
import rtw.exception.gererSite.NonTrouveException;
import rtw.exception.gererSite.ObjetNullException;

/**
 * @author souleymane
 * @version 1
 * Une classe de transition
 * elle reçoit et transmet
 * 
 * TODO Méthodes Lister par critère
 *
 */
@Singleton
@LocalBean
public class DaoFacade {

	@EJB
	DaoInscription daoInscription;
	@EJB
	DaoListe	daoListe;

	/**
	 * 
	 * @param user
	 * @return retourne un user 
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws NonTrouveException
	 * @throws DonneeInvalideException
	 */
	public User addUser(User user) throws 
		ObjetNullException, 
		DoublonException,
		NonTrouveException, 
		DonneeInvalideException{

		System.out.println("DaoFacade recoit pour transmission du user" + user);

		return daoInscription.addUser(user);
	}
	/**
	 * 
	 * @param user
	 * @return un user
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 * @throws NonTrouveException
	 */
	public User updateUser(User user) throws 
		ObjetNullException, 
		DoublonException, 
		DonneeInvalideException, 
		NonTrouveException {

		System.out.println("**DaoFacade recoit pour transmission du user à modifier**" + user);

		return daoInscription.updateUser(user);
	}

	/**
	 * 
	 * @param identifier
	 * @throws ObjetNullException
	 * @throws NonTrouveException
	 */
	public void delUser(int identifier) throws 
		ObjetNullException, 
		NonTrouveException{

		System.out.println("**DaoFacade recoit pour transmission du user à supprimer**" );

		daoInscription.delUser(identifier);
	}

	/**
	 * 
	 * @return
	 */
	public List<User>  getUserByNom(){

		System.out.println("**On essaie d'obtenir la liste des utilisateurs par nom**");

		return daoListe.getUserByNom();
	}

	/**
	 * 
	 * @param profil
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public Profil addProfil(Profil profil) throws 
		ObjetNullException, 
		DoublonException, 
		DonneeInvalideException{
		
		return daoInscription.addProfil(profil);

	}

	/**
	 * 
	 * @param profil
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 * @throws NonTrouveException
	 */
	public Profil updateProfil(Profil profil) throws 
		ObjetNullException, 
		DoublonException, 
		DonneeInvalideException, 
		NonTrouveException{
		
		return daoInscription.updateProfil(profil);
	}

	/**
	 * 
	 * @param id
	 * @throws ObjetNullException
	 * @throws NonTrouveException
	 */
	public void delProfil(int id) throws 
		ObjetNullException, 
		NonTrouveException{
		
		daoInscription.delProfil(id);
	}

	/**
	 * 
	 * @return
	 */
	public List<Profil> getProfilById(){
		
		return daoListe.getProfilById();
	}

	// service Droit
	/**
	 * 
	 * @param droitsProfil
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public Collection<Droit> addDroit(Collection<Droit> droitsProfil) throws 
		ObjetNullException, 
		DoublonException, 
		DonneeInvalideException{
		
		return daoInscription.addDroit(droitsProfil);
	}

	/**
	 * 
	 * @param droit
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public Droit addDroit(Droit droit) throws 
		ObjetNullException, 
		DoublonException, 
		DonneeInvalideException{
		
		return daoInscription.addDroit(droit);

	}

	/**
	 * 
	 * @param droit
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public Droit updateDroit(Droit droit) throws ObjetNullException, DoublonException, DonneeInvalideException{
		return daoInscription.updateDroit(droit);
	}

	/**
	 * 
	 * @param id
	 * @throws ObjetNullException
	 * @throws NonTrouveException
	 */
	public void delDroit(int id) throws ObjetNullException, NonTrouveException{
		daoInscription.delDroit(id);

	}

	/**
	 * 
	 * @return
	 */
	public List<Droit> getDroitById(){
		return daoListe.getDroitById();
	}

}
