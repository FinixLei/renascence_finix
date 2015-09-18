package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.product_list_handler.Product;
import org.appfuse.model.product_list_handler.PuUnit;


public interface ProductDao extends GenericDao<Product, Long> {
    public List<PuUnit> getSpecifiedItems(int category_1, int category_2); 
}
