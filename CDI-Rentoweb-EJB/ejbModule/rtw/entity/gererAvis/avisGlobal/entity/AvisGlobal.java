package rtw.entity.gererAvis.avisGlobal.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.interfaces.IAvisGlobal;
import rtw.entity.gererAvis.noteGlobal.entity.NotesGlobal;

/**
 * Entity {@link AvisGlobal} class mere abstraite de {@link AvisGlobalAgence} et {@link AvisGlobalAnnonce}.
 * 
 * @author Aur�lien
 * @version 1
 * @since 13/03/2017
 *
 */
public abstract class AvisGlobal implements IAvisGlobal,Serializable {
	
	/**
	 * TODO
	 * Serial generated by default regenerate it when class complete 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO R�cup�ration d'un utilisateur/Annonce + ID li�
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
		private String idAnnonce;
		
	}
	
	@EmbeddedId
	private IdAvisGlobal idAvisGlobal;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private NotesGlobal notesGlobal;
	
	/*TODO R�cup�ration d'un utilisateur/Annonce
	 * 
	 *private Utilisateur utilisateur;
	 *private Annonce annonce;		
	*/
	
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
		this.idAvisGlobal = idAvisGlobal;
	}
	
	/**
	 * Retourne la notesGlobal de l'avis.
	 * 
	 * @return notesGlobal {@link NotesGlobal}
	 */
	public NotesGlobal getNotesGlobal() {
		return notesGlobal;
	}
	
	/**
	 * Renseigne la notesGlobal de l'avis.
	 * 
	 * @param notesGlobal {@link NotesGlobal}
	 */
	public void setNotesGlobal(NotesGlobal notesGlobal) {
		this.notesGlobal = notesGlobal;
	}
	
}
