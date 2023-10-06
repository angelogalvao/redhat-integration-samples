package io.github.angelogalvao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class ExampleService {
    
    @Path("/trace")
    @GET
    public String trace(){

        return "invalid!";
    }

}
