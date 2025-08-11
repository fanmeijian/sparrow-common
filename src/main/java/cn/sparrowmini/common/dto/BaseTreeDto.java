package cn.sparrowmini.common.dto;

import cn.sparrowmini.common.model.BaseTree;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link BaseTree}
 */
@Value
public class BaseTreeDto implements Serializable {
    String id;
    String parentId;
    String name;
    String code;
    String catalogId;
    Boolean includeAllChildren;
    String description;
    BigDecimal seq;
}