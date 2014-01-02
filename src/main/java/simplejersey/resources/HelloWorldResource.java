package simplejersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author kilantzis
 */
@Path("")
public class HelloWorldResource {

    @GET
    public String hello() { return "Hello, World!"; }
}