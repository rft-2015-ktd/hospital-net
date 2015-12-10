package hu.unideb.hospitalnet.web.warehouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import hu.unideb.hospitalnet.service.ProductManager;
import hu.unideb.hospitalnet.vo.ItemVo;
import hu.unideb.hospitalnet.vo.ProductVo;

@ViewScoped
@ManagedBean(name = "productsView")
public class ProductViewController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{productManager}")
	private ProductManager productManager;
	
	@ManagedProperty("#{lazyProductModel}")
	private LazyDataModel<ProductVo> lazyProductModel;
	
	private ProductVo selectedProduct;
	
	private Long id;
	private String name;
	private String producer;
	private String description;
	private String type;
	private List<ItemVo> items;
	
	public void save() {
		try {
			List<ItemVo> empyItems = new ArrayList<>();
			ProductVo productVo = new ProductVo();
			productVo.setName(name);
			productVo.setProducer(producer);
			productVo.setDescription(description);
			productVo.setType(type);
			productVo.setItems(empyItems);
			productManager.saveProduct(productVo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
							"Save: " + productVo.getName()));
			name = "";
			producer = null;
			description = "";
			type = "";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Save"));
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public void onRowSelect(SelectEvent e) {
		selectedProduct = (ProductVo) e.getObject();
	}

	public ProductVo getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(ProductVo selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public LazyDataModel<ProductVo> getLazyProductModel() {
		return lazyProductModel;
	}

	public void setLazyProductModel(LazyDataModel<ProductVo> lazyProductModel) {
		this.lazyProductModel = lazyProductModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ItemVo> getItems() {
		return items;
	}

	public void setItems(List<ItemVo> items) {
		this.items = items;
	}

	
	

}
