package org.appfuse.service;
 
import org.appfuse.service.GenericManager;
import org.appfuse.model.Product;
import org.appfuse.model.SelectedItem;

import org.json.JSONArray;
 
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/commodity/product")
public interface ProductShowManager extends GenericManager<Product, Long> {
 
    @GET
    @Produces("application/json")
    Response getItemsByCategories();
}
