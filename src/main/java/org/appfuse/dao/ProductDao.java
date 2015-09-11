package org.appfuse.dao;

import org.appfuse.model.Product;
import org.json.JSONArray;
import java.util.List;


public interface ProductDao extends GenericDao<Product, Long> {
    public JSONArray getSpecifiedItems(); 
}
