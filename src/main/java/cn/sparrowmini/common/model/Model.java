package cn.sparrowmini.common.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class Model implements Serializable {

    public Model(String id) {
        this.id = id;
    }

    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    private String name;
    private String remark;

    private List<ModelAttribute> modelAttributes;

}
