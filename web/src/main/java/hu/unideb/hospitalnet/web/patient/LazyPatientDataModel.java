package hu.unideb.hospitalnet.web.patient;

import hu.unideb.hospitalnet.service.PatientManager;
import hu.unideb.hospitalnet.vo.PatientVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

public class LazyPatientDataModel extends LazyDataModel<PatientVo> {
	
    private List<PatientVo> datasource;
    

    
    public LazyPatientDataModel(PatientManager service) {
        this.datasource = service.getAll();
    }
     
    @Override
    public PatientVo getRowData(String rowKey) {
        for(PatientVo car : datasource) {
            if(car.getId().equals(rowKey))
                return car;
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(PatientVo car) {
        return car.getId();
    }
 
    @Override
    public List<PatientVo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<PatientVo> data = new ArrayList<>();
 
        //filter
        for(PatientVo car : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(car.getClass().getField(filterProperty).get(car));
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(car);
            }
        }
 
        //sort
        if(sortField != null) {
            Collections.sort(data, new LazyPatientSorter(sortField, sortOrder));
        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }

}
