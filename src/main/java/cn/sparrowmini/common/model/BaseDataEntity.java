package cn.sparrowmini.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 基础资料的基本数据结构
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseDataEntity extends BaseEntity {
    private String name;
    @Id
    private String code;
    private String content;
    private String type;
}
