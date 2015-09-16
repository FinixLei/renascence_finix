package org.appfuse.service.impl;
 
import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.dao.ProductDao;
import org.appfuse.model.ItemUnit;
import org.appfuse.model.Product;
import org.appfuse.model.PuUnit;
import org.appfuse.model.PuUnitPriceAscComparator;
import org.appfuse.model.PuUnitPriceDescComparator;
import org.appfuse.model.PuUnitShelftimeAscComparator;
import org.appfuse.model.PuUnitShelftimeDescComparator;
import org.appfuse.service.ProductShowManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
 
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

 
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
        List<PuUnit> origin_list = productDao.getSpecifiedItems(category_1, category_2);
        
        String sortOrder = "DESC";
        if (isDesc == null) {
               isDesc = "false";
        } else if (isDesc.toLowerCase().equals("false")) {
            sortOrder = "ASC"; 
        } else if (isDesc.toLowerCase().equals("true")) {
            sortOrder = "DESC";
        } else {
            sortOrder = "ASC";
        }
        
        if (sortby == null) {
            sortby = "price";
        } else if (sortby.toLowerCase().equals("price")) {
            sortby = "item_price";
        } else if (sortby.toLowerCase().equals("shelf_time")) {
            sortby = "shelf_time";
        } else {
            sortby = "item_price";
        }
        
        Comparator<PuUnit> puc = null;
        if (sortby.equals("item_price") && sortOrder.toUpperCase().equals("DESC")) {
            puc = new PuUnitPriceDescComparator();
        } else if (sortby.equals("item_price") && sortOrder.toUpperCase().equals("ASC")) {
            puc = new PuUnitPriceAscComparator();
        } else if (sortby.equals("shelf_time") && sortOrder.toUpperCase().equals("DESC")) {
            puc = new PuUnitShelftimeDescComparator();
        } else {  // sortby.equals("shelf_time") && sortOrder.toUpperCase().equals("ASC")
            puc = new PuUnitShelftimeAscComparator();
        }
        
        if (puc != null) {
            Collections.sort(origin_list, puc);
        }
        
        int size = origin_list.size();
        for (int i=0; i<size; i++) {
            PuUnit pu = origin_list.get(i); 
            System.out.println(pu.getPu_id() + " ->\n " + pu.getPu_price() 
            + " ->\n " + pu.getPu_shelf_time() 
            + " ->\n" + pu.getItem_list());
        }
        
        boolean has_more = true;
        if (start + amount >= origin_list.size()) {
            has_more = false;
        }
        
        int final_size = Math.min(origin_list.size(), start + amount);
        JSONArray pusArray = new JSONArray();
        
        for (int i=start; i<final_size; i++) {
            try {
                JSONObject jsonPu = new JSONObject();
                PuUnit pu = origin_list.get(i);
                
                jsonPu.put("pu_id", pu.getPu_id());
                jsonPu.put("pu_name", pu.getPu_name());
                jsonPu.put("pu_price",  pu.getPu_price());
                jsonPu.put("pu_desc", (pu.getPu_desc()==null)?"":pu.getPu_desc());
                
                int item_list_size = pu.getItem_list().size();
                JSONArray jsonItemList = new JSONArray();
                
                for (int j=0; j<item_list_size; j++) {
                    ItemUnit itu = pu.getItem_list().get(j);
                    
                    JSONObject jsonItem = new JSONObject();
                    jsonItem.put("item_id",  itu.getItem_id());
                    jsonItem.put("pic_url",  (itu.getPic_url()==null)?"":itu.getPic_url());
                    
                    jsonItemList.put(jsonItem);
                }
                
                jsonPu.put("items",  jsonItemList);
                pusArray.put(jsonPu);
            }
            catch(JSONException je) {
                String errorMsg = je.getMessage();
                System.out.println("JSON Exception: " + errorMsg);
                return Response.status(404).entity(errorMsg).build();
            }
        }
        
        JSONObject content = new JSONObject();
        try {
            content.put("pus",  pusArray);
            content.put("has_more", has_more);
        } catch (JSONException je) {
            String errorMsg = je.getMessage();
            System.out.println("JSON Exception: " + errorMsg);
            return Response.status(404).entity(errorMsg).build();
        }
        
        JSONObject return_body = new JSONObject();
        try {
            return_body.put("code", 200);
            return_body.put("content",  content);
            return_body.put("errorMsg", "");
        } catch (JSONException je) {
            String errorMsg = je.getMessage();
            System.out.println("JSON Exception for constructing return body: " 
                        + je.getMessage());
            return Response.status(404).entity(errorMsg).build();
        }
        
        return Response.ok(return_body.toString(), MediaType.APPLICATION_JSON).build();
    }
}
