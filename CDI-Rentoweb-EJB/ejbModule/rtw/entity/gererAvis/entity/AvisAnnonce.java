package rtw.entity.gererAvis.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import rtw.entity.gererAvis.interfaces.IAvisAnnonce;

/**
 * Entity {@link AvisAnnonce} class fille de {@link Avis} contient le commentaire et les notes de l'utilisateur sur une annonce.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
public class AvisAnnonce extends Avis implements IAvisAnnonce {


	@Column(nullable=false)
	Note note;
	@Column(nullable=false)
	Commentaire commentaire;
	
}
