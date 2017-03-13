package rtw.entity.gererAvis.entity;

import javax.persistence.Column;

import rtw.entity.gererAvis.interfaces.ICommentaire;

/**
 * Entity {@link Commentaire} contient le commentaire de l'utilisateur.
 * 
 * @author Aurélien
 * @version 1
 * @since 13/03/2017
 *
 */
public class Commentaire implements ICommentaire {

	@Column(length=4000,nullable=false)
	private String content;
	
}
