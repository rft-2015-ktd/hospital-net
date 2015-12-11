package hu.unideb.hospitalnet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.hospitalnet.core.dao.BnoDao;
import hu.unideb.hospitalnet.service.BnoManager;
import hu.unideb.hospitalnet.service.converter.impl.BnoConverter;
import hu.unideb.hospitalnet.vo.BnoVo;

@Service("bnoManager")
@Transactional(propagation = Propagation.REQUIRED)
public class BnoManagerImpl implements BnoManager {

	@Autowired
	BnoDao bnoDao;
	
	BnoConverter converter = new BnoConverter();
	
	@Override
	public List<BnoVo> getAll() {

		return converter.toVo(bnoDao.findAll());
	}

}
