package hu.unideb.hospitalnet.service;

import hu.unideb.hospitalnet.vo.ItemVo;


public interface ItemManager {
	
	public void saveItem(ItemVo item);

	public void deleteItem(long itemID);


}
