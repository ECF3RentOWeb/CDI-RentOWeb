package rtw.entity.gererAvis.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import rtw.entity.gererAvis.interfaces.IAvisAnnonceGlobal;

/**
 * Entity {@link AvisAnnonceGlobal} class fille de {@link AvisGlobal} contient la moyen des notes des avis utilisateur sur une annonce.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
public class AvisAnnonceGlobal extends AvisGlobal implements IAvisAnnonceGlobal {

	@Id
	IDAvisAnnonceGlobal idAvisAnnonceGlobal;
	@Column(nullable=false)
	Note note;
	
}
