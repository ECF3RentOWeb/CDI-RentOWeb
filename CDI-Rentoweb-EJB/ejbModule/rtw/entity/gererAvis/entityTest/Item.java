package rtw.entity.gererAvis.entityTest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_test_avis")
public class Item implements Serializable{


	/**
	 * Generated ID, need to be modified if Entity is modified
	 */
	private static final long serialVersionUID = 7895715350691146613L;
	
	@Id
	private String idItem;
	
	public Item() {
		
	}

	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [getIdItem()=" + getIdItem() + "]";
	}
	
}
