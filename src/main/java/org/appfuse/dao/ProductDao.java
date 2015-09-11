package org.appfuse.dao;

import org.appfuse.model.Product;
import org.json.JSONArray;
import java.util.List;


public interface ProductDao extends GenericDao<Product, Long> {
    public JSONArray getSpecifiedItems(int category_1, int category_2, String sortby, String isDesc); 
}
