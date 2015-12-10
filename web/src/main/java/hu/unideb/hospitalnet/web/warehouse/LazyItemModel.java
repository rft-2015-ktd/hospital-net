package hu.unideb.hospitalnet.web.warehouse;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.unideb.hospitalnet.service.ItemManager;
import hu.unideb.hospitalnet.vo.ItemVo;

@Service("lazyItemtModel")
public class LazyItemModel  extends LazyDataModel<ItemVo>{
	
	private static Logger logger = LoggerFactory.getLogger(LazyItemModel.class);
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ItemManager itemManager;
	
	@Override
	public ItemVo getRowData(String rowKey) {
		Long id;

		try {
			id = Long.valueOf(rowKey);
		} catch (NumberFormatException e) {
			logger.warn("Could not parse row key to long!");
			return null;
		}

		return itemManager.getItemById(id);
	}


	@Override
	public Object getRowKey(ItemVo item) {
		return item.getId();
	}

	@Override
	public List<ItemVo> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		String filter = "";
		String filterColumnName = "";
		if (filters.keySet().size() > 0) {
			filter = (String) filters.values().toArray()[0];
			filterColumnName = filters.keySet().iterator().next();
		}
		if (sortField == null) {
			sortField = "name";
		}

		int dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;

		List<ItemVo> items = itemManager.getItems(first / pageSize, pageSize, sortField, dir, filter,
				filterColumnName);
		

		int dataSize = itemManager.getItemsCount();
		setRowCount(dataSize);

		return items;
	}
}
