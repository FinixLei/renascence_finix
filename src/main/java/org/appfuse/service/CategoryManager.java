package org.appfuse.service;

import org.appfuse.service.GenericManager;
import org.appfuse.model.CategoryFirstLevel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;


@Path("/commodity/category")
public interface CategoryManager extends GenericManager<CategoryFirstLevel, Long> {
 
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response getAllCategories();
}
