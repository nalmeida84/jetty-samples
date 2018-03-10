package jettyjersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jettyjersey.jpa.UserEntity;
import jettyjersey.jpa.UserEntityManager;

@Path("/rest")
public class Resource {

	// https://www.acando.no/thedailypassion/200555/a-rest-service-with-jetty-and-jersey
	// https://www.javatips.net/blog/hibernate-jpa-with-h2-database
	// https://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.jpt.doc.user%2Ftask_create_new_project.htm

	UserEntityManager userEntityManager = new UserEntityManager();

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Hello, world!";
	}

	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserEntity> listUsers() {
		return userEntityManager.listUserEntity();
	}

	@GET
	@Path("user/{user}/{name}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserEntity createUser(@PathParam("user") String user, @PathParam("password") String password, @PathParam("name") String name) {
		return userEntityManager.saveUser(user, password, name);
	}
	
}
