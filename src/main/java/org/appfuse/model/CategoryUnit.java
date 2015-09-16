package org.appfuse.model;

import java.util.ArrayList;

public class CategoryUnit {
    private Integer category_id;
    private String category_name;
    private ArrayList<CategorySecondLevel> sub_category_list;
    
    
    public Integer getCategory_id() {
        return category_id;
    }
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public ArrayList<CategorySecondLevel> getSub_category_list() {
        return sub_category_list;
    }
    public void setSub_category_list(ArrayList<CategorySecondLevel> sub_category_list) {
        this.sub_category_list = sub_category_list;
    }
    @Override
    public String toString() {
        return "CategoryUnit [category_id=" + category_id + ", category_name=" + category_name + ", sub_category_list="
                + sub_category_list + "]";
    }
    
}
