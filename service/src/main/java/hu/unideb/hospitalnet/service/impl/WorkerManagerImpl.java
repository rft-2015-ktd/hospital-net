package hu.unideb.hospitalnet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.hospitalnet.core.dao.RoleDao;
import hu.unideb.hospitalnet.core.dao.WorkerDao;
import hu.unideb.hospitalnet.service.WorkerManager;
import hu.unideb.hospitalnet.service.converter.impl.WorkerConverter;
import hu.unideb.hospitalnet.vo.WorkerVo;

@Service("workerManager")
@Transactional(propagation = Propagation.REQUIRED)
public class WorkerManagerImpl implements WorkerManager {

	@Autowired
	private WorkerDao workerDao;

	@Autowired
	private RoleDao roleDao;

	WorkerConverter converter = new WorkerConverter();

	@Override
	public void saveWorker(WorkerVo worker) {
		workerDao.save(converter.toEntity(worker));
	}

	@Override
	public List<WorkerVo> getWorkers() {
		return converter.toVo(workerDao.findAll());
	}

	@Override
	public WorkerVo getWorkerByUsername(String username) {
		return converter.toVo(workerDao.findByUsername(username));
	}

}
