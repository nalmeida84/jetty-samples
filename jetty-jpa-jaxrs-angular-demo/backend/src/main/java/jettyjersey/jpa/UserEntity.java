package jettyjersey.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="USER")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {

	   
	/**
	 * UID
	 */
	private static final long serialVersionUID = 3695627538223549079L;
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERID")
	private String user;
	@Column(name = "USERPASS")
	private String password;
	@Column(name = "USERNAME")
	private String name;
	

	public UserEntity() {
		super();
	}   
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
