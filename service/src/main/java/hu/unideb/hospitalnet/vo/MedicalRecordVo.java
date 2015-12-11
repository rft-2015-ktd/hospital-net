package hu.unideb.hospitalnet.vo;

import hu.unideb.hospitalnet.core.entity.Bno;
import hu.unideb.hospitalnet.core.entity.Patient;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class MedicalRecordVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Long id;

	private PatientVo patient;


	private String diag;
	
	private Date date;
	

	private String name;	


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public PatientVo getPatient() {
		return patient;
	}


	public void setPatient(PatientVo patient) {
		this.patient = patient;
	}


	public String getDiag() {
		return diag;
	}


	public void setDiag(String diag) {
		this.diag = diag;
	}
	
	

}
