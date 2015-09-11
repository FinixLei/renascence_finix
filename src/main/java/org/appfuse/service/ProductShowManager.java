package org.appfuse.service;
 
import org.appfuse.service.GenericManager;
import org.appfuse.model.Product;
import org.appfuse.model.SelectedItem;

import org.json.JSONArray;
 
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/commodity/product")
public interface ProductShowManager extends GenericManager<Product, Long> {
 
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response getItemsByCategories(
            @QueryParam("category_1") int category_1,
            @QueryParam("category_2") int category_2,
            @QueryParam("sortby") String sortby,
            @QueryParam("start") int start,
            @QueryParam("amount") int amount);
}
