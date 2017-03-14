package rtw.entity.gererAvis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import rtw.entity.gererAvis.interfaces.IAvisAgence;

/**
 * Entity {@link AvisAgence} class fille de {@link Avis} contient le commentaire et les notes de l'utilisateur sur une agence.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
@Entity
public class AvisAgence extends Avis implements IAvisAgence{
	

	@Column(nullable=false)
	Note note;
	@Column(nullable=false)
	Commentaire commentaire;
	
	/**
	 * Default Constructor
	 */
	public AvisAgence(){
		
		
	}
	
	/**
	 * Constructeur complet 
	 * 
	 * @param idAvisAgence {@link IDAvisAgence}
	 * @param note {@link Note}
	 * @param commentaire {@link Commentaire}
	 */
	public AvisAgence(Note note,Commentaire commentaire){
		
		
	}
	
}
