package cn.sparrowmini.common.model;

import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
public class ModelAttribute implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	ModelAttributeId id;

	private String type;
	private String name;
	private String remark;

	public ModelAttribute(ModelAttributeId id) {
		super();
		this.id = id;
	}

	public ModelAttribute(ModelAttributeId id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public ModelAttribute(String modelId, String attributeId, String type) {
		super();
		this.id = new ModelAttributeId(modelId, attributeId);
		this.type = type;
	}

}
