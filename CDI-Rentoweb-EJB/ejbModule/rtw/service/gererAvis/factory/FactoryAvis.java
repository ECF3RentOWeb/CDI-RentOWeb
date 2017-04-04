package rtw.service.gererAvis.factory;

import org.hibernate.collection.internal.PersistentBag;

import rtw.business.gererAvis.BusinessGererAvis;
import rtw.entity.gererAvis.avis.avisAgence.entity.AvisAgence;
import rtw.entity.gererAvis.avis.avisAnnonce.entity.AvisAnnonce;
import rtw.entity.gererAvis.avis.entity.Avis;

/**
 * Factory qui creer des {@link Avis}
 * @author Aurélien Harlé
 * @version 1
 * @since 30/03/2017
 * 
 */
public class FactoryAvis {

	public Avis getAvisWithoutPersistentBag(Avis avisDao) {
		
		BusinessGererAvis businessGererAvis = new BusinessGererAvis();
		Avis avis = null; 
		
		if(avisDao instanceof AvisAnnonce){
			avis = new AvisAnnonce();
		}else if(avisDao instanceof AvisAgence){
			avis = new AvisAgence();
		}

		avis.setId(avisDao.getUtilisateur(), avisDao.getItem());
		avis.setCommentaire(avisDao.getCommentaire());
		avis.setItem(avisDao.getItem());
		avis.setUtilisateur(avisDao.getUtilisateur());
		avis.setNotes(businessGererAvis.convertNotePersistenceBagToNoteCollection((PersistentBag) avisDao.getNotes()));
		
		return avis;
		
	}
	
	//TODO getAvis :3

}
