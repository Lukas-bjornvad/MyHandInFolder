package rest.service;

import com.google.gson.Gson;
import dto.CustomerDTO;
import entities.BankCustomer;
import facades.BankFacade;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("bankcustomer")
public class BankCustomerResource {



    EntityManagerFactory emf; 
    BankFacade facade =  new BankFacade();

    public BankCustomerResource() {
        facade.populate();
    }
    
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
        
        List<BankCustomer> em = facade.getAllBankCustomers();
        Gson gson = new Gson();
        return  gson.toJson(em);
    }
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getId(@QueryParam("id") int id){
        
        Gson gson = new Gson();
        return  gson.toJson(facade.getCustomerByID(id));
        
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }
    
}
