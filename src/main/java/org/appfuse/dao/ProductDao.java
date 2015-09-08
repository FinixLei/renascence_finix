package org.appfuse.dao;

import org.appfuse.model.Product;


public interface ProductDao extends GenericDao<Product, Long> {

    public int getCategoryOne(Long id);
    
    
}
