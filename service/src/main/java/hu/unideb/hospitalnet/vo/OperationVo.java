package hu.unideb.hospitalnet.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class OperationVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private WorkerVo doctor;

	private PatientVo patient;

	private String operationName;

	Date fromDate;

	Date toDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WorkerVo getDoctor() {
		return doctor;
	}

	public void setDoctor(WorkerVo doctor) {
		this.doctor = doctor;
	}

	public PatientVo getPatient() {
		return patient;
	}

	public void setPatient(PatientVo patient) {
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
