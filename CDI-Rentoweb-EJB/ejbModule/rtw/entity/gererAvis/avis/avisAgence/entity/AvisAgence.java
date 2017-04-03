package rtw.entity.gererAvis.avis.avisAgence.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import rtw.entity.gererAvis.avis.avisAgence.interfaces.IAvisAgence;
import rtw.entity.gererAvis.avis.entity.Avis;

/**
 * Entity {@link AvisAgence} class fille de {@link Avis} contient le commentaire et les notes de l'utilisateur sur une agence.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
public class AvisAgence extends Avis implements IAvisAgence,Serializable{

	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = -5782632067569505772L;
	
	
		
}
