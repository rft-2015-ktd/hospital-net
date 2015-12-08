package hu.unideb.hospitalnet.vo;

import java.io.Serializable;
import java.util.List;

public class ProductVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;

	private String producer;
	
	private String description;

	private String type;
	
	private List<ItemVo> items;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}