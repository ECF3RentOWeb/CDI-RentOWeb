/**
 * 
 */
package rtw.dao.gererSite.inscription;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;
import rtw.exception.gererSite.DonneeInvalideException;
import rtw.exception.gererSite.DoublonException;
import rtw.exception.gererSite.NonTrouveException;
import rtw.exception.gererSite.ObjetNullException;

/**
 * @author Souleymane
 * @see User.java
 * @version version1
 * la gestion des inscriptions d'un user, leurs modifications et leurs suppressions
 *
 */
@LocalBean
@Singleton
public class DaoInscription {

	@PersistenceContext(unitName= "rentoweb")
	private EntityManager em;

	/**
	 * - Les contr�les sont � effectuer avant le persist
	 * - V�rifier qu'il n'y a pas de doublon
	 * - V�rifier l'objet n' est pas null
	 * - v�rifier que les propri�t�s respectent les r�gles de gestion 
	 * @param user
	 * @return user
	 * @exception ObjetNullException, DoublonException
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException 
	 */
	public User addUser(User user) throws 
	ObjetNullException, 
	DoublonException, 
	DonneeInvalideException{ 

		System.out.println("On s'apprete � persister un user" + user);
		//On ajoute l'utilisateur si tout est ok.
		// Il n' y a jamais de cr�ation d'un user qui n' a pas de profil.

		if (user!= null) {

			//On demande la validation des donn�es du user avant de l'ajouter
			validerFormulaire(user);
			System.out.println("les donn�es du user ont �t� valid�es" + user);

			// Si le user n'est pas null et que toutes les donn�es ont �t� valid�es
			// alors on lui associe un profil. 
			Profil profil = user.getProfil();

			// le profil ne doit pas �tre null
			if (profil != null) {
				profil = addProfil(profil);
			}
			// Ensuite on associe le profil au user
			user.setProfil(profil);

			// Enfin on demande � l'entityManager de persister le user
			// Le user est persist� en cascade
			try {
				em.persist(user);
				em.flush();
			} catch (PersistenceException e) {
				Throwable t = e.getCause();
				while ((t != null) && !
						(t instanceof SQLIntegrityConstraintViolationException)
						) {
					t = t.getCause();
				}
				if (t instanceof SQLIntegrityConstraintViolationException) {
					throw new DoublonException(DoublonException.MESSAGE1);
				}			
			}		
			System.out.println("*** DaoInscription - addUser - insert dans la base OK");

		}else{
			throw new ObjetNullException(ObjetNullException.MESSAGE1);
		}

		return user;
	}

	/**
	 * 
	 * @param profil
	 * @return profil
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public Profil addProfil(Profil profil) throws 
	ObjetNullException, 
	DoublonException, 
	DonneeInvalideException{

		System.out.println("le profil � ajouter au user est" + profil.toString());
		if (profil != null) {
			String nomProfil = profil.getNomProfil();
			if ((nomProfil.trim().length() > 10) && (nomProfil != null)){

			}else{
				throw new DonneeInvalideException();
			}

			Collection<Droit> droitsProfil = profil.getDroits();
			if (droitsProfil != null) {
				droitsProfil = (Collection<Droit>) addDroit(droitsProfil);					
			}
			// On associe les droits au profil
			profil.setDroits(droitsProfil);

			// Enfin on demande � em de persister le profil

			try {
				em.persist(profil);
				em.flush();
			} catch (PersistenceException e) {
				Throwable t = e.getCause();
				if (t instanceof SQLIntegrityConstraintViolationException) {
					throw new DoublonException(DoublonException.getMessage2());
				}						
			}
			System.out.println("*** DaoInscription - addProfil - insert dans la base OK");
		}else{
			throw new ObjetNullException();
		}
		
		return profil;
	}

	/**
	 * TODO: A finaliser et � v�rifier
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

		System.out.println(" le ou les droits � ajouter "
				+ "au profil est/sont " + droit);

		try {

			em.persist(droit);
			em.flush();

		} catch (PersistenceException e) {

			String message = (ObjetNullException.getMessage3() +  
					DoublonException.getMessage3() + 
					DonneeInvalideException.getMessage1()); 
			e.getLocalizedMessage();

			//Test
			System.out.println("il y a eu un probl�me "
					+ "lors de la persistence de vos droits, soit " 
					+ ObjetNullException.getMessage3()+ " soit " 
					+ DoublonException.getMessage3() + "soit " 
					+ DonneeInvalideException.getMessage1());

			//Test
			System.out.println(message);
			System.out.println(e.getLocalizedMessage());
		}

		return droit;
	}

	/**
	 * Mis � jour d'un User
	 * Si User inexistant, cr�er un nouveau User
	 * @param user
	 * @return
	 * @throws NonTrouveException 
	 */
	public User updateUser(User user) throws 
	ObjetNullException, 
	DoublonException, 
	DonneeInvalideException, 
	NonTrouveException{

		System.out.println(" On s'appr�te � modifier des informations "
				+ "d'un utilisateur " + user.getIdentifier());

		Profil profil = null;

		if (user != null) {
			profil = user.getProfil();

			if (profil != null) {
				profil = updateProfil(profil);
				user.getProfil();
				user.setProfil(profil);
			}

			em.merge(user);
			em.flush();
		}
		return user;
	}

	/**
	 * Suppression d'un utilisateur � partir de son identifiant
	 * � compl�ter par d'autres m�thodes de suppression
	 * @param identifier
	 * TODO les exceptions � g�rer si on essaie de supprimer un user inexistant
	 */
	public void delUser(int identifier) throws 
	NonTrouveException {

		System.out.println("essaie de suppression d'un user " + identifier);

		User user = em.find(User.class, identifier);

		if (user != null){

			em.remove(user);
			em.flush();

		}else {
			throw new NonTrouveException(NonTrouveException.MESSAGE);	
		}
	}

	public Profil updateProfil(Profil profil) throws 
	ObjetNullException, 
	DonneeInvalideException, 
	NonTrouveException{

		if (profil != null) {

			if (profil.getId() > 0) {

				profil = em.merge(profil);
				em.flush();
			}			
		}

		return profil;
	}

	/**
	 * Supprimer un profil, c'est supprimer tous les droits du profil et le user associ� � ce profil
	 * @param id
	 * TODO: 
	 * @throws NonTrouveException 
	 */
	public void delProfil(int id) throws 
	ObjetNullException, 
	NonTrouveException{

		Profil profil = 
				em.find(Profil.class, id);

		if (profil != null) {
			try {                       // TODO: g�rer la suppression en cascade.
				em.remove(profil);
				em.flush();

			}catch(ConstraintViolationException c){
				//Test
				c.getMessage();
				c.printStackTrace();

				try {
					System.out.println("avant doublon");
					throw new DoublonException(DoublonException.getMessage3());
				} catch (DoublonException e) {
					// TEST 
					e.getMessage();
					e.printStackTrace();
				}

			}catch (PersistenceException e){
				throw new NonTrouveException(NonTrouveException.MESSAGE);
			}

		}else{
			throw new ObjetNullException(NonTrouveException.MESSAGE);
		}

	}

	/**
	 * La suppression des drois entraine la mise � jour des profils 
	 * et des user auquels ces droits sont li�s.
	 * @param id
	 * @throws NonTrouveException 
	 */
	public void delDroit(int id) throws 
	ObjetNullException,  
	NonTrouveException{
		Droit droit = 
				em.find(Droit.class, id);
		if (droit != null) {

			try {
				em.remove(droit);
				em.flush();
			} catch (PersistenceException e) {
				throw new NonTrouveException(NonTrouveException.MESSAGE);				
			}			
		}else{
			throw new ObjetNullException(NonTrouveException.MESSAGE);
		}

	}

	/**
	 * 
	 * @param droit
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public Droit updateDroit(Droit droit) throws 
	ObjetNullException, 
	DoublonException, 
	DonneeInvalideException{
		// TODO Auto-generated method stub
		return droit;
	}

	/**
	 * 
	 * @param droitsProfil
	 * @return
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public Collection<Droit> addDroit(Collection<Droit> droitsProfil) throws ObjetNullException, DoublonException, DonneeInvalideException{
		// TODO Auto-generated method stub
		return droitsProfil;
	}

	/**
	 * 
	 * @param id r�cuperez un user en saosissant son identifiant
	 * Si le user n'existe pas, vous pourrez le cr�er.
	 * @return  Cette m�thode retourne un particulier ou un professionnel
	 * @throws exception.NonTrouveException
	 */
	public User getUser(int id) throws 
	NonTrouveException{

		User user = null;
		try {
			user = em.find(User.class, id);
		} catch (PersistenceException e) {
			Throwable t = e.getCause();
			while ((t != null) && !(t instanceof NoResultException)) {
				t = t.getCause();
			}
			if (t instanceof NoResultException) {
				throw new NonTrouveException();
			}
		}

		return user;
	}

	/**
	 * Cette M�thode qui sera appel� syst�matiquement 
	 * � chaque fois qu'on ajoute un user.
	 * @param user
	 * @throws ObjetNullException
	 * @throws DoublonException
	 * @throws DonneeInvalideException
	 */
	public void validerFormulaire(User user) throws ObjetNullException, DoublonException, DonneeInvalideException{

		if (user != null) {

			// r�cuperation des donn�es
			int identifier = user.getIdentifier();
			String email = user.getEmail();
			String password		= user.getPassword();
			String resetPassword = user.getResetPassword();
			String lastName = user.getLastName();
			String firstName = user.getFirstName();
			int phoneNumber = user.getPhoneNumber();

			if (identifier > 0) {   //TODO: � g�rer 
				System.out.println(" identifiant est ok");

				if (email.trim().length() > 5 &&(email != null)) {
					System.out.println(" email est ok");

					if (password.trim().length() > 5 && (password != null)) {
						System.out.println(" mot de passe est ok");

						if (resetPassword.trim().length() > 5 && (resetPassword != null)) {
							System.out.println(" confirmation mot de passe est ok");

							if (lastName.trim().length() > 5 && (lastName != null)) {
								System.out.println(" le nom est ok");

								if (firstName.trim().length() > 5 && (firstName != null)) {
									System.out.println(" le prenom est ok");

									if (phoneNumber > 0) {
										System.out.println(" le num�ro de t�l�phone est ok");										
									}else{
										throw new DonneeInvalideException(DonneeInvalideException.MESSAGE1);
									}

								}else{
									throw new DonneeInvalideException(DonneeInvalideException.MESSAGE1);
								}

							}else{
								throw new DonneeInvalideException(DonneeInvalideException.MESSAGE1);
							}

						}else{
							throw new DonneeInvalideException(DonneeInvalideException.MESSAGE1);
						}

					}else{
						throw new DonneeInvalideException(DonneeInvalideException.MESSAGE1);
					}

				}else{
					throw new DonneeInvalideException(DonneeInvalideException.MESSAGE1);
				}

			}else{
				throw new DonneeInvalideException(DonneeInvalideException.MESSAGE1);
			}

		}else{
			throw new ObjetNullException(ObjetNullException.MESSAGE1);
		}		
	}

}


