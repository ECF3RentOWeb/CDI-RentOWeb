package rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.interfaces.IAvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.entity.AvisGlobal;

/**
 * Entity {@link AvisGlobalAnnonce} class fille de {@link AvisGlobal} contient la moyen des notes des avis utilisateur sur une annonce.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
public class AvisGlobalAnnonce extends AvisGlobal implements IAvisGlobalAnnonce,Serializable {

	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = -8127901739507995143L;



	
}
