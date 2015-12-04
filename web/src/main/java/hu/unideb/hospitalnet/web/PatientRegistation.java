package hu.unideb.hospitalnet.web;

import hu.unideb.hospitalnet.service.PatientManager;
import hu.unideb.hospitalnet.vo.PatientVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
@ManagedBean(name = "patientreg")
@ViewScoped
public class PatientRegistation implements Serializable {

	private static final long serialVersionUID = 1L;

	List<PatientVo> patients;

	private String name;
	private String ssn;
	private String idNumber;
	private String dateOfBirth;
	private String diagnostic;

	@ManagedProperty("#{patientManager}")
	private PatientManager service;
	


	public void save() {
		try {
			PatientVo patientVo = new PatientVo();
			patientVo.setName(name);
			patientVo.setDateOfBirth(new Date());
			patientVo.setDiagnostic(diagnostic);
			patientVo.setIdNumber(idNumber);
			patientVo.setSsn(ssn);
			service.savePatient(patientVo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
							"Save: " + patientVo.getName()));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Save"));
			e.getMessage();
			e.printStackTrace();
		}
	}
	

	public List<PatientVo> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientVo> patients) {
		this.patients = patients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public PatientManager getService() {
		return service;
	}

	public void setService(PatientManager service) {
		this.service = service;
	}
	
	
}
