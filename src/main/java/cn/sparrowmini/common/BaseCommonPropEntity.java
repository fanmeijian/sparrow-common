package cn.sparrowmini.common;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 含通用字段的实体
 * 
 * @author fansword
 *
 */

@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseCommonPropEntity extends BaseIdEntity {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String stat = "Draft";
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Boolean enabled = true;
}
