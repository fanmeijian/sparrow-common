package cn.sparrowmini.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@Audited
@MappedSuperclass
public abstract class BaseState extends BaseOpLog {

    /**
     * 业务状态
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String stat;

    /**
     * 单据的状态
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    protected CommonStateEnum entityStat = CommonStateEnum.Draft;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Boolean enabled = true;

    /**
     * 用于控制本条数据是否隐藏,也就是不显示
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Boolean hidden = false;

}
