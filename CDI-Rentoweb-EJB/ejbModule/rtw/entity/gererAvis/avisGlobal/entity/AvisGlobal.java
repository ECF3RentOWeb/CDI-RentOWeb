package rtw.entity.gererAvis.avisGlobal.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.interfaces.IAvisGlobal;
import rtw.entity.gererAvis.entityTest.Item;
import rtw.entity.gererAvis.entityTest.Utilisateur;
import rtw.entity.gererAvis.noteGlobal.entity.NoteGlobal;

/**
 * Entity {@link AvisGlobal} class mere abstraite de {@link AvisGlobalAgence} et {@link AvisGlobalAnnonce}.
 * 
 * @author Aur�lien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class AvisGlobal implements IAvisGlobal,Serializable {
	
	/**
	 * TODO
	 * Serial generated by default regenerate it when class complete 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO R�cup�ration d'un utilisateur/Item + ID li�
	 * IdAvisGlobal est un double ID recup�r� des fonctionnalit�e GererSite,GererAnnonce grace a leur service respectif.
	 * 
	 * @author Aur�lien
	 * @version 1
	 * @since 14/03/2017
	 *
	 */
	@Embeddable
	private static class IdAvisGlobal implements Serializable{

		/**
		 * TODO
		 * Serial generated by default regenerate it when class complete 
		 */
		private static final long serialVersionUID = 1L;
		
		private String idUtilisateur;
		private String idItem;
		
		/**
		 * Default construtor
		 */
		@SuppressWarnings("unused")
		public IdAvisGlobal() {
			
		}
		
		/**
		 * Complete constructor 
		 * 
		 * @param idUtilisateur
		 * @param idItem
		 */
		public IdAvisGlobal(String idUtilisateur, String idItem) {
			
			super();
			this.idUtilisateur = idUtilisateur;
			this.idItem = idItem;
			
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
		
		
		public String getIdUtilisateur() {
			return idUtilisateur;
		}
		public void setIdUtilisateur(String idUtilisateur) {
			this.idUtilisateur = idUtilisateur;
		}

		public String getIdItem() {
			return idItem;
		}

		public void setIdAnnonce(String idItem) {
			this.idItem = idItem;
		}
	}
	
	@EmbeddedId
	private IdAvisGlobal idAvisGlobal;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Collection<NoteGlobal> notesGlobal = new ArrayList<NoteGlobal>();
	
	//TODO CascadeType a modifier utiliser que pour test
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private Utilisateur utilisateur;
	
	//TODO CascadeType a modifier utiliser que pour test
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private Item item;		
	
	/**
	 * Default constructor
	 */
	public AvisGlobal(){
		
	}
	
	/**
	 * Constructeur avec ID 
	 * 
	 * @param utilisateur {@link Utilisateur}
	 * @param item {@link Item}
	 */
	public AvisGlobal(Utilisateur utilisateur,Item item){
		
		getId().setIdAnnonce(item.getIdItem());
		getId().setIdUtilisateur(utilisateur.getIdUtilisateur());
		
		setItem(item);
		setUtilisateur(utilisateur);
		
	}
	
	/**
	 * Retourne l'ID de l'avis.
	 * 
	 * @return idAvisGlobal {@link IdAvisGlobal}
	 */
	public IdAvisGlobal getId() {
		return idAvisGlobal;
	}
	
	/**
	 * Renseigne l'ID de l'avis.
	 * 
	 * @param idAvisGlobal {@link IdAvisGlobal}
	 */
	public void setId(IdAvisGlobal idAvisGlobal) {
		this.idAvisGlobal = new IdAvisGlobal(utilisateur.getIdUtilisateur(), item.getIdItem());
	}
	
	/**
	 * Retourne la notesGlobal de l'avis.
	 * 
	 * @return notesGlobal {@link NotesGlobal}
	 */
	public Collection<NoteGlobal> getNotesGlobal() {
		return notesGlobal;
	}
	
	/**
	 * Renseigne la notesGlobal de l'avis.
	 * 
	 * @param notesGlobal {@link NotesGlobal}
	 */
	public void setNotesGlobal(Collection<NoteGlobal> notesGlobal) {
		this.notesGlobal = notesGlobal;
	}

	/**
	 * @return the idAvisGlobal
	 */
	public IdAvisGlobal getIdAvisGlobal() {
		return idAvisGlobal;
	}

	/**
	 * @param idAvisGlobal the idAvisGlobal to set
	 */
	public void setIdAvisGlobal(IdAvisGlobal idAvisGlobal) {
		this.idAvisGlobal = idAvisGlobal;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

}
