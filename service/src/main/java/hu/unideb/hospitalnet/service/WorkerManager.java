package hu.unideb.hospitalnet.service;

import java.util.List;

import hu.unideb.hospitalnet.vo.WorkerVo;

public interface WorkerManager {
	public void saveWorker(WorkerVo worker);

	public List<WorkerVo> getWorkers();

	public WorkerVo getWorkerByUsername(String username);
}
