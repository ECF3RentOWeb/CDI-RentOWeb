package rtw.entity.gererAgence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AgentImmobilier implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer idAgentImmobilier;
	private String nomAgent;
	private String prenomAgent;
	

}
