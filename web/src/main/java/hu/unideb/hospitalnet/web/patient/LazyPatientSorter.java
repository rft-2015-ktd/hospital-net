package hu.unideb.hospitalnet.web.patient;

import hu.unideb.hospitalnet.vo.PatientVo;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

public class LazyPatientSorter implements Comparator<PatientVo> {

	private String sortField;

	private SortOrder sortOrder;

	public LazyPatientSorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(PatientVo car1, PatientVo car2) {
		try {
			Object value1 = PatientVo.class.getField(this.sortField).get(car1);
			Object value2 = PatientVo.class.getField(this.sortField).get(car2);

			int value = ((Comparable) value1).compareTo(value2);

			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
