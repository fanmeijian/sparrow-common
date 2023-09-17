package cn.sparrowmini.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.sparrowmini.common.LoggedUserGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "spr_delete_log")
@Data
@NamedQuery(
name="DeleteLog.findByClassName",
query="SELECT c FROM DeleteLog c WHERE c.className = :className"
)
@NoArgsConstructor
public class DeleteLog implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "id-generator", strategy = "uuid")
	@GeneratedValue(generator = "id-generator")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String id;

	private String className;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", insertable = true, updatable = false)
	private Date opTime;

	@GeneratorType(type = LoggedUserGenerator.class, when = GenerationTime.INSERT)
	@Column(name = "created_by", insertable = true, updatable = false)
	private String opUser;
	
	public DeleteLog(String className) {
		this.className = className;
	}

}
