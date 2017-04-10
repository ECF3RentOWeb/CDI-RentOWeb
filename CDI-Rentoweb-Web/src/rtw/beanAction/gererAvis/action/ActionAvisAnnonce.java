package rtw.beanAction.gererAvis.action;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gson.Gson;

import rtw.clientServer.gererAvis.FacadeServiceAvisRemote;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.entity.gererAvis.note.entity.NoteBruitExterieur;
import rtw.entity.gererAvis.note.entity.NoteBruitInterieur;
import rtw.entity.gererAvis.note.entity.NoteEtatGeneral;
import rtw.entity.gererAvis.note.entity.NoteHumidite;
import rtw.entity.gererAvis.note.entity.NoteIsolationChaud;
import rtw.entity.gererAvis.note.entity.NoteIsolationFroid;
import rtw.entity.gererAvis.note.entity.NoteLuminosite;
import rtw.entity.gererAvis.note.entity.NoteRelationBailleur;
import rtw.util.gererAvis.Param;

public class ActionAvisAnnonce extends ActionAvis {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2827407737772729819L;
	
	private static Context context;
	private static FacadeServiceAvisRemote facadeServiceAvisRemote;
	private int bruit_ext;
	private int bruit_int;
	private int isole_froid;
	private int isole_chaud;
	private int humidite;
	private int luminosite;
	private int etat_gene;
	private int relation_bailleur;
	private String commentaire;

	private String jsonUtilisateur;
	private String jsonItem;

	
	private void init() {

		try {
			
			context = new InitialContext();
			facadeServiceAvisRemote = (FacadeServiceAvisRemote) context.lookup(Param.FACADE_EJB);
		
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String execute() throws Exception {
		
		//System.out.println("Methode execute");
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		//System.out.println("[Methode validate]");
		//System.out.println("Bruit ext = " + bruit_ext);
		if(getBruit_ext() == 0){
			addFieldError("bruit_ext","La note doit être renseigné");
		}if(getBruit_int() == 0){
			addFieldError("bruit_int","La note doit être renseigné");
		}if(getEtat_gene() == 0){
			addFieldError("etat_gene","La note doit être renseigné");
		}if(getHumidite() == 0){
			addFieldError("humidite","La note doit être renseigné");
		}if(getIsole_chaud() == 0){
			addFieldError("isole_chaud","La note doit être renseigné");
		}if(getIsole_froid() == 0){
			addFieldError("isole_froid","La note doit être renseigné");
		}if(getLuminosite() == 0){
			addFieldError("luminosite","La note doit être renseigné");
		}if(getRelation_bailleur() == 0){
			addFieldError("relation_bailleur","La note doit être renseigné");
		}if(getCommentaire().trim().isEmpty() || getCommentaire().equalsIgnoreCase("Votre commentaire...")){
			addFieldError("commentaire","Le commentaire doit être renseigné");
		}
		
		//System.out.println("[Fin methode validate]");
		super.validate();
	}
	
	public String creer() {
		
		init();
		
		//System.out.println("[Methode creer]");
		
		//TODO getUtilisateur getAnnonce
		Utilisateur utilisateur = new Utilisateur();
		Item item = new Item();
		utilisateur.setIdUtilisateur("1");
		item.setIdItem("1");
		
		//Recuperation d'un avisAnnonce avec un ID.
		AvisAnnonce avisAnnonce = facadeServiceAvisRemote.getAvisAnnonce(utilisateur,item);
		
		//set des differente propriété d'un avis annonce
		avisAnnonce.getCommentaire().setContenu(getCommentaire());
		
		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteLuminosite noteLuminosite = new NoteLuminosite();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		noteBruitExterieur.setValeur(getBruit_ext());
		noteBruitInterieur.setValeur(getBruit_int());
		noteIsolationFroid.setValeur(getIsole_froid());
		noteIsolationChaud.setValeur(getIsole_chaud());
		noteHumidite.setValeur(getHumidite());
		noteLuminosite.setValeur(getLuminosite());
		noteEtatGeneral.setValeur(getEtat_gene());
		noteRelationBailleur.setValeur(getRelation_bailleur());
		
		avisAnnonce.getNotes().add(noteBruitExterieur);
		avisAnnonce.getNotes().add(noteBruitInterieur);
		avisAnnonce.getNotes().add(noteIsolationFroid);
		avisAnnonce.getNotes().add(noteIsolationChaud);
		avisAnnonce.getNotes().add(noteHumidite);
		avisAnnonce.getNotes().add(noteLuminosite);
		avisAnnonce.getNotes().add(noteEtatGeneral);
		avisAnnonce.getNotes().add(noteRelationBailleur);
		
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		//System.out.println("[Fin Methode creer]");
		
		if(retour) return SUCCESS;
		else return ERROR;

	}
	
	public String modifier() {
		
		init();
			
		//System.out.println("[Methode modifier]");
		//TODO getUtilisateur getAnnonce
		Utilisateur utilisateur = new Utilisateur();
		Item item = new Item();
		utilisateur.setIdUtilisateur("1");
		item.setIdItem("1");
		
		//Recuperation d'un avisAnnonce avec un ID.
		AvisAnnonce avisAnnonce = facadeServiceAvisRemote.getAvisAnnonce(utilisateur,item);
		
		//set des differente propriété d'un avis annonce
		avisAnnonce.getCommentaire().setContenu(getCommentaire());
		
		NoteBruitExterieur noteBruitExterieur = new NoteBruitExterieur();
		NoteBruitInterieur noteBruitInterieur = new NoteBruitInterieur();
		NoteIsolationFroid noteIsolationFroid = new NoteIsolationFroid();
		NoteIsolationChaud noteIsolationChaud = new NoteIsolationChaud();
		NoteHumidite noteHumidite = new NoteHumidite();
		NoteLuminosite noteLuminosite = new NoteLuminosite();
		NoteEtatGeneral noteEtatGeneral = new NoteEtatGeneral();
		NoteRelationBailleur noteRelationBailleur = new NoteRelationBailleur();
		
		noteBruitExterieur.setValeur(getBruit_ext());
		noteBruitInterieur.setValeur(getBruit_int());
		noteIsolationFroid.setValeur(getIsole_froid());
		noteIsolationChaud.setValeur(getIsole_chaud());
		noteHumidite.setValeur(getHumidite());
		noteLuminosite.setValeur(getLuminosite());
		noteEtatGeneral.setValeur(getEtat_gene());
		noteRelationBailleur.setValeur(getRelation_bailleur());
		
		avisAnnonce.getNotes().add(noteBruitExterieur);
		avisAnnonce.getNotes().add(noteBruitInterieur);
		avisAnnonce.getNotes().add(noteIsolationFroid);
		avisAnnonce.getNotes().add(noteIsolationChaud);
		avisAnnonce.getNotes().add(noteHumidite);
		avisAnnonce.getNotes().add(noteLuminosite);
		avisAnnonce.getNotes().add(noteEtatGeneral);
		avisAnnonce.getNotes().add(noteRelationBailleur);
		
		boolean retour = facadeServiceAvisRemote.modifierAvisAnnonce(avisAnnonce);
		
		//System.out.println("[Fin Methode modifier]");
		
		if(retour) return SUCCESS;
		else return ERROR;

	}
	
	public String supprimer(){
		
		System.out.println("[Methode supprimer]");
		
		String retour = ERROR;
		init();
		
		Gson gson = new Gson();
		
		Utilisateur utilisateur = gson.fromJson(jsonUtilisateur, Utilisateur.class);
		Item item = gson.fromJson(jsonItem, Item.class);
		
		boolean bool = facadeServiceAvisRemote.supprimerAvisAnnonceById(utilisateur, item);
		if(bool) retour = SUCCESS;
		
		System.out.println("[Fin methode supprimer]");
		return retour;
		
	}
	
	public String afficher() {

		//System.out.println("Methode afficher");
		return SUCCESS;

	}
	
	public String lister() {

		//System.out.println("Methode lister");
		return SUCCESS;

	}
	
	


	/**
	 * @return the bruit_ext
	 */
	public int getBruit_ext() {
		return bruit_ext;
	}


	/**
	 * @param bruit_ext the bruit_ext to set
	 */
	public void setBruit_ext(int bruit_ext) {
		//System.out.println("setBruit_ext");
		this.bruit_ext = bruit_ext;
	}


	/**
	 * @return the bruit_int
	 */
	public int getBruit_int() {
		return bruit_int;
	}


	/**
	 * @param bruit_int the bruit_int to set
	 */
	public void setBruit_int(int bruit_int) {
		//System.out.println("setBruit_int");
		this.bruit_int = bruit_int;
	}


	/**
	 * @return the isole_froid
	 */
	public int getIsole_froid() {
		return isole_froid;
	}


	/**
	 * @param isole_froid the isole_froid to set
	 */
	public void setIsole_froid(int isole_froid) {
		//System.out.println("setIsole_froid");
		this.isole_froid = isole_froid;
	}


	/**
	 * @return the isole_chaud
	 */
	public int getIsole_chaud() {
		return isole_chaud;
	}


	/**
	 * @param isole_chaud the isole_chaud to set
	 */
	public void setIsole_chaud(int isole_chaud) {
		//System.out.println("setIsole_chaud");
		this.isole_chaud = isole_chaud;
	}


	/**
	 * @return the humidite
	 */
	public int getHumidite() {
		return humidite;
	}


	/**
	 * @param humidite the humidite to set
	 */
	public void setHumidite(int humidite) {
		//System.out.println("setHumidite");
		this.humidite = humidite;
	}


	/**
	 * @return the luminosite
	 */
	public int getLuminosite() {
		return luminosite;
	}


	/**
	 * @param luminosite the luminosite to set
	 */
	public void setLuminosite(int luminosite) {
		//System.out.println("setLuminosite");
		this.luminosite = luminosite;
	}


	/**
	 * @return the etat_gene
	 */
	public int getEtat_gene() {
		return etat_gene;
	}


	/**
	 * @param etat_gene the etat_gene to set
	 */
	public void setEtat_gene(int etat_gene) {
		//System.out.println("setEtat_gene");
		this.etat_gene = etat_gene;
	}


	/**
	 * @return the relation_bailleur
	 */
	public int getRelation_bailleur() {
		return relation_bailleur;
	}


	/**
	 * @param relation_bailleur the relation_bailleur to set
	 */
	public void setRelation_bailleur(int relation_bailleur) {
		//System.out.println("setRelation_bailleur");
		this.relation_bailleur = relation_bailleur;
	}


	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}


	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		//System.out.println("setCommentaire");
		this.commentaire = commentaire;
	}

	/**
	 * @return the jsonUtilisateur
	 */
	public String getJsonUtilisateur() {
		return jsonUtilisateur;
	}

	/**
	 * @param jsonUtilisateur the jsonUtilisateur to set
	 */
	public void setJsonUtilisateur(String jsonUtilisateur) {
		this.jsonUtilisateur = jsonUtilisateur;
	}

	/**
	 * @return the jsonItem
	 */
	public String getJsonItem() {
		return jsonItem;
	}

	/**
	 * @param jsonItem the jsonItem to set
	 */
	public void setJsonItem(String jsonItem) {
		this.jsonItem = jsonItem;
	}



}