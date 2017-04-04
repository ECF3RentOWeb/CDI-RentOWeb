package rtw.beanAction.gererAvis;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rtw.clientServer.gererAvis.FacadeServiceAvisRemote;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;

public class ActionAvisAnnonce extends ApplicationSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2827407737772729819L;
	
	private static Context context;
	private static FacadeServiceAvisRemote facadeServiceAvisRemote;
	
	private void init() {

		try {
			context = new InitialContext();
			facadeServiceAvisRemote = (FacadeServiceAvisRemote) context.lookup("ejb:/testDaoServeur/FacadeServiceAvis!rtw.clientServeur.gererAvis.FacadeServiceAvisRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("Methode execute");
		return SUCCESS;
	}
	
	public String creer() {
		
		init();
		
		AvisAnnonce avisAnnonce = new AvisAnnonce();
		
		
		
		System.out.println("Methode creer");
		facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		return SUCCESS;

	}
	
	public String modifier() {
		
		System.out.println("Methode modifier");
		return SUCCESS;

	}
	
	public String supprimer(){
		
		System.out.println("Methode supprimer");
		return SUCCESS;
		
	}
	
	public String afficher() {

		System.out.println("Methode afficher");
		return SUCCESS;

	}
	
	public String lister() {

		System.out.println("Methode lister");
		return SUCCESS;

	}

}
