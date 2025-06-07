package cn.sparrowmini.common.model;

import cn.sparrowmini.common.constant.PermissionTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@NoArgsConstructor
public final class ErrMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String field;
    @Enumerated(EnumType.STRING)
    private PermissionTypeEnum type;
    private String msg;

    public ErrMessage(String field, PermissionTypeEnum type, String msg) {
        this.field = field;
        this.type = type;
        this.msg = msg;
    }
}
