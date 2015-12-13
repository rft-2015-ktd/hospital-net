package hu.unideb.hospitalnet.web.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.model.chart.PieChartModel;

import hu.unideb.hospitalnet.service.StatsManager;
import hu.unideb.hospitalnet.service.stats.vo.DiseaseCountVo;
import hu.unideb.hospitalnet.web.statistics.model.StatType;

@ViewScoped
@ManagedBean(name = "statView")
public class StatisticsView implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{statsManager}")
	private StatsManager statsManager;

	private StatType type;

	private List<SelectItem> types;

	private PieChartModel pieModel;

	@PostConstruct
	public void init() {
		types = new ArrayList<>();
		types.add(new SelectItem(StatType.NONE, "Típus kiválasztása"));

		SelectItemGroup groupHospital = new SelectItemGroup("Kórház");
		groupHospital.setSelectItems(
				new SelectItem[] { new SelectItem(StatType.TOP10DISEASES, StatType.TOP10DISEASES.getDisplayName()) });

		types.add(groupHospital);
	}

	public void onTypeSelectChange() {
		if (type != null) {
			switch (type) {
			case TOP10DISEASES:
				pieModel = new PieChartModel();
				for (DiseaseCountVo vo : statsManager.getTop10Diseases()) {
					pieModel.set(vo.getDiseaseName(), vo.getCount());
				}
				pieModel.setTitle(type.getDisplayName());
				pieModel.setLegendPosition("e");
				pieModel.setExtender("pieExtender");
				break;
			default:
				pieModel = null;
				break;
			}
		}
	}

	public StatsManager getStatsManager() {
		return statsManager;
	}

	public void setStatsManager(StatsManager statsManager) {
		this.statsManager = statsManager;
	}

	public StatType getType() {
		return type;
	}

	public void setType(StatType type) {
		this.type = type;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public void setTypes(List<SelectItem> types) {
		this.types = types;
	}

	public List<SelectItem> getTypes() {
		return types;
	}

}
