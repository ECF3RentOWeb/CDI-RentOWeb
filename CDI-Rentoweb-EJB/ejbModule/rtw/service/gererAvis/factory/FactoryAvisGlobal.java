package rtw.service.gererAvis.factory;

import org.hibernate.collection.internal.PersistentBag;

import rtw.business.gererAvis.BusinessGererAvis;
import rtw.entity.gererAvis.avis.entity.Avis;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAgence.entity.AvisGlobalAgence;
import rtw.entity.gererAvis.avisGlobal.avisGlobalAnnonce.entity.AvisGlobalAnnonce;
import rtw.entity.gererAvis.avisGlobal.entity.AvisGlobal;

/**
 * Factory qui creer des {@link Avis}
 * @author Aurélien Harlé
 * @version 1
 * @since 30/03/2017
 * 
 */
public class FactoryAvisGlobal {

public AvisGlobal getAvisGlobalWithoutPersistentBag(AvisGlobal avisGlobalDao) {
		
		BusinessGererAvis businessGererAvis = new BusinessGererAvis();
		AvisGlobal avisGlobal = null; 
		
		if(avisGlobalDao instanceof AvisGlobalAnnonce){
			avisGlobal = new AvisGlobalAnnonce();
		}else if(avisGlobalDao instanceof AvisGlobalAgence){
			avisGlobal = new AvisGlobalAgence();
		}

		avisGlobal.setId(avisGlobalDao.getUtilisateur(), avisGlobalDao.getItem());

		avisGlobal.setItem(avisGlobalDao.getItem());
		avisGlobal.setUtilisateur(avisGlobalDao.getUtilisateur());
		avisGlobal.setNotes(businessGererAvis.convertNotePersistenceBagToNoteCollection((PersistentBag) avisGlobalDao.getNotes()));
		
		return avisGlobal;
		
	}

}
