package cn.sparrowmini.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.Set;

/**
 * 文件的基类
 */
@MappedSuperclass
@Audited
public class BaseFile extends BaseOpLog implements Serializable {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private int seq;
    private String path;
    private String name;
    private long size;
    private String hash;
    private String fileName;
    private String type;
    @Column(length = 1000)
    private String url;

    @ElementCollection
    private Set<String> catalog;

    public BaseFile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<String> getCatalog() {
        return catalog;
    }

    public void setCatalog(Set<String> catalog) {
        this.catalog = catalog;
    }
}
