package hu.unideb.hospitalnet.web.statistics;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

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

	private List<StatType> types;

	private PieChartModel pieModel;

	@PostConstruct
	public void init() {
		types = Arrays.asList(StatType.values());
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

	public List<StatType> getTypes() {
		return types;
	}

	public void setTypes(List<StatType> types) {
		this.types = types;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

}
