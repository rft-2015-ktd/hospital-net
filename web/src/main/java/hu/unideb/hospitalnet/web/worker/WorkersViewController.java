package hu.unideb.hospitalnet.web.worker;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import hu.unideb.hospitalnet.service.RoleManager;
import hu.unideb.hospitalnet.service.WorkerManager;
import hu.unideb.hospitalnet.vo.RoleVo;
import hu.unideb.hospitalnet.vo.WorkerVo;

@ViewScoped
@ManagedBean(name = "workersView")
public class WorkersViewController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{workerManager}")
	private WorkerManager workerManager;

	@ManagedProperty("#{roleManager}")
	private RoleManager roleManager;

	@ManagedProperty("#{lazyWorkerModel}")
	private LazyDataModel<WorkerVo> lazyWorkerModel;

	private WorkerVo selectedWorker;

	public void onRowSelect(SelectEvent e) {
		selectedWorker = (WorkerVo) e.getObject();
	}

	public String roleView(RoleVo role) {
		return roleManager.nameOfRole(role);
	}

	public void save() {
	}

	public WorkerManager getWorkerManager() {
		return workerManager;
	}

	public void setWorkerManager(WorkerManager workerManager) {
		this.workerManager = workerManager;
	}

	public RoleManager getRoleManager() {
		return roleManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public LazyDataModel<WorkerVo> getLazyWorkerModel() {
		return lazyWorkerModel;
	}

	public void setLazyWorkerModel(LazyDataModel<WorkerVo> lazyWorkerModel) {
		this.lazyWorkerModel = lazyWorkerModel;
	}

	public WorkerVo getSelectedWorker() {
		return selectedWorker;
	}

	public void setSelectedWorker(WorkerVo selectedWorker) {
		this.selectedWorker = selectedWorker;
	}

}
