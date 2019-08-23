/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Costumer;
import facade.Facade;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lukas Bjørnvad
 */
@Path("Customer")
public class CustomerResourceResource {

    @Context
    private UriInfo context;
    Facade fac = new Facade();
    /**
     * Creates a new instance of CustomerResourceResource
     */
    public CustomerResourceResource() {
fac.populate();
    }

    /**
     * Retrieves representation of an instance of rest.CustomerResourceResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
       return "Hey there buddy, you lost?";
    }
     @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
        return new Gson().toJson(fac.allCustomers());
    }
     @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandom(){
        List<Costumer> list = fac.allCustomers();
        Random rng = new Random();
        int ran =rng.nextInt(list.size());
        System.out.println(ran);
        return new Gson().toJson(list.get(ran));
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@QueryParam("id") long id){
        return new Gson().toJson(fac.findByID(id));
    }
    /**
     * PUT method for updating or creating an instance of CustomerResourceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
