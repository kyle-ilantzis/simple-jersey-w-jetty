package simplejersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path( "2" )
public class HelloWorld2Resource {

    @GET
    public String hello2() { return "Hello 2, World!"; }
}
