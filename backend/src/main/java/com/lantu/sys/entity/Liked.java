package com.lantu.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiang
 * @since 2024-11-25
 */
public class Liked implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Liked{" +
            "id=" + id +
            ", tag=" + tag +
        "}";
    }
}
