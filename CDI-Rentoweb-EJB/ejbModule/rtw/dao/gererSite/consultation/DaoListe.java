/**
 * 
 */
package rtw.dao.gererSite.consultation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;

/**
 * @author Afpa
 * La classe s'occupant de 
 * Lister les utilisateurs
 * Rechercher les utilisateurs
 * Elle s'occupe de la consultation des inscriptions
 *
 */
@Singleton
@LocalBean
public class DaoListe {

	@PersistenceContext(unitName= "rentoweb")
	private EntityManager em;

	/**
	 * Méthode pour lister les utilisateurs par nom
	 */
	public List<User>  getUserByNom(){
		ArrayList<User> users = new ArrayList<User>();
		//"select u, l, d from User u  left outer join fetch u.profil l left outer join l.droit order by u.lastName asc"
		
		for (Object u : em.createQuery
				("select u from User u "
						+ "left outer join fetch u.profil p "
						+ "order by u.lastName asc"
						).getResultList())
		{   
			if (u instanceof User) 
				users.add((User)u);
		}
		return users;
	}

	/**
	 * Lister les profils par id
	 * @return
	 */
	public List<Profil> getProfilById(){
		ArrayList<Profil> profils = new ArrayList<Profil>();

		for (Object p : em.createQuery
				("select p from Profil p "
				+ "order by p.id asc").getResultList())
		{   
			if (p instanceof Profil) 
				profils.add((Profil)p);
		}
		
		return profils;
	}

	/**
	 * Lister les droits par id
	 * @return
	 */
	public List<Droit> getDroitById(){
		ArrayList<Droit> droits = new ArrayList<Droit>();

		for (Object d : em.createQuery
				("select d from Droit d "
						+ "order by d.id asc").getResultList())
		{   
			if (d instanceof Droit) 
				droits.add((Droit)d);
		}
		
		return droits;
	}


}
