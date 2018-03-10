package jettyjersey.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

public class RoleEntityManager {

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	public RoleEntity saveRole(String name) {
		RoleEntity roleEntity = new RoleEntity();
		try {
			entityManager.getTransaction().begin();
			roleEntity.setName(name);
			roleEntity = entityManager.merge(roleEntity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return roleEntity;
	}

	@SuppressWarnings("unchecked")
	public List<RoleEntity> listRoles() {
		List<RoleEntity> roleEntitys = null;
		try {
			entityManager.getTransaction().begin();
			roleEntitys = (List<RoleEntity>) entityManager.createNamedQuery("RoleEntity.findAll").getResultList();
			Iterator<RoleEntity> iterator = roleEntitys.iterator();
			while (iterator.hasNext()) {
				RoleEntity roleEntity = (RoleEntity) iterator.next();
				System.out.println(roleEntity.getName());
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return roleEntitys;
	}

	public RoleEntity updateRole(int id, String name) {
		RoleEntity roleEntity = null;
		try {
			entityManager.getTransaction().begin();
			roleEntity = (RoleEntity) entityManager.find(RoleEntity.class, id);
			roleEntity.setName(name);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return roleEntity;
	}

	public void deleteRole(int id) {
		try {
			entityManager.getTransaction().begin();
			RoleEntity roleEntity = (RoleEntity) entityManager.find(RoleEntity.class, id);
			entityManager.remove(roleEntity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

}
