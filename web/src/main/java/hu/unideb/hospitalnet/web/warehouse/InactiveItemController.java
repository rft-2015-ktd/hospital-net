package hu.unideb.hospitalnet.web.warehouse;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			itemManager.setItemsStatus(selectedItems, "elszállítva");
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres elszállítás!", getSuccesMassage()));
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikeres elszállítás!", getErrorMassage()));
		}
	}
	
	public String getSuccesMassage(){
		StringBuilder sb = new StringBuilder();
		
		if(selectedItems.size() > 1){
			sb.append("Elszállított tételek azonosítója: ");
		}
		else{
			sb.append("Elszállított tétel azonosítója: ");
		}
		for(ItemVo ivo : selectedItems){
			sb.append(ivo.getId());
		}
			
		return sb.toString();
	}
	
	public String getErrorMassage(){
		StringBuilder sb = new StringBuilder();
		
		if(selectedItems.size() > 1){
			sb.append("Nem sikerült leselejtezni a következő azonosítójú tételeket: ");
		}
		else{
			sb.append("Nem sikerült leselejtezni a következő azonosítójú tételt: ");
		}
		for(ItemVo ivo : selectedItems){
			sb.append(ivo.getId());
		}
			
		return sb.toString();
	}
	
}

