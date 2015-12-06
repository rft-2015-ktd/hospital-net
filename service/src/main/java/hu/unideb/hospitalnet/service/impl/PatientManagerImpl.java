package hu.unideb.hospitalnet.service.impl;

import hu.unideb.hospitalnet.core.dao.PatientDao;
import hu.unideb.hospitalnet.core.entity.Patient;
import hu.unideb.hospitalnet.service.PatientManager;
import hu.unideb.hospitalnet.service.converter.impl.PatientConverter;
import hu.unideb.hospitalnet.vo.PatientVo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("patientManager")
@Component
public class PatientManagerImpl implements PatientManager, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PatientDao patientDao;

	PatientConverter converter = new PatientConverter();

	@Override
	public void savePatient(PatientVo patient) {
		patientDao.save(converter.toEntity(patient));

	}

	@Override
	public List<PatientVo> getAll() {
		return converter.toVo(patientDao.findAll());
	}

	@Override
	public List<PatientVo> getPatients(int page, int size, String sortField,
			int sortOrder, String filter, String filterColumnName) {
		Direction dir = sortOrder == 1 ? Sort.Direction.ASC
				: Sort.Direction.DESC;
		PageRequest pageRequest = new PageRequest(page, size, new Sort(
				new org.springframework.data.domain.Sort.Order(dir, sortField)));
		Page<Patient> entities;

		if (filter.length() != 0 && filterColumnName.equals("name")) {
			entities = patientDao.findByNameStartsWith(filter, pageRequest);
		} else {
			entities = patientDao.findAll(pageRequest);
		}
		List<PatientVo> ret = converter.toVo(entities.getContent());

		return ret;
	}

	@Override
	public int getRowNumber() {
		return (int) patientDao.count();
	}

}
