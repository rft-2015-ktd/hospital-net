package hu.unideb.hospitalnet.vo;

import java.io.Serializable;
import java.util.Date;

public class PatientVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;

	private String ssn;

	private String idNumber;

	private Date dateOfBirth;

	private String diagnostic;

	
	public PatientVo() {
	}
	
	public PatientVo(String name, String ssn, String idNumber, Date dateOfBirth,
			String diagnostic) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.idNumber = idNumber;
		this.dateOfBirth = dateOfBirth;
		this.diagnostic = diagnostic;
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

}
