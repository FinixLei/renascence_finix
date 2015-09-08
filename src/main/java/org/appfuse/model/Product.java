package org.appfuse.model;

import org.appfuse.model.BaseObject;
 
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
 
@Entity @Table(name="product")
public class Product extends BaseObject {
    private Long id;
    private String name;
    private int category_1;
    private int category_2;
    private int category_3;
    private String description;
    private byte sku_count;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    @Column(name="name", length=255)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="category_1")
    public int getCategory_1() {
        return category_1;
    }
    
    public void setCategory_1(int category_1) {
        this.category_1 = category_1;
    }
    
    @Column(name="category_2")
    public int getCategory_2() {
        return category_2;
    }
    
    public void setCategory_2(int category_2) {
        this.category_2 = category_2;
    }
    
    @Column(name="category_3")
    public int getCategory_3() {
        return category_3;
    }
    
    public void setCategory_3(int category_3) {
        this.category_3 = category_3;
    }
    
    @Column(name="description", length=1024)
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="sku_count")
    public byte getSku_count() {
        return sku_count;
    }
    
    public void setSku_count(byte sku_count) {
        this.sku_count = sku_count;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + category_1;
        result = prime * result + category_2;
        result = prime * result + category_3;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + sku_count;
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
        Product other = (Product) obj;
        if (category_1 != other.category_1)
            return false;
        if (category_2 != other.category_2)
            return false;
        if (category_3 != other.category_3)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (sku_count != other.sku_count)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category_1=" + category_1 + ", category_2=" + category_2
                + ", category_3=" + category_3 + ", description=" + description + ", sku_count=" + sku_count + "]";
    }
    
}
