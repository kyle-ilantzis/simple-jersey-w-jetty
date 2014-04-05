package simplejersey;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import simplejersey.resources.HelloWorld2Resource;
import simplejersey.resources.HelloWorldResource;

public class App 
{
    public static void main( String[] args ) throws Exception{

        // Our resource configuration for jersey
        ResourceConfig rc = new ResourceConfig(  );
        rc.register( HelloWorldResource.class );
        rc.register( HelloWorld2Resource.class );
        // ADD HERE!
        // rc.register( PeopleResource.class );
        // rc.register( PeoplePurchasesResource.class );
        // ...

        // This container (which is a servlet) will route requests to our resources
        ServletContainer sc = new ServletContainer( rc );

        // To register a servlet instance we need to wrap it in a holder.
        ServletHolder h = new ServletHolder( sc );

        // Jetty server needs some sort of handler to process requests.
        ServletContextHandler sch = new ServletContextHandler();
        // We will take the root path for this application
        sch.setContextPath( "/" );
        // All request that enter this context should go to jersey
        sch.addServlet( h, "/*" );

        // The simplest possibly jetty server
        Server server = new Server(8080);
        // and we add our handler that forwards to jersey
        server.setHandler( sch );
        // run the simplest jetty server
        server.start();
        server.join();
    }
}
