package cn.sparrowmini.common;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
public abstract class CommonProp extends BaseOpLog {
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String stat = "Draft";
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Boolean enabled = true;
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
