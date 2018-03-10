package jettyjersey.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="TM_USERS")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {

	   
	/**
	 * UID
	 */
	private static final long serialVersionUID = 3695627538223549079L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;	
	@Column(name = "NAME")
	private String name;
	

	public UserEntity() {
		super();
	}   
	/**
	 * @return the user id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id the user id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the user name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the user name
	 */
	public void setName(String name) {
		this.name = name;
	}
   
}
