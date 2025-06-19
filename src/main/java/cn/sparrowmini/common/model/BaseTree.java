package cn.sparrowmini.common.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseTree extends BaseUuidEntity {
    protected String parentId;
    protected String name;
    protected String code;
    protected String catalogId;

    /**
     * 当勾选这个选项, 则默认包含所有的child,包括以后新增的
     */
    protected boolean includeAllChildren = false;
    protected String description;
    protected BigDecimal seq=BigDecimal.ZERO;

    @Transient
    protected long childCount;

    @Transient
    protected long level;

    @Transient
    protected boolean expandable;

    public boolean isExpandable() {
        return childCount>0;
    }

    @Transient
    protected List<Object> children = new ArrayList<>();

    public BaseTree(BaseTree baseTree, long childCount){
//        BeanUtils.copyProperties(baseTree, this);
        this.childCount = childCount;
        if(this.childCount>0){
            expandable=true;
        }
    }
}
