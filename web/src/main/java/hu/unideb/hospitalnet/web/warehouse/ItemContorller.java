package hu.unideb.hospitalnet.web.warehouse;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import hu.unideb.hospitalnet.service.ItemManager;
import hu.unideb.hospitalnet.vo.ItemVo;

@ManagedBean(name="itemView")
@ViewScoped
public class ItemContorller implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<ItemVo> selectedItems;
	
	@ManagedProperty("#{itemManager}")
	private ItemManager itemManager;

	public List<ItemVo> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<ItemVo> selectedItems) {
		this.selectedItems = selectedItems;
	}
	
	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setItems(){		
		itemManager.setItemsStatus(selectedItems);
	}
	
}
