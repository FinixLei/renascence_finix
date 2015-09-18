package org.appfuse.model.product_list_handler;

import org.appfuse.model.BaseObject;
 
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
 
@Entity 
@Table(name="product")
public class Product extends BaseObject {
    private Integer id;
    private String name;
    private int category_first_level_id;
    private int category_second_level_id;
    private String description;
    private byte sku_count;
    
    private static final long serialVersionUID = 534638596;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="name", length=255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_first_level_id() {
        return category_first_level_id;
    }

    public void setCategory_first_level_id(int category_first_level_id) {
        this.category_first_level_id = category_first_level_id;
    }

    public int getCategory_second_level_id() {
        return category_second_level_id;
    }

    public void setCategory_second_level_id(int category_second_level_id) {
        this.category_second_level_id = category_second_level_id;
    }

    @Column(name="description", length=1024)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
        result = prime * result + category_first_level_id;
        result = prime * result + category_second_level_id;
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
        if (category_first_level_id != other.category_first_level_id)
            return false;
        if (category_second_level_id != other.category_second_level_id)
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
        return "Product [id=" + id + ", name=" + name + ", category_first_level_id=" + category_first_level_id
                + ", category_second_level_id=" + category_second_level_id + ", description=" + description
                + ", sku_count=" + sku_count + "]";
    }

}
