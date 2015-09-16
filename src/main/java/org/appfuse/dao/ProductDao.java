package org.appfuse.dao;

import java.util.List;
import org.appfuse.model.Product;
import org.appfuse.model.PuUnit;


public interface ProductDao extends GenericDao<Product, Long> {
    public List<PuUnit> getSpecifiedItems(int category_1, int category_2); 
}
