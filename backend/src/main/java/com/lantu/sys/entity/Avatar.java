package com.lantu.sys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiang
 * @since 2024-11-27
 */
public class Avatar implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String filename;

    private LocalDateTime timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Avatar{" +
            "id=" + id +
            ", filename=" + filename +
            ", timestamp=" + timestamp +
        "}";
    }
}
