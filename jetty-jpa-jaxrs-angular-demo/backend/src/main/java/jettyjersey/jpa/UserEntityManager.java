package jettyjersey.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

public class UserEntityManager {

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	public UserEntity saveUser(String name) {
		UserEntity userEntity = new UserEntity();
		try {
			entityManager.getTransaction().begin();
			userEntity.setName(name);
			userEntity = entityManager.merge(userEntity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return userEntity;
	}

	@SuppressWarnings("unchecked")
	public List<UserEntity> listUsers() {
		List<UserEntity> userEntitys = null;
		try {
			entityManager.getTransaction().begin();
			userEntitys = (List<UserEntity>) entityManager.createNamedQuery("UserEntity.findAll").getResultList();
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
