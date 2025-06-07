package cn.sparrowmini.common.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseTree<T> extends BaseUuidEntity {
    protected String parentId;
    protected String name;
    protected String code;
    protected String description;
    protected BigDecimal seq;

    @Transient
    protected long childCount;

    @Transient
    protected long level;

    @Transient
    protected boolean expandable;

    @Transient
    protected List<?> children = new ArrayList<>();

    public BaseTree(BaseTree baseTree, long childCount){
//        BeanUtils.copyProperties(baseTree, this);
        this.childCount = childCount;
        if(this.childCount>0){
            expandable=true;
        }
    }
}
