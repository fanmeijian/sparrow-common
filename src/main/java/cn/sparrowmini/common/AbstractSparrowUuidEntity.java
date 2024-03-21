package cn.sparrowmini.common;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
public abstract class AbstractSparrowUuidEntity extends AbstractSparrowEntity {

	@Id
	@GenericGenerator(name = "id-generator", strategy = "uuid")
	@GeneratedValue(generator = "id-generator")
	@Audited
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String id;
	
	

	public AbstractSparrowUuidEntity(String id) {
		super();
		this.id = id;
	}

	public AbstractSparrowUuidEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
