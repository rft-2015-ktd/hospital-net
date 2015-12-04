package hu.unideb.hospitalnet.service;

import java.util.List;

import hu.unideb.hospitalnet.vo.PatientVo;

public interface PatientManager {
	public void savePatient(PatientVo patient);

	public List<PatientVo> getAll();
}
