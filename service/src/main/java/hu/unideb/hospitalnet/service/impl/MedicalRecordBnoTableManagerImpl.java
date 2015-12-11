package hu.unideb.hospitalnet.service.impl;

import hu.unideb.hospitalnet.core.dao.MedicalRecordBnoTableDao;
import hu.unideb.hospitalnet.service.MedicalRecordBnoTableManager;
import hu.unideb.hospitalnet.service.converter.impl.MedicalRecordBnoTableManagerConverter;
import hu.unideb.hospitalnet.vo.MedicalRecordBnoTableVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("medicalRecordBnoTableManager")
@Transactional(propagation = Propagation.REQUIRED)
public class MedicalRecordBnoTableManagerImpl implements MedicalRecordBnoTableManager{
	
	@Autowired
	private MedicalRecordBnoTableDao medicalRecordBnoTableManager;
	
	private MedicalRecordBnoTableManagerConverter converter = new MedicalRecordBnoTableManagerConverter();

	@Override
	public void save(MedicalRecordBnoTableVo mcrbno) {
		medicalRecordBnoTableManager.save(converter.toEntity(mcrbno));
		
	}

}
