package hu.unideb.hospitalnet.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product  extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "producer")
	private String producer;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany
	@JoinTable(name = "product_items", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<Item> items;

}
