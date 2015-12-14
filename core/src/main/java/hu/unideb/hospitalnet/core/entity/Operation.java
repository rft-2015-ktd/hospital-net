package hu.unideb.hospitalnet.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity = Worker.class)
	Worker worker;
	
	@ManyToOne(targetEntity = Patient.class)
	Patient patient;
	
	@Column(name = "operation_name",nullable=false)
	String operationName;
	
	@Column(name = "from_date",nullable=false)
	Date fromDate;
	
	@Column(name = "to_date",nullable=false)
	Date toDate;

	public Worker getDoctor() {
		return worker;
	}

	public void setDoctor(Worker doctor) {
		this.worker = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	
	
	
	

}
