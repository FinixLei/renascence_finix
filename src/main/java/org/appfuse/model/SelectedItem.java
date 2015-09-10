package org.appfuse.model;

// import org.appfuse.model.BaseObject;

import java.math.BigInteger;
import java.math.BigDecimal;
 
 
public class SelectedItem {
    private BigInteger item_id;
    private Integer product_id;
    private String product_name;
    private BigDecimal price;
    private String item_picture;
    
    public BigInteger getItem_id() {
        return item_id;
    }
    
    public void setItem_id(BigInteger item_id) {
        this.item_id = item_id;
    }
    
    public Integer getProduct_id() {
        return product_id;
    }
    
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    
    public String getProduct_name() {
        return product_name;
    }
    
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public String getItem_picture() {
        return item_picture;
    }
    
    public void setItem_picture(String item_picture) {
        this.item_picture = item_picture;
    }

    
    @Override
    public String toString() {
        return "SelectedItem [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
                + ", item_id=" + item_id + ", item_picture=" + item_picture + "]";
    }
    
}
