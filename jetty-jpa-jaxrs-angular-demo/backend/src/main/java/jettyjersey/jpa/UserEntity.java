package jettyjersey.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "TM_USERS")
public class UserEntity implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 3695627538223549079L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "SEQ_GEN", allocationSize = 1)
	@Column(name = "ID")
	private int id;

	@Basic(optional = false)
	@Size(max = 100)
	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TM_USERS_TM_ROLES", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private List<RoleEntity> roleList;

	public UserEntity() {
		super();
		roleList = new ArrayList<RoleEntity>();
	}

	/**
	 * @return the user id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the user id
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
	 * @param name
	 *            the user name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the role list of the user
	 */
	public List<RoleEntity> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleEntity
	 *            role to add to the user
	 */
	public void addRole(RoleEntity roleEntity) {

		roleList.add(roleEntity);
	}

	/**
	 * @param roleList
	 *            roles to set to the user
	 */
	public void setRoleList(List<RoleEntity> roleList) {
		this.roleList = roleList;
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
		UserEntity other = (UserEntity) obj;
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
		return "UserEntity [id=" + id + ", name=" + name + ", roleList=" + roleList + "]";
	}

}
