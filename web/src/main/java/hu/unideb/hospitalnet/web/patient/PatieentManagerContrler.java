package hu.unideb.hospitalnet.web.patient;

import hu.unideb.hospitalnet.service.BnoManager;
import hu.unideb.hospitalnet.service.MedicalRecordBnoTableManager;
import hu.unideb.hospitalnet.service.MedicalRecordManager;
import hu.unideb.hospitalnet.service.PatientManager;
import hu.unideb.hospitalnet.service.ProductManager;
import hu.unideb.hospitalnet.vo.BnoVo;
import hu.unideb.hospitalnet.vo.ItemVo;
import hu.unideb.hospitalnet.vo.MedicalRecordBnoTableVo;
import hu.unideb.hospitalnet.vo.MedicalRecordVo;
import hu.unideb.hospitalnet.vo.PatientVo;
import hu.unideb.hospitalnet.vo.ProductVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
	
	private List<BnoVo> selectedBnos;
	private Collection<String> bnosNames;


	private String name;
	private String ssn;
	private String idNumber;
	private Date dateOfBirth;
	private String diagnostic;
	private Long id;
	
	private List<MedicalRecordVo> medicalRecords;
	
	private ProductVo selectedProduct;
	


	@ManagedProperty("#{patientManager}")
	private PatientManager service;
	
	@ManagedProperty("#{medicalRecordManager}")
	private MedicalRecordManager mcrService;
	
	@ManagedProperty("#{bnoManager}")
	private BnoManager bnoManager;

	
	@ManagedProperty("#{medicalRecordBnoTableManager}")
	private MedicalRecordBnoTableManager medicalRecordBnoTableManager;
	
	
	@ManagedProperty("#{productManager}")
	private ProductManager productManager;
	
	@ManagedProperty("#{lazyProductModel}")
	private LazyDataModel<ProductVo> lazyProductModel;
	
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
		
		MedicalRecordBnoTableVo mcbt = new MedicalRecordBnoTableVo();
		for (BnoVo bno : selectedBnos) {
			mcbt.setBno(bno);
			mcbt.setMcr(selectedMcr);
			medicalRecordBnoTableManager.save(mcbt);
		}
	
		
	}
	

	public void onRowSelect(SelectEvent event) {
		selectedPatient = (PatientVo) event.getObject();
		medicalRecords =  mcrService.findByPatientId(selectedPatient.getId());
		medicalRecords.size();
		
	}
	
	
	
	public void onRowSelectProduct(SelectEvent e) {
		ProductVo pvo = (ProductVo) e.getObject();
		List<ItemVo> activeItems = new ArrayList<>();
		
		if(!pvo.getItems().isEmpty()){
			for(ItemVo item : pvo.getItems()){
				if(item.getStatus().equals("aktív"))
					activeItems.add(item);
			}
			
			pvo.setItems(activeItems);
		}
		selectedProduct = pvo;
	}

	
	public void addBnoToMcr() {
		for (BnoVo string : selectedBnos) {
			diagnostic += " " + string.getKod10();
		}
	}
	
	
	public void dismiss() {
		try {
			selectedPatient.setStatus("elbocsajtva");
			service.savePatient(selectedPatient);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
							"Save: " + selectedPatient.getName()));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Save"));
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
	

	public ProductVo getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(ProductVo selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public LazyDataModel<ProductVo> getLazyProductModel() {
		return lazyProductModel;
	}

	public void setLazyProductModel(LazyDataModel<ProductVo> lazyProductModel) {
		this.lazyProductModel = lazyProductModel;
	}

	public MedicalRecordBnoTableManager getMedicalRecordBnoTableManager() {
		return medicalRecordBnoTableManager;
	}

	public void setMedicalRecordBnoTableManager(
			MedicalRecordBnoTableManager medicalRecordBnoTableManager) {
		this.medicalRecordBnoTableManager = medicalRecordBnoTableManager;
	}

	public List<BnoVo> getSelectedBnos() {
		return selectedBnos;
	}

	public void setSelectedBnos(List<BnoVo> selectedBnos) {
		this.selectedBnos = selectedBnos;
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
		return selectedBnos;
	}

	public void setBnos(List<BnoVo> bnos) {
		this.selectedBnos = bnos;
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
