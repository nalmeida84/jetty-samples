package jettyjersey;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {

	public static void main(String[] args) {

		ResourceConfig config = new ResourceConfig();
		config.packages("jettyjersey");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(4040);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		// Create the ResourceHandler. It is the object that will actually handle the request for a given file. It is
    // a Jetty Handler object so it is suitable for chaining with other handlers as you will see in other examples.
    ResourceHandler resource_handler = new ResourceHandler();

    // Configure the ResourceHandler. Setting the resource base indicates where the files should be served out of.
    // In this example it is the current directory but it can be configured to anything that the jvm has access to.
    resource_handler.setDirectoriesListed(true);
    resource_handler.setWelcomeFiles(new String[]{ "index.html" });
    resource_handler.setResourceBase("frontend/app");

    // Add the ResourceHandler to the server.
    HandlerList handlers = new HandlerList();
    handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
    server.setHandler(handlers);
		
		try {
			server.start();
			server.join();			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			server.destroy();
		}

	}

}
