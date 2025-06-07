package cn.sparrowmini.common.model;

import cn.sparrowmini.common.LoggedUserGenerator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Setter
@Getter
@Audited
@MappedSuperclass
public abstract class BaseOpLog {
    @Column(name = "created_date", insertable = true, updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotAudited
    protected Date createdDate; // 创建时间

    @Column(name = "modified_date", insertable = true, updatable = true)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected Date modifiedDate; // 最后更新时间

    @GeneratorType(type = LoggedUserGenerator.class, when = GenerationTime.INSERT)
    @Column(name = "created_by", insertable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotAudited
    protected String createdBy;

    @GeneratorType(type = LoggedUserGenerator.class, when = GenerationTime.ALWAYS)
    @Column(name = "modified_by", insertable = true, updatable = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String modifiedBy;

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
