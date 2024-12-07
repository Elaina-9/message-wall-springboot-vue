package com.lantu.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiang
 * @since 2024-11-05
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String password;

    private String name;

    private Integer age;

    private String sex;

    private boolean status;

    private String role;

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }
    public String getPassword() {
        return password;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name=" + name +
            ", age=" + age +
            ", sex=" + sex +
                ", status=" + status +
                ", password=" + password +
        "}";
    }
}
