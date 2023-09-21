package cn.sparrowmini.common;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class CommonProp extends BaseOpLog {
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String stat = "Draft";
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Boolean enabled = true;
}
