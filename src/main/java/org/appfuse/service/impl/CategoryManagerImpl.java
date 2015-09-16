package org.appfuse.service.impl;

import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.service.CategoryManager;
import org.appfuse.model.CategoryFirstLevel;
import org.appfuse.model.CategorySecondLevel;
import org.appfuse.model.CategoryUnit;
import org.appfuse.dao.CategoryFirstLevelDao;
import org.appfuse.dao.CategorySecondLevelDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList; 

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

 
@Service("categoryManager")
@WebService(serviceName = "CategoryService")
public class CategoryManagerImpl extends GenericManagerImpl<CategoryFirstLevel, Long> implements CategoryManager {
    CategoryFirstLevelDao categoryOneDao;
    CategorySecondLevelDao categoryTwoDao;
    
    public CategoryManagerImpl() {}
 
    @Autowired
    public CategoryManagerImpl(CategoryFirstLevelDao categoryOneDao, CategorySecondLevelDao categoryTwoDao) {
        super();
        this.categoryOneDao = categoryOneDao;
        this.categoryTwoDao = categoryTwoDao;
    }
 
    @WebMethod
    public Response getAllCategories() {
        List<CategoryFirstLevel> category_one_list = categoryOneDao.getAll();
        List<CategorySecondLevel> category_two_list = categoryTwoDao.getAll();
        
        System.out.println("Category First Level");
        System.out.println(category_one_list);
        System.out.println("Category Second Level");
        System.out.println(category_two_list);
        
        Map<Integer, CategoryUnit> cu_map = new HashMap<Integer, CategoryUnit>();

        for (int i=0; i<category_one_list.size(); i++) {
            CategoryFirstLevel cfl = category_one_list.get(i);
            CategoryUnit cu = new CategoryUnit();
            cu.setCategory_id(cfl.getId());
            cu.setCategory_name(cfl.getName());
            
            ArrayList<CategorySecondLevel> csl_array = new ArrayList<CategorySecondLevel>();
            cu.setSub_category_list(csl_array);
            cu_map.put(cu.getCategory_id(), cu);
        }

        for (int i=0; i<category_two_list.size(); i++) {
            CategorySecondLevel csl = category_two_list.get(i);
            
            CategoryUnit cu = cu_map.get(csl.getFirst_level_id());
            if (cu != null) {
                cu.getSub_category_list().add(csl);                
            }
        }
        
        for (Integer key : cu_map.keySet()) {
            System.out.println("----> " + cu_map.get(key));
        }
        
        JSONArray content = new JSONArray();
        
        for (Integer key : cu_map.keySet()) {
            CategoryUnit cu = cu_map.get(key);
            
            JSONObject jsonCu = new JSONObject();
            try {
                jsonCu.put("category_id", cu.getCategory_id());
                jsonCu.put("category_name",  cu.getCategory_name());
                
                List<CategorySecondLevel> csl_list = cu.getSub_category_list();
                
                JSONArray sub_category_list = new JSONArray();
                for (int j=0; j<csl_list.size(); j++) {
                    CategorySecondLevel csl = csl_list.get(j);
                    
                    JSONObject sub_category = new JSONObject();
                    sub_category.put("sub_category_id",  csl.getId());
                    sub_category.put("sub_category_name",  csl.getName());
                    
                    sub_category_list.put(sub_category);
                }
                
                jsonCu.put("sub_category_list",  sub_category_list);
                content.put(jsonCu);
                
            } catch (JSONException je) {
                String errorMsg = je.getMessage();
                return Response.status(500).entity(errorMsg).build();
            }
        }
        
        return Response.ok(content.toString(), MediaType.APPLICATION_JSON).build();
    }
}
