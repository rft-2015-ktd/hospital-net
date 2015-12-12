package hu.unideb.hospitalnet.service;

import java.util.List;

import hu.unideb.hospitalnet.vo.WorkerVo;

public interface WorkerManager {
	public void saveWorker(WorkerVo worker);

	public List<WorkerVo> getWorkers();

	public List<WorkerVo> getWorkers(int page, int pageSize, String sortField, int sortOrder, String filter,
			String filterColumnName);

	public WorkerVo getWorkerByUsername(String username);

	public int getWorkersCount();

	public WorkerVo getWorkerById(Long id);

	public List<WorkerVo> getWorkerByName(String query);
}
