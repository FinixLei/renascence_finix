package org.appfuse.model;

import org.appfuse.model.BaseObject;
 
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
 
@Entity 
public class SelectedItem extends BaseObject {
    private Long item_id;
    private Long product_id;
    private String product_name;
    private double price;
    private String item_picture;
    
    @Id
    public Long getItem_id() {
        return item_id;
    }
    
    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }
    
    public Long getProduct_id() {
        return product_id;
    }
    
    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
    
    public String getProduct_name() {
        return product_name;
    }
    
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getItem_picture() {
        return item_picture;
    }
    
    public void setItem_picture(String item_picture) {
        this.item_picture = item_picture;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
        result = prime * result + ((item_picture == null) ? 0 : item_picture.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
        result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SelectedItem other = (SelectedItem) obj;
        if (item_id == null) {
            if (other.item_id != null)
                return false;
        } else if (!item_id.equals(other.item_id))
            return false;
        if (item_picture == null) {
            if (other.item_picture != null)
                return false;
        } else if (!item_picture.equals(other.item_picture))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (product_id == null) {
            if (other.product_id != null)
                return false;
        } else if (!product_id.equals(other.product_id))
            return false;
        if (product_name == null) {
            if (other.product_name != null)
                return false;
        } else if (!product_name.equals(other.product_name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SelectedItem [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
                + ", item_id=" + item_id + ", item_picture=" + item_picture + "]";
    }
    
    
}
