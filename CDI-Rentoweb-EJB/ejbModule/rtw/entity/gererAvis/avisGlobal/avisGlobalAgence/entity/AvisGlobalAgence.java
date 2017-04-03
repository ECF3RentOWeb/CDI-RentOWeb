package rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import rtw.entity.gererAvis.avisGlobal.entity.AvisGlobal;
import rtw.entity.gererAvis.avisGlobal.interfaces.IAvisGlobal;

/**
 * Entity {@link AvisGlobalAgence} class fille de {@link AvisGlobal} contient la moyen des notes des avis utilisateur sur une agence.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
public class AvisGlobalAgence extends AvisGlobal implements IAvisGlobal,Serializable{

	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = 1083856209533705202L;



	
}
