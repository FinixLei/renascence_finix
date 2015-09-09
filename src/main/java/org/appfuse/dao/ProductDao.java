package org.appfuse.dao;

import org.appfuse.model.Product;
import java.util.List;


public interface ProductDao extends GenericDao<Product, Long> {

    public List getSpecifiedItems(); 
    
}
