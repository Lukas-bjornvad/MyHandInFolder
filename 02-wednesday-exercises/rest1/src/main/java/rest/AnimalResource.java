/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Lukas Bjørnvad
 */
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;
    LinkedList<Animal> an = new LinkedList<>();
    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
        an.add(new Animal("Dog","Bark",1999));
        an.add(new Animal("Duck","Quack",1989));
        an.add(new Animal("Cat","Meow",1400));
        an.add(new Animal("Cow","Moo",1866));
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
       return "Dog\t, Duck\t, Cat\t, Cow";
    }
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandom(){
        String out="Fail";
        Random rng = new Random();
        int ran =rng.nextInt(3);
        System.out.println(ran);
       
        return new Gson().toJson(an.get(ran));
    }
    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
