package hu.unideb.hospitalnet.web.worker;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import hu.unideb.hospitalnet.service.RoleManager;
import hu.unideb.hospitalnet.service.WorkerManager;
import hu.unideb.hospitalnet.vo.RoleVo;
import hu.unideb.hospitalnet.vo.WorkerVo;

/**
 * Controller for the login site.
 */
@Component
@ViewScoped
@ManagedBean(name = "registrationController")
public class WorkerRegistrationController implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(WorkerRegistrationController.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	private WorkerManager workerManager;

	@Autowired
	private RoleManager roleManager;

	private String userName = "";

	private String password = "";

	private String password2 = "";

	private String ssn = "";

	private String selectedRole = "";

	private String idNumber;

	private String fullName;

	private Date dob;

	public void addUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			WorkerVo worker = validateInputAndCreateVo();
			if (worker != null) {
				workerManager.saveWorker(worker);
				context.getExternalContext().getFlash().setKeepMessages(true);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						"Registration sucessful you can log in now"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
		}

	}

	/**
	 * Validates input.
	 * 
	 * @return null if validation failed, the WorkerVo otherwise
	 */
	private WorkerVo validateInputAndCreateVo() {
		FacesContext context = FacesContext.getCurrentInstance();

		Boolean isValid = true;

		if (!validateDate()) {
			isValid = false;
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Hibás dátum"));
		}
		if (!password.equals(getPassword2())) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "A megadott jelszó nem egyezik!"));
			isValid = false;
		}
		if (workerManager.getWorkerByUsername(userName) != null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Már létezik ilyen nevű felhasználó!"));
			isValid = false;
		}
		if (selectedRole.equals("")) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Munkakör kiválasztása kötelező!"));
			isValid = false;
		}
		if (ssn.equals("")) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "TAJ szám megadása kötelező!"));
			isValid = false;
		}
		if (idNumber.equals("")) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Személyi szám megadása kötelező!"));
			isValid = false;
		}
		if (fullName.equals("")) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "A dolgozó nevének megadása kötelező!"));
			isValid = false;
		}

		if (!isValid) {
			return null;
		}

		WorkerVo worker = new WorkerVo();

		String finalRole = "ROLE_" + selectedRole;
		logger.debug("Final role name: " + finalRole);
		RoleVo roleVo = roleManager.getRoleByName(finalRole);

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encPassword = bCryptPasswordEncoder.encode(password);

		worker.setPassword(encPassword);
		worker.setUsername(userName);
		worker.setRole(roleVo);
		worker.setSsn(ssn);
		worker.setIdNumber(idNumber);
		worker.setDateOfBirth(dob);
		worker.setName(fullName);

		return worker;

	}

	private Boolean validateDate() {
		Date now = new Date();

		if (now.before(dob)) {
			return false;
		}

		return true;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(String selectedRole) {
		this.selectedRole = selectedRole;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
