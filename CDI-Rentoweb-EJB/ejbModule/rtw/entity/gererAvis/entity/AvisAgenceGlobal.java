package rtw.entity.gererAvis.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import rtw.entity.gererAvis.interfaces.IAvisGlobal;

/**
 * Entity {@link AvisAgenceGlobal} class fille de {@link AvisGlobal} contient la moyen des notes des avis utilisateur sur une agence.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
public class AvisAgenceGlobal extends AvisGlobal implements IAvisGlobal{


	@Column(nullable=false)
	Note note;
	
}
