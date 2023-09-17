package cn.sparrowmini.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.PostRemove;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import cn.sparrowmini.common.model.DeleteLog;
import lombok.extern.slf4j.Slf4j;

/**
 * 因为hibernate的审计日志里，删除日志不含用户信息，因此做一个监听来记录删除人
 * 
 * @author fansword
 *
 */
@Slf4j
public class DeleteLogListener {

	private EntityManagerFactory emf;

	@PostRemove
	void delete(Object object) {
		Field[] fields = object.getClass().getDeclaredFields();
//		log.info("{} {}", fields.length, CurrentUser.get());
		for (Field field : fields) {
			for (Annotation annotation : field.getDeclaredAnnotations()) {
				if (annotation.annotationType().equals(Id.class)
						|| annotation.annotationType().equals(EmbeddedId.class)) {
					try {
						Method method = object.getClass().getMethod("get" + StringUtils.capitalize(field.getName()));

						this.emf = EntityManagerHelper.entityManagerFactory;
						EntityManager entityManager = this.emf.createEntityManager();
						entityManager.getTransaction().begin();
						entityManager.persist(new DeleteLog(object.getClass().getName()));
						entityManager.getTransaction().commit();
						log.info("{}({}) deleted by {}", object.getClass().getName(), method.invoke(object),
								CurrentUser.get());
					} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}

	}
}
