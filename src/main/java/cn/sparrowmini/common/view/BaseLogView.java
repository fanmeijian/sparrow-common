package cn.sparrowmini.common.view;

import java.util.Date;

/**
 * 用于自定义entity graph
 */
public interface BaseLogView {
    Date getCreatedDate();
    Date getModifiedDate();
    String getCreatedBy();
    String getModifiedBy();
}
