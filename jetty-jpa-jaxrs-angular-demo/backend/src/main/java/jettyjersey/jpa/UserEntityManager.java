package jettyjersey.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserEntityManager {

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	public UserEntity saveUser(String name) {
		return this.saveUser(name, 1);
	}

	public UserEntity saveUser(String name, int roleId) {
		UserEntity userEntity = new UserEntity();
		RoleEntity roleEntity = null;
		try {
			entityManager.getTransaction().begin();
			roleEntity = (RoleEntity) entityManager.find(RoleEntity.class, roleId);
			System.out.println(roleEntity.getName());
			userEntity.setName(name);
			userEntity.addRole(roleEntity);
			userEntity = entityManager.merge(userEntity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return userEntity;
	}

	public List<UserEntity> listUsers() {
		List<UserEntity> userEntitys = null;
		try {
			entityManager.getTransaction().begin();
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
			Root<UserEntity> rootUsers = cq.from(UserEntity.class);
			CriteriaQuery<UserEntity> cqRoles = cq.select(rootUsers);
			TypedQuery<UserEntity> tq = entityManager.createQuery(cqRoles);
			userEntitys = tq.getResultList();
			Iterator<UserEntity> iterator = userEntitys.iterator();
			while (iterator.hasNext()) {
				UserEntity userEntity = (UserEntity) iterator.next();
				System.out.println(userEntity.getName());
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return userEntitys;
	}

	public UserEntity getUser(int id) {
		UserEntity userEntity = null;
		try {
			entityManager.getTransaction().begin();
			userEntity = (UserEntity) entityManager.find(UserEntity.class, id);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return userEntity;
	}

	public UserEntity updateUser(int id, String name) {
		UserEntity userEntity = null;
		try {
			entityManager.getTransaction().begin();
			userEntity = (UserEntity) entityManager.find(UserEntity.class, id);
			userEntity.setName(name);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return userEntity;
	}

	public void deleteUser(int id) {
		try {
			entityManager.getTransaction().begin();
			UserEntity userEntity = (UserEntity) entityManager.find(UserEntity.class, id);
			entityManager.remove(userEntity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

}
