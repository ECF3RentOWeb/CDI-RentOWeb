package rtw.beanAction.gererAvis.action;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
import rtw.util.gererAvis.Param;

public class ActionAvisAgence extends ActionAvis {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2827407737772729819L;
	
	private static Context context;
	private static FacadeServiceAvisRemote facadeServiceAvisRemote;
	private String bruit_ext;
	private String bruit_int;
	private String isole_froid;
	private String isole_chaud;
	private String humidite;
	private String luminosite;
	private String etat_gene;
	private String relation_bailleur;
	private String commentaire;
	private String valider;
	
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
		
		System.out.println("Methode execute");
		return SUCCESS;
	}
	
	public String creer() {
		
		init();
		
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
		
		noteBruitExterieur.setValeur(Integer.parseInt(getBruit_ext()));
		noteBruitInterieur.setValeur(Integer.parseInt(getBruit_int()));
		noteIsolationFroid.setValeur(Integer.parseInt(getIsole_froid()));
		noteIsolationChaud.setValeur(Integer.parseInt(getIsole_chaud()));
		noteHumidite.setValeur(Integer.parseInt(getHumidite()));
		noteLuminosite.setValeur(Integer.parseInt(getLuminosite()));
		noteEtatGeneral.setValeur(Integer.parseInt(getEtat_gene()));
		noteRelationBailleur.setValeur(Integer.parseInt(getRelation_bailleur()));
		
		avisAnnonce.getNotes().add(noteBruitExterieur);
		avisAnnonce.getNotes().add(noteBruitInterieur);
		avisAnnonce.getNotes().add(noteIsolationFroid);
		avisAnnonce.getNotes().add(noteIsolationChaud);
		avisAnnonce.getNotes().add(noteHumidite);
		avisAnnonce.getNotes().add(noteLuminosite);
		avisAnnonce.getNotes().add(noteEtatGeneral);
		avisAnnonce.getNotes().add(noteRelationBailleur);
		
		System.out.println("Methode creer");
		boolean retour = facadeServiceAvisRemote.creerAvisAnnonce(avisAnnonce);
		
		if(retour) return SUCCESS;
		else return ERROR;

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
	
	public String modification(){
		
		System.out.println("Methode modification");
		
		Utilisateur utilisateur = new Utilisateur();
		Item item = new Item();
		
		utilisateur.setIdUtilisateur("1");
		item.setIdItem("1");
		
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
			
			return SUCCESS;
			
		}else{
			return ERROR;
		}
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
		this.commentaire = commentaire;
	}

	public String getValider() {
		return valider;
	}

	public void setValider(String valider) {
		this.valider = valider;
	}

}
