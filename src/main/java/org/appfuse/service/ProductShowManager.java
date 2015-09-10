package org.appfuse.service;
 
import org.appfuse.service.GenericManager;
import org.appfuse.model.Product;
import org.appfuse.model.SelectedItem;
 
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.List;

@Path("/commodity/product")
public interface ProductShowManager extends GenericManager<Product, Long> {
 
    @GET
    @Produces("application/json")
    List<SelectedItem> getItemsByCategories();
}
