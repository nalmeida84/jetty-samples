package jettyjersey.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

public class UserEntityManager {

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	public UserEntity saveUser(String user, String password, String name) {
		UserEntity userEntity = new UserEntity();
		try {
			entityManager.getTransaction().begin();
			userEntity.setUser(user);
			userEntity.setName(password);
			userEntity.setName(name);
			userEntity = entityManager.merge(userEntity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return userEntity;
	}
		
	@SuppressWarnings("unchecked")
	public List<UserEntity> listUserEntity() {
		List<UserEntity> userEntitys = null;
	    try {
	      entityManager.getTransaction().begin();
	      userEntitys = (List<UserEntity>) entityManager.createNamedQuery("UserEntity.findAll").getResultList();
	      Iterator<UserEntity> iterator = userEntitys.iterator();
	      while(iterator.hasNext()) {
	        UserEntity user = (UserEntity) iterator.next();
	        System.out.println(user.getName());
	      }
	      entityManager.getTransaction().commit();
	    } catch (Exception e) {
	      entityManager.getTransaction().rollback();
	    }
	    return userEntitys;
	  }

	public UserEntity updateUserEntity(String user, String password, String name) {
		UserEntity userEntity = null;
		try {
			entityManager.getTransaction().begin();
			userEntity = (UserEntity) entityManager.find(UserEntity.class, user);
			userEntity.setPassword(password);
			userEntity.setName(name);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return userEntity;
	}

	public void deleteUserEntity(String user) {
		try {
			entityManager.getTransaction().begin();
			UserEntity userEntity = (UserEntity) entityManager.find(UserEntity.class, user);
			entityManager.remove(userEntity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

}
