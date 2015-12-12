package hu.unideb.hospitalnet.service;

import java.util.List;

import hu.unideb.hospitalnet.vo.OperationVo;
import hu.unideb.hospitalnet.vo.PatientVo;

public interface OperationManager {

	public OperationVo save(OperationVo operation);

	public List<OperationVo> getPatients(int i, int pageSize, String sortField,
			int dir, String filter, String filterColumnName);

	public int getRowNumber();

	public String getUsername();

	public List<OperationVo> getAll();

	public void setUsername(String username);

}
