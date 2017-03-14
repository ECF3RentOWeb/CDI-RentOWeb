package rtw.entity.gererAvis.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import rtw.entity.gererAvis.interfaces.IAvis;

/**
 * Entity {@link Avis} class mere abstraite de {@link AvisAgence} et {@link AvisAnnonce}.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
public abstract class Avis implements IAvis,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Embeddable
	private static class IdAvis implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		
		
		
	}
	
	@EmbeddedId
	private IdAvis id = new IdAvis();
}
