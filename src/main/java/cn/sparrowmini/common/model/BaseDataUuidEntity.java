package cn.sparrowmini.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

/**
 * 基础资料的基本数据结构
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseDataUuidEntity extends BaseUuidEntity {
    private String name;
    private String code;
    private String content;
    private String type;
}
