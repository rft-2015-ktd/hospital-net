package hu.unideb.hospitalnet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hu.unideb.hospitalnet.core.dao.MedicalRecordDao;
import hu.unideb.hospitalnet.service.MedicalRecordManager;
import hu.unideb.hospitalnet.service.converter.impl.MedicalRecordConverter;
import hu.unideb.hospitalnet.vo.MedicalRecordVo;


@Service("medicalRecordManager")
@Component
public class MedicalRecordManagerImpl implements MedicalRecordManager{
	
	@Autowired
	MedicalRecordDao medicalRecordDao;
	
	MedicalRecordConverter converter = new MedicalRecordConverter();

	@Override
	public List<MedicalRecordVo> findByPatientId(Long id) {
		return converter.toVo(medicalRecordDao.findByPatientId(id));
		
	}

	@Override
	public MedicalRecordVo save(MedicalRecordVo mcr) {
		return converter.toVo(medicalRecordDao.save(converter.toEntity(mcr)));
	}

}
