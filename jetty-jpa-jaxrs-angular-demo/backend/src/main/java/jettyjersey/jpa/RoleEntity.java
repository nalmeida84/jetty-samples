package jettyjersey.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "TM_ROLES")
@NamedQuery(name = "RoleEntity.findAll", query = "SELECT r FROM RoleEntity r")
public class RoleEntity implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 2917645776676902215L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;

	public RoleEntity() {
		super();
	}

	/**
	 * @return the role id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the role id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the role name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the role name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
