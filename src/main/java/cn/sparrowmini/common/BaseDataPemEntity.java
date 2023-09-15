package cn.sparrowmini.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 基础含数据权限控制的实体
 * 
 * @author fansword
 *
 */

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDataPemEntity extends BaseCommonPropEntity {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "data_permission_token_id")
	private String dataPermissionTokenId;
}
