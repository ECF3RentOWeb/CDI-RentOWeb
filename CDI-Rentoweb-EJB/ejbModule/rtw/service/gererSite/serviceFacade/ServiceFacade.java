/**
 * 
 */
package rtw.service.gererSite.serviceFacade;

import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.omg.CORBA.UserException;

import rtw.clientServer.gererSite.IServiceFacade;
import rtw.entity.gererSite.Droit;
import rtw.entity.gererSite.Profil;
import rtw.entity.gererSite.User;
import rtw.exception.gererSite.DaoException;
import rtw.exception.gererSite.DonneeInvalideException;
import rtw.service.gererSite.serviceConsultation.ServiceListe;
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
	@EJB
	ServiceListe serviceListe;

	@Override
	public User ajouterUser(User user) throws UserException, DaoException, DonneeInvalideException{
		System.out.println("On passe par la façade service pour appeler le service des inscriptions");		
		
		return serviceInscription.ajouterUser(user);	
	}

	@Override
	public User modifierUser(User user) {
		return serviceInscription.updateUser(user);
		
	}

	@Override
	public void supprimerUser(int identifier) {
		serviceInscription.supprimerUser(identifier);
		
	}

	@Override
	public List<User> getUserByNom() {
		
		System.out.println("Demande de la liste des utilisateurs");
		
		return serviceListe.getUserByNom();
	
	}

	@Override
	public Profil ajouterProfil(Profil profil) {
		// TODO Auto-generated method stub
		return serviceInscription.addProfil(profil);
	}

	@Override
	public Profil modifierProfil(Profil profil) {
		// TODO Auto-generated method stub
		return serviceInscription.updateProfil(profil);
	}

	@Override
	public void supprimerProfil(int id) {
		// TODO Auto-generated method stub
		serviceInscription.supprimerProfil(id);
	}

	@Override
	public List<Profil> getProfilById() {
		// TODO Auto-generated method stub
		return serviceListe.getProfilById();
	}

	@Override
	public Collection<Droit> addDroit(Collection<Droit> droitsProfil) {
		// TODO Auto-generated method stub
		return serviceInscription.addDroit(droitsProfil);
	}

	@Override
	public Droit modifierDroit(Droit droit) {
		// TODO Auto-generated method stub
		return serviceInscription.updateDroit(droit);
	}

	@Override
	public void supprimerDroit(int id) {
		// TODO Auto-generated method stub
		serviceInscription.supprimerDroit(id);
	}

	@Override
	public List<Droit> getDroitById() {
		// TODO Auto-generated method stub
		return serviceListe.getDroitById();
	}

	@Override
	public Droit ajouterDroit(Droit droit) {
		// TODO Auto-generated method stub
		return serviceInscription.addDroit(droit);
	}
	
	
}
