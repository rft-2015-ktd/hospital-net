package hu.unideb.hospitalnet.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.hospitalnet.core.dao.ItemDao;
import hu.unideb.hospitalnet.service.ItemManager;
import hu.unideb.hospitalnet.service.converter.impl.ItemConverter;
import hu.unideb.hospitalnet.vo.ItemVo;

@Service("itemManager")
@Transactional(propagation = Propagation.REQUIRED)
public class ItemManagerImpl implements ItemManager, Serializable{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private ItemDao itemDao;
	
	ItemConverter itemConverter = new ItemConverter();
	
	@Override
	public void saveItem(ItemVo item) {
		itemDao.save(itemConverter.toEntity(item));
	}

	@Override
	public void deleteItem(long itemID) {
		itemDao.delete(itemID);
	}

}
