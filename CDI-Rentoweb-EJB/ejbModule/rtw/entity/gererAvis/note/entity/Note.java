package rtw.entity.gererAvis.note.entity;

import java.io.Serializable;

import rtw.entity.gererAvis.note.interfaces.INotes;


/**
 * Entity {@link Note} class mere abstraite de TODO
 * 
 * @author Aur�lien
 * @version 1
 * @since 15/03/2017
 *
 */
public abstract class Note implements INotes,Serializable {
	
	/**
	 * TODO
	 * Serial generated by default regenerate it when class complete 
	 */
	private static final long serialVersionUID = 1L;
	
	private int valeur;

	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}