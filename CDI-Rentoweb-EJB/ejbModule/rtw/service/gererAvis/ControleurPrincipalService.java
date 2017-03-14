package rtw.service.gererAvis;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import rtw.controller.gererAvis.IControleurPrincipalService;

/**
 * Session Bean implementation class ControleurPrincipalService
 */
@Stateless
@Remote(IControleurPrincipalService.class)
public class ControleurPrincipalService implements IControleurPrincipalService {

    /**
     * Default constructor. 
     */
    public ControleurPrincipalService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creerAvisAnnonce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editerAvisAnnonce() {
		// TODO Auto-generated method stub
		
	}

}
