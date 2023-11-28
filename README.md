# sparrow-common

需要先注入emf才可以使用删除日志功能
public EntityManagerBean(EntityManager emf) {
		EntityManagerHelper.entityManagerFactory = emf.getEntityManagerFactory();
	}