package hu.unideb.hospitalnet.web.patient;

import hu.unideb.hospitalnet.service.PatientManager;
import hu.unideb.hospitalnet.vo.PatientVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;


@ManagedBean(name = "patientreg")
@ViewScoped
public class PatientRegistation implements Serializable {

	private static final long serialVersionUID = 1L;

	List<PatientVo> patients;
	LazyDataModel<PatientVo> lazyModel;

	private String name;
	private String ssn;
	private String idNumber;
	private Date dateOfBirth;
	private String diagnostic;

	@ManagedProperty("#{patientManager}")
	private PatientManager service;

	@PostConstruct
	public void init() {
		setLazyModel(new LazyPatientDataModel(service));
	}

	public void save() {
		try {
			PatientVo patientVo = new PatientVo();
			patientVo.setName(name);
			patientVo.setDateOfBirth(dateOfBirth);
			patientVo.setDiagnostic(diagnostic);
			patientVo.setIdNumber(idNumber);
			patientVo.setSsn(ssn);
			patientVo.setStatus("aktív");
			service.savePatient(patientVo);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
							"Save: " + patientVo.getName()));
			name = "";
			dateOfBirth = null;
			ssn = "";
			idNumber = "";
			diagnostic = "";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Save"));
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	 public void onRowSelect(SelectEvent event) {
	        FacesMessage msg = new FacesMessage("Car Selected", ((PatientVo) event.getObject()).getName());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	public LazyDataModel<PatientVo> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<PatientVo> lazyModel) {
		this.lazyModel = lazyModel;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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
