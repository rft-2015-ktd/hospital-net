package hu.unideb.hospitalnet.service.impl;

import hu.unideb.hospitalnet.core.dao.PatientDao;
import hu.unideb.hospitalnet.service.PatientManager;
import hu.unideb.hospitalnet.service.converter.impl.PatientConverter;
import hu.unideb.hospitalnet.vo.PatientVo;

import org.springframework.beans.factory.annotation.Autowired;

public class PatientManagerImpl implements PatientManager {
	
	@Autowired
	private PatientDao patientDao;
	
	PatientConverter converter = new PatientConverter();

	@Override
	public void savePatient(PatientVo patient) {
		patientDao.save(converter.toEntity(patient));
		
	}

}
