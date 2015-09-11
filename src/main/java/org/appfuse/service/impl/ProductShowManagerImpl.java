package org.appfuse.service.impl;
 
import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.dao.ProductDao;
import org.appfuse.model.Product;
import org.appfuse.model.SelectedItem;
import org.appfuse.service.ProductShowManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
 
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import org.json.JSONObject;
 
@Service("productShowManager")
@WebService(serviceName = "ProductShowService")
public class ProductShowManagerImpl extends GenericManagerImpl<Product, Long> implements ProductShowManager {
    ProductDao productDao;
 
    public ProductShowManagerImpl() {}
 
    @Autowired
    public ProductShowManagerImpl(ProductDao productDao) {
        super(productDao);
        this.productDao = productDao;
    }
 
    @WebMethod
    public Response getItemsByCategories(
            int category_1,
            int category_2,
            String sortby,
            String isDesc,
            int start,
            int amount) {
        JSONArray jsonArray = productDao.getSpecifiedItems(category_1, category_2, sortby, isDesc);
        
        int size = jsonArray.length();
        for(int i=0; i<size; i++) {
            try {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
            }
            catch(JSONException je) {
                // To do
                System.out.println("JSON Exception: " + je.getMessage());
            }
        }
        
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }
}
