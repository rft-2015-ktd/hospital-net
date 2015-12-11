package hu.unideb.hospitalnet.web.patient;

import hu.unideb.hospitalnet.service.BnoManager;
import hu.unideb.hospitalnet.service.MedicalRecordManager;
import hu.unideb.hospitalnet.service.PatientManager;
import hu.unideb.hospitalnet.vo.BnoVo;
import hu.unideb.hospitalnet.vo.MedicalRecordVo;
import hu.unideb.hospitalnet.vo.PatientVo;
import hu.unideb.hospitalnet.vo.WorkerVo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
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

@ManagedBean(name = "patienmanager")
@ViewScoped
public class PatieentManagerContrler implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	private List<PatientVo> patients;
	private LazyDataModel<PatientVo> lazyModel;
	private LazyDataModel<BnoVo> lazyBnoModel;
	private	 PatientVo selectedPatient;
	private MedicalRecordVo selectedMcr;
	
	private List<BnoVo> bnos;
	private Collection<String> bnosNames;


	private String name;
	private String ssn;
	private String idNumber;
	private Date dateOfBirth;
	private String diagnostic;
	private Long id;
	
	List<MedicalRecordVo> medicalRecords;
	



	@ManagedProperty("#{patientManager}")
	private PatientManager service;
	
	@ManagedProperty("#{medicalRecordManager}")
	private MedicalRecordManager mcrService;
	
	@ManagedProperty("#{bnoManager}")
	private BnoManager bnoManager;

	@PostConstruct
	public void init() {
		diagnostic = " ";

		setLazyModel(new LazyPatientDataModel(service));
		setLazyBnoModel(new BnoLazyDataModel(bnoManager));
	}

	public void mcrUpdate() {
		diagnostic = selectedMcr.getDiag();
	}
	
	public void updateMcr(){
		selectedMcr.setDiag(diagnostic);
		mcrService.save(selectedMcr);
	}
	

	public void onRowSelect(SelectEvent event) {
		selectedPatient = (PatientVo) event.getObject();
		name = selectedPatient.getName();
		dateOfBirth = selectedPatient.getDateOfBirth();
		ssn = selectedPatient.getSsn();
		idNumber = selectedPatient.getIdNumber();
		id = selectedPatient.getId();
		medicalRecords =  mcrService.findByPatientId(selectedPatient.getId());
		medicalRecords.size();
		
	}
	
	
	
	
	

	public LazyDataModel<BnoVo> getLazyBnoModel() {
		return lazyBnoModel;
	}

	public void setLazyBnoModel(LazyDataModel<BnoVo> lazyBnoModel) {
		this.lazyBnoModel = lazyBnoModel;
	}

	public Collection<String> getBnosNames() {
		return bnosNames;
	}

	public void setBnosNames(Collection<String> bnosNames) {
		this.bnosNames = bnosNames;
	}

	public List<BnoVo> getBnos() {
		return bnos;
	}

	public void setBnos(List<BnoVo> bnos) {
		this.bnos = bnos;
	}

	public BnoManager getBnoManager() {
		return bnoManager;
	}

	public void setBnoManager(BnoManager bnoManager) {
		this.bnoManager = bnoManager;
	}

	public MedicalRecordVo getSelectedMcr() {
		return selectedMcr;
	}

	public void setSelectedMcr(MedicalRecordVo selectedMcr) {
		this.selectedMcr = selectedMcr;
	}

	public List<MedicalRecordVo> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecordVo> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public MedicalRecordManager getMcrService() {
		return mcrService;
	}

	public void setMcrService(MedicalRecordManager mcrService) {
		this.mcrService = mcrService;
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

	public PatientVo getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(PatientVo selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	

}