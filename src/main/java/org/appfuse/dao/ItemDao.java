package org.appfuse.dao;

import org.appfuse.model.Item;


public interface ItemDao extends GenericDao<Item, Long> {

    public double getPrice(Long id);
    
}
