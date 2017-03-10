package rtw.clientServer.gererAgence;

import java.util.List;

import javax.ejb.Remote;

import rtw.entity.gererAgence.Agence;

/**
 * 
 * @author olivier
 * Classe services métier de la classe
 * façade de la couche Service 
 * Cette classe service est accessible à distance
 *
 */

@Remote
public interface IServiceFacadeMetierAgenceRemote {
	
	public void ajouterAgence(Agence agence);
	public void supprimerAgenceByName(String nom);
	public void supprimerAgenceByRef(int idAgence);
	public void supprimerAgenceByNumSiren(String numSiren);
	public void modifierAgence(Agence agence);
	public Agence rechercherAgenceByRef(int idAgence);
	public List<Agence> rechercherAgenceByName(String nom);
	public List<Agence> rechercherAgenceByCp(String codePostal);
	public List<Agence> listerAgenceAll();
	

}
