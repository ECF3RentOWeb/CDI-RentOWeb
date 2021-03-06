package rtw.entity.gererAvis.avis.avisAnnonce.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import rtw.entity.gererAvis.avis.avisAnnonce.interfaces.IAvisAnnonce;
import rtw.entity.gererAvis.avis.entity.Avis;

/**
 * Entity {@link AvisAnnonce} class fille de {@link Avis} contient le commentaire et les notes de l'utilisateur sur une annonce.
 * 
 * @author Aur�lien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
public class AvisAnnonce extends Avis implements IAvisAnnonce,Serializable {

	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = 6042941491663995708L;

}
