package jettyjersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jettyjersey.jpa.RoleEntity;
import jettyjersey.jpa.RoleEntityManager;
import jettyjersey.jpa.UserEntity;
import jettyjersey.jpa.UserEntityManager;

@Path("/")
public class Resource {
	
	private UserEntityManager userEntityManager = new UserEntityManager();
	private RoleEntityManager roleEntityManager = new RoleEntityManager();

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_HTML)
	public String helloWorld() {
		return "<h2>Hello, world!</h2>";
	}

	/**
	 * Users resources
	 **/

	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserEntity> listUsers() {
		return userEntityManager.listUsers();
	}

	@POST
	@Path("user/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserEntity createUser(@PathParam("name") String name) {
		return userEntityManager.saveUser(name);
	}

	@POST
	@Path("user/{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserEntity updateUser(@PathParam("id") int id, @PathParam("name") String name) {
		return userEntityManager.updateUser(id, name);
	}

	@DELETE
	@Path("user/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") int id) {
		userEntityManager.deleteUser(id);
	}

	/**
	 * Roles resources
	 **/

	@GET
	@Path("roles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoleEntity> listRoles() {
		return roleEntityManager.listRoles();
	}

	@POST
	@Path("role/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RoleEntity createRole(@PathParam("name") String name) {
		return roleEntityManager.saveRole(name);
	}

	@POST
	@Path("role/{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RoleEntity updateRole(@PathParam("id") int id, @PathParam("name") String name) {
		return roleEntityManager.updateRole(id, name);
	}

	@DELETE
	@Path("role/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteRole(@PathParam("id") int id) {
		roleEntityManager.deleteRole(id);
	}
}
