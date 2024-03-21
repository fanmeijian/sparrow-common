package cn.sparrowmini.common;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
@EntityListeners({ DeleteLogListener.class })
public abstract class AbstractSparrowEntity extends BaseOpLog {

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@NotAudited
	protected String modelName = this.getClass().getName();

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Column(name = "data_permission_token_id")
	private String dataPermissionTokenId;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDataPermissionTokenId() {
		return dataPermissionTokenId;
	}

	public void setDataPermissionTokenId(String dataPermissionTokenId) {
		this.dataPermissionTokenId = dataPermissionTokenId;
	}

}
