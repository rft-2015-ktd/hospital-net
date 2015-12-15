package hu.unideb.hospitalnet.web.warehouse;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import hu.unideb.hospitalnet.service.ItemManager;
import hu.unideb.hospitalnet.vo.ItemVo;

@ViewScoped
@ManagedBean(name = "inactiveItemView")
public class InactiveItemController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ItemVo selectedItem;
	
	private List<ItemVo> selectedItems;
	
	@ManagedProperty("#{itemManager}")
	private ItemManager itemManager;
	
	@ManagedProperty("#{lazyItemModel}")
	private LazyDataModel<ItemVo> lazyItemModel;

	public LazyDataModel<ItemVo> getLazyItemModel() {
		return lazyItemModel;
	}

	public void setLazyItemModel(LazyDataModel<ItemVo> lazyItemModel) {
		this.lazyItemModel = lazyItemModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
	public void onRowSelect(SelectEvent e) {
		selectedItem = (ItemVo) e.getObject();
	}

	public ItemVo getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(ItemVo selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<ItemVo> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<ItemVo> selectedItems) {
		this.selectedItems = selectedItems;
	}
	
	public void setItemsToInactive(){
		System.out.println("send");
		for(ItemVo ivo : selectedItems)
			System.out.println(ivo.getId());
		itemManager.setItemsStatus(selectedItems, "leselejtezett");
	}
	
}

