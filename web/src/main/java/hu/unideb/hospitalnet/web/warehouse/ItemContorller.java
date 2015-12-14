package hu.unideb.hospitalnet.web.warehouse;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.hospitalnet.service.ItemManager;
import hu.unideb.hospitalnet.vo.ItemVo;

@ManagedBean(name="itemView")
@ViewScoped
public class ItemContorller implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<ItemVo> selectedItems;
	
	private ItemManager itemManager;

	public List<ItemVo> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<ItemVo> selectedItems) {
		this.selectedItems = selectedItems;
	}
	
	public void setItems(){
		System.out.println(selectedItems.size());
		
		for(ItemVo item : selectedItems){
			//itemManager.updateItem("leselejtezett", item.getId());
			System.out.println(item.getId());
		}
	}
	
}
