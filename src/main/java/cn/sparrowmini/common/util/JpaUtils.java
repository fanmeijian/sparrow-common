package cn.sparrowmini.common.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Id;
import java.lang.reflect.Field;
import java.util.Map;

public class JpaUtils {
    final static ObjectMapper objectMapper = new ObjectMapper();

    public static Field findPrimaryKeyField(Class<?> entityClass) {
        Class<?> current = entityClass;
        while (current != null && current != Object.class) {
            for (Field field : current.getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
                    field.setAccessible(true);
                    return field;
                }
            }
            current = current.getSuperclass(); // 向父类递归查找
        }
        throw new IllegalStateException("No @Id or @EmbeddedId field found in class hierarchy of " + entityClass.getName());
    }

    public static Object getPrimaryKeyValue(Object entity) {
        Field pkField = findPrimaryKeyField(entity.getClass());
        try {
            return pkField.get(entity);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot access primary key field", e);
        }
    }

    public static Object convertToPkValue(Object id, Class<?> clazz) {
        Field pkField = findPrimaryKeyField(clazz);
        Object pkValue= null;
        if (id instanceof String || id instanceof Number) {
            // 是简单 ID
            pkValue=id;
        } else if (id instanceof Map) {
            // 是复合主键或复杂结构
            pkValue = objectMapper.convertValue(id, pkField.getType());
        } else {
            throw new IllegalArgumentException("不支持的参数结构");
        }
        return pkValue;
    }

    public static void copyNonNullAndNonPKFields(Object source, Object target) throws IllegalAccessException {
        Field pkField = JpaUtils.findPrimaryKeyField(source.getClass());
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.equals(pkField)) continue; // 跳过主键
            Object value = field.get(source);
            if (value != null) {
                field.set(target, value); // 更新非 null 的字段
            }
        }
    }

}