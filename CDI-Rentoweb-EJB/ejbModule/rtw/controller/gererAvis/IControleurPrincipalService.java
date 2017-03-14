package rtw.controller.gererAvis;

import javax.ejb.Remote;

@Remote
public interface IControleurPrincipalService {
	
	public void creerAvisAnnonce();

	public void editerAvisAnnonce();
	
	
	
}
