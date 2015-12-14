package hu.unideb.hospitalnet.web.statistics;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.PieChartModel;

import hu.unideb.hospitalnet.service.RoleManager;
import hu.unideb.hospitalnet.service.WorkerManager;
import hu.unideb.hospitalnet.vo.WorkerVo;

@ViewScoped
@ManagedBean(name = "doctorStatView")
public class DoctorsWorkView implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{workerManager}")
	private WorkerManager workerManager;

	@ManagedProperty("#{roleManager}")
	private RoleManager roleManager;

	private Date startDate;
	private Date endDate;

	private PieChartModel chartModel;
	private List<WorkerVo> workingWorkers;

	public void show() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (startDate == null || endDate == null || endDate.before(startDate)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba!", "Hibás dátumok!");
			context.addMessage(null, message);
			return;
		}

		int doctorCount = workerManager.getWorkerCountByRole(roleManager.getRoleByName("ROLE_DOCTOR"));
		workingWorkers = workerManager.getWorkersByWorkingDates(getStartOfDay(startDate), getEndOfDay(endDate));

		chartModel = new PieChartModel();
		chartModel.set("Nem dolgozik", doctorCount - workingWorkers.size());
		chartModel.set("Dolgozik", workingWorkers.size());
		chartModel.setTitle("");
		chartModel.setLegendPosition("e");
		chartModel.setExtender("pieExtender");

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Siker!", "Sikeres lekérés!");
		context.addMessage(null, message);

	}

	public Date getEndOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public Date getStartOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public PieChartModel getChartModel() {
		return chartModel;
	}

	public void setChartModel(PieChartModel chartModel) {
		this.chartModel = chartModel;
	}

	public List<WorkerVo> getWorkingWorkers() {
		return workingWorkers;
	}

	public void setWorkingWorkers(List<WorkerVo> workingWorkers) {
		this.workingWorkers = workingWorkers;
	}

}
