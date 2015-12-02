package hu.unideb.hospitalnet.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "workers")
public class Worker extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name =  "name")
	private String name;
	
	@Column(name = "ssn")
	private String ssn;
	
	@Column(name = "id_num")
	private String idNumber;
	
	@Column(name = "dob")
	private Date dateOfBirth;
	
	@ManyToOne
	@JoinTable(name = "worker_role", joinColumns = {@JoinColumn(name = "worker_id")})
	private Role role;
	
	@OneToMany
	@JoinTable(name = "worker_times")
	private List<TimeTable> timeTables;
	
}
