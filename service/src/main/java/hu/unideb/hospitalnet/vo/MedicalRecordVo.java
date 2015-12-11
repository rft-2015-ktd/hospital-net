package hu.unideb.hospitalnet.vo;

import hu.unideb.hospitalnet.core.entity.Patient;

import java.io.Serializable;

public class MedicalRecordVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Long id;

	private PatientVo patient;


	private String diag;


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
