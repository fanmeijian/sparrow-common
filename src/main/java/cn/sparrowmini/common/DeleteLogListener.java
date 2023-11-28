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

import org.apache.commons.lang3.StringUtils;

import cn.sparrowmini.common.model.DeleteLog;

/**
 * 因为hibernate的审计日志里，删除日志不含用户信息，因此做一个监听来记录删除人
 * 
 * @author fansword
 *
 */
public class DeleteLogListener {

	private EntityManagerFactory emf;

	@PostRemove
	void delete(Object object) {
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			for (Annotation annotation : field.getDeclaredAnnotations()) {
				if (annotation.annotationType().equals(Id.class)
						|| annotation.annotationType().equals(EmbeddedId.class)) {
					try {
						Method method = object.getClass().getMethod("get" + StringUtils.capitalize(field.getName()));

						this.emf = EntityManagerHelper.entityManagerFactory;
						String pkValue = method.invoke(object).toString();
						EntityManager entityManager = this.emf.createEntityManager();
						entityManager.getTransaction().begin();
						entityManager.persist(new DeleteLog(object.getClass().getName(),pkValue));
						entityManager.getTransaction().commit();
						System.out.println(String.join(" ", object.getClass().getName(), pkValue, "deleted by ",
								CurrentUser.get()));

					} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

	}
}
