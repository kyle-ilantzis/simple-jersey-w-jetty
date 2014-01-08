package simplejersey;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import simplejersey.resources.HelloWorldResource;

public class App 
{
    public static void main( String[] args ) throws Exception{

        // Our resource configuration for jersey
        ResourceConfig rc = new ResourceConfig(  );
        rc.register( HelloWorldResource.class );
        // ADD HERE!
        // rc.register( PeopleResource.class );
        // rc.register( PeoplePurchasesResource.class );
        // ...

        // This container (which is a servlet) will route requests to our resources
        ServletContainer sc = new ServletContainer( rc );

        // To register a servlet instance with a ServletHandler we need to wrap the instance
        // in a holder.
        ServletHolder h = new ServletHolder( sc );

        // Jetty server needs a handler to process requests.
        // We use a handler that forwards to servlets
        ServletHandler sh = new ServletHandler();
        // and register an jersey resource config (which is wrapped in a ServletContainer which is wrapped in
        // a ServletHolder)
        sh.addServletWithMapping( h, "/*" );

        // The simplest possibly jetty server
        Server server = new Server(8080);
        // and we add our handler that forwards to jersey
        server.setHandler( sh );
        // run the simplest jetty server
        server.start();
        server.join();
    }
}
