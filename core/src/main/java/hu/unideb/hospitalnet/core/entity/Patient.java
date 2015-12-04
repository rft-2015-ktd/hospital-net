package hu.unideb.hospitalnet.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "full_name")
	private String name;

	@Column(name = "ssn")
	private String ssn;

	@Column(name = "id_num")
	private String idNumber;

	@Column(name = "dob")
	private Date dateOfBirth;

	@Column(name = "diagnostic")
	private String diagnostic;

	
	public Patient() {
	}
	
	public Patient(String name, String ssn, String idNumber, Date dateOfBirth,
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
