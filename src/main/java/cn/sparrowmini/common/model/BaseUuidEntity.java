package cn.sparrowmini.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.envers.Audited;


@Setter
@Getter
@MappedSuperclass
public abstract class BaseUuidEntity extends BaseEntity {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Audited
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String id;

}
