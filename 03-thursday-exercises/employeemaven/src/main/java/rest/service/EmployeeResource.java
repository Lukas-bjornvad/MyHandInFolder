package rest.service;

import com.google.gson.Gson;
import dto.EmployeeDTO;
import entities.Employee;
import entities.RenameMe;
import facades.EmployeeFacade;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("employee")
public class EmployeeResource {
 @Context
    private UriInfo context;
    EntityManagerFactory emf; 
    EmployeeFacade facade =  new EmployeeFacade();
public EmployeeResource(){
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
        
        List<Employee> em = facade.getAllEmployees();
        LinkedList<EmployeeDTO> emD = new LinkedList<>();
        for(int i=0; i<em.size(); i++){
            EmployeeDTO addDto = new EmployeeDTO(em.get(i));
            emD.add(addDto);
        }Gson gson = new Gson();
        return  gson.toJson(emD);
    }
     @GET
    @Path("/high")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHighest(){
        
        List<Employee> em = facade.getEmployeesWithHighestSalary();
        LinkedList<EmployeeDTO> emD = new LinkedList<>();
        for(int i=0; i<em.size(); i++){
            EmployeeDTO addDto = new EmployeeDTO(em.get(i));
            emD.add(addDto);
        }Gson gson = new Gson();
        return  gson.toJson(emD);
    }
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getId(@QueryParam("id") int id){
        EmployeeDTO emD = new EmployeeDTO(facade.getEmployeeByID(id));
        Gson gson = new Gson();
        return  gson.toJson(emD);
        
    }
     @GET
   @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(@QueryParam("name") String name){
        EmployeeDTO emD = new EmployeeDTO(facade.getEmployeeByName(name).get(0));
        Gson gson = new Gson();
        return  gson.toJson(emD);        
    }
    
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String demo() {
//        return "{\"msg\":\"succes\"}";
//    }
//
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void create(RenameMe entity) {
//        throw new UnsupportedOperationException();
//    }
//    
//    @PUT
//    @Path("/{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void update(RenameMe entity, @PathParam("id") int id) {
//        throw new UnsupportedOperationException();
//    }
}
