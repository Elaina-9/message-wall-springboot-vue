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
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tag;

    private String content;

    private String id;

    private String nickname;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Review{" +
            "tag=" + tag +
            ", content=" + content +
            ", id=" + id +
            ", nickname=" + nickname +
        "}";
    }
}
