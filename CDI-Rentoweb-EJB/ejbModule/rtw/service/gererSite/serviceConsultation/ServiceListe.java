/**
 * 
 */
package rtw.service.gererSite.serviceConsultation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import rtw.dao.gererSite.facade.DaoFacade;
import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;

/**
 * @author Souleymane
 * @version 1
 * Une seule façon de lister pour l'intant
 * TODO Lister par d'autres critères notamment
 * - Particulier
 * - Professionnel
 *
 */
@Singleton
@LocalBean
public class ServiceListe {
	
	@EJB
	DaoFacade daoFacade;
	
	/**
	 * Lister par nom
	 * @return Liste des utilisateurs par nom
	 */
	public List<User>  getUserByNom(){
		
		System.out.println("dans le service de consultation des utilisateurs");
		
		return daoFacade.getUserByNom();	
	}
	
	/**
	 * Lister les profil par id
	 * @return liste de droits par id
	 */	
	public List<Profil> getProfilById(){
		
		System.out.println("dans le service de consultation des profils");
		
		return daoFacade.getProfilById();
		
	}
	
	/**
	 * Lister les droits par id
	 * @return liste de droits par id
	 */
	public List<Droit> getDroitById(){
		
		System.out.println("dans le service de consultation des droits");
		
		return daoFacade.getDroitById();
		
	}

}
