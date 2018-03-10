package jettyjersey.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "TM_ROLES")
public class RoleEntity implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 2917645776676902215L;

	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(generator = "role_seq")
	@SequenceGenerator(name = "role_seq", sequenceName = "SEQ_GEN", allocationSize = 1)
	@Column(name = "ID")
	private int id;

	@Basic(optional = false)
	@NotNull
	@Size(max = 100)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleEntity other = (RoleEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", name=" + name + "]";
	}

}
