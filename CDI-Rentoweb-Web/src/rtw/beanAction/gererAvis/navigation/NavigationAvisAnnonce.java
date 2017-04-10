package rtw.beanAction.gererAvis.navigation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gson.Gson;

import rtw.clientServer.gererAvis.FacadeServiceAvisRemote;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.entity.gererAvis.note.entity.Note;
import rtw.entity.gererAvis.note.entity.NoteBruitExterieur;
import rtw.entity.gererAvis.note.entity.NoteBruitInterieur;
import rtw.entity.gererAvis.note.entity.NoteEtatGeneral;
import rtw.entity.gererAvis.note.entity.NoteHumidite;
import rtw.entity.gererAvis.note.entity.NoteIsolationChaud;
import rtw.entity.gererAvis.note.entity.NoteIsolationFroid;
import rtw.entity.gererAvis.note.entity.NoteLuminosite;
import rtw.entity.gererAvis.note.entity.NoteRelationBailleur;
import rtw.technique.gererAvis.ListeAvisAnnonce;
import rtw.util.gererAvis.Param;

public class NavigationAvisAnnonce extends NavigationAvis {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2827407737772729819L;
	private static Context context;
	private static FacadeServiceAvisRemote facadeServiceAvisRemote;
	
	private ListeAvisAnnonce listeAvisAnnonce;
	
	private String idUtilisateur;
	private String idItem;
	private String bruit_ext;
	private String bruit_int;
	private String isole_froid;
	private String isole_chaud;
	private String humidite;
	private String luminosite;
	private String etat_gene;
	private String relation_bailleur;
	private String commentaire;
	
	private String jsonAvisAnnonce;
	private String jsonItem;
	private String jsonUtilisateur;
	
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
	
	public String creation(){
		//System.out.println("[Methode creation]");
		
		return SUCCESS;
	}
	
	public String modification(){
		
		//System.out.println("[Methode modification]");
		String retour = ERROR;
		init();
		
		//TODO DELETE USED FOR TEST
		Utilisateur utilisateur = new Utilisateur();
		Item item = new Item();
		utilisateur.setIdUtilisateur("1");
		item.setIdItem("1");

		AvisAnnonce avisAnnonce = facadeServiceAvisRemote.rechercheAvisAnnonceById(utilisateur, item);

		if(avisAnnonce != null){
			
			setIdItem(avisAnnonce.getItem().getIdItem());
			setIdUtilisateur(avisAnnonce.getUtilisateur().getIdUtilisateur());
			
			setCommentaire(avisAnnonce.getCommentaire().getContenu());
			
			for (Note note : avisAnnonce.getNotes()) {
				
				if(note instanceof NoteBruitExterieur){
					setBruit_ext(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteBruitInterieur){
					setBruit_int(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteIsolationChaud){
					setIsole_chaud(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteIsolationFroid){
					setIsole_froid(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteHumidite){
					setHumidite(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteLuminosite){
					setLuminosite(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteEtatGeneral){
					setEtat_gene(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteRelationBailleur){
					setRelation_bailleur(String.valueOf(note.getValeur()));
				}
			}
			retour = Param.MODIFICATION;
		}
		//System.out.println("[Fin methode modification]");
		return retour;
	}
	
	public String suppression(){
		//System.out.println("Methode suppression");
		return SUCCESS;
	}
	
	public String affichage(){
		
		//System.out.println("Methode affichage");
		
		init();
		
		//TODO getAnnonce getUtilisateur
		Utilisateur utilisateur = new Utilisateur();
		Item item = new Item();
		
		utilisateur.setIdUtilisateur("1");
		item.setIdItem("1");

		AvisAnnonce avisAnnonce = facadeServiceAvisRemote.rechercheAvisAnnonceById(utilisateur, item);
		
		
		
		if(avisAnnonce != null){
			
			setIdUtilisateur(avisAnnonce.getUtilisateur().getIdUtilisateur());
			setIdItem(avisAnnonce.getItem().getIdItem());
		
			setCommentaire(avisAnnonce.getCommentaire().getContenu());
			
			for (Note note : avisAnnonce.getNotes()) {
				
				if(note instanceof NoteBruitExterieur){
					setBruit_ext(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteBruitInterieur){
					setBruit_int(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteIsolationChaud){
					setIsole_chaud(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteIsolationFroid){
					setIsole_froid(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteHumidite){
					setHumidite(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteLuminosite){
					setLuminosite(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteEtatGeneral){
					setEtat_gene(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteRelationBailleur){
					setRelation_bailleur(String.valueOf(note.getValeur()));
				}
			}
			
			return SUCCESS;
			
		}else{
			return ERROR;
		}
	}
	
	public String listage() {
		
		init();
		
		//TODO getAnnonce getUtilisateur
		Item item = new Item();
		item.setIdItem("1");
		
		ListeAvisAnnonce listeAvisAnnonce = facadeServiceAvisRemote.rechercheListeAvisAnnonce(item);
		
		setListeAvisAnnonce(listeAvisAnnonce);

		return SUCCESS;

	}
	
	public String ajax(){
		
		init();

		Gson gson = new Gson();
		
		Utilisateur utilisateur = gson.fromJson(jsonUtilisateur, Utilisateur.class);
		Item item = gson.fromJson(jsonItem, Item.class);

		AvisAnnonce avisAnnonce = facadeServiceAvisRemote.rechercheAvisAnnonceById(utilisateur, item);
		
		if(avisAnnonce != null){
			
			setCommentaire(avisAnnonce.getCommentaire().getContenu());
			
			for (Note note : avisAnnonce.getNotes()) {
				
				if(note instanceof NoteBruitExterieur){
					setBruit_ext(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteBruitInterieur){
					setBruit_int(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteIsolationChaud){
					setIsole_chaud(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteIsolationFroid){
					setIsole_froid(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteHumidite){
					setHumidite(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteLuminosite){
					setLuminosite(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteEtatGeneral){
					setEtat_gene(String.valueOf(note.getValeur()));
				}else if(note instanceof NoteRelationBailleur){
					setRelation_bailleur(String.valueOf(note.getValeur()));
				}
			}
		}
		
		setJsonAvisAnnonce(gson.toJson(avisAnnonce));
		//System.out.println(getJsonAvisAnnonce());
		
		//System.out.println("[Fin methode ajax]");
		
		return SUCCESS;
	}
	
	/**
	 * @return the bruit_ext
	 */
	public String getBruit_ext() {
		return bruit_ext;
	}


	/**
	 * @param bruit_ext the bruit_ext to set
	 */
	public void setBruit_ext(String bruit_ext) {
		//Sytem.out.println("setBruit_ext");
		this.bruit_ext = bruit_ext;
	}


	/**
	 * @return the bruit_int
	 */
	public String getBruit_int() {
		return bruit_int;
	}


	/**
	 * @param bruit_int the bruit_int to set
	 */
	public void setBruit_int(String bruit_int) {
		//Sytem.out.println("setBruit_int");
		this.bruit_int = bruit_int;
	}


	/**
	 * @return the isole_froid
	 */
	public String getIsole_froid() {
		return isole_froid;
	}


	/**
	 * @param isole_froid the isole_froid to set
	 */
	public void setIsole_froid(String isole_froid) {
		//Sytem.out.println("setIsole_froid");
		this.isole_froid = isole_froid;
	}


	/**
	 * @return the isole_chaud
	 */
	public String getIsole_chaud() {
		return isole_chaud;
	}


	/**
	 * @param isole_chaud the isole_chaud to set
	 */
	public void setIsole_chaud(String isole_chaud) {
		//Sytem.out.println("setIsole_chaud");
		this.isole_chaud = isole_chaud;
	}


	/**
	 * @return the humidite
	 */
	public String getHumidite() {
		return humidite;
	}


	/**
	 * @param humidite the humidite to set
	 */
	public void setHumidite(String humidite) {
		//Sytem.out.println("setHumidite");
		this.humidite = humidite;
	}


	/**
	 * @return the luminosite
	 */
	public String getLuminosite() {
		return luminosite;
	}


	/**
	 * @param luminosite the luminosite to set
	 */
	public void setLuminosite(String luminosite) {
		//Sytem.out.println("setLuminosite");
		this.luminosite = luminosite;
	}


	/**
	 * @return the etat_gene
	 */
	public String getEtat_gene() {
		return etat_gene;
	}


	/**
	 * @param etat_gene the etat_gene to set
	 */
	public void setEtat_gene(String etat_gene) {
		//Sytem.out.println("setEtat_gene");
		this.etat_gene = etat_gene;
	}


	/**
	 * @return the relation_bailleur
	 */
	public String getRelation_bailleur() {
		return relation_bailleur;
	}


	/**
	 * @param relation_bailleur the relation_bailleur to set
	 */
	public void setRelation_bailleur(String relation_bailleur) {
		//Sytem.out.println("setRelation_bailleur");
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
		//Sytem.out.println("setCommentaire");
		this.commentaire = commentaire;
	}

	/**
	 * @return the idUtilisateur
	 */
	public String getIdUtilisateur() {

		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(String idUtilisateur) {
		//Sytem.out.println("setIdUtilisateur");
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return the idItem
	 */
	public String getIdItem() {
		return idItem;
	}

	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(String idItem) {
		//Sytem.out.println("setIdItem");
		this.idItem = idItem;
	}

	public String getJsonItem() {
		return jsonItem;
	}

	public void setJsonItem(String jsonItem) {
		this.jsonItem = jsonItem;
	}

	public String getJsonUtilisateur() {
		return jsonUtilisateur;
	}

	public void setJsonUtilisateur(String jsonUtilisateur) {
		this.jsonUtilisateur = jsonUtilisateur;
	}

	public String getJsonAvisAnnonce() {
		return jsonAvisAnnonce;
	}

	public void setJsonAvisAnnonce(String jsonAvisAnnonce) {
		this.jsonAvisAnnonce = jsonAvisAnnonce;
	}

	public ListeAvisAnnonce getListeAvisAnnonce() {
		return listeAvisAnnonce;
	}

	public void setListeAvisAnnonce(ListeAvisAnnonce listeAvisAnnonce) {
		this.listeAvisAnnonce = listeAvisAnnonce;
	}


}
