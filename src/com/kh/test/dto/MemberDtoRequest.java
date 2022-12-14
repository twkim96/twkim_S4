package com.kh.test.dto;

public class MemberDtoRequest {
    private String id;
    private String passwd;
    private String name;
    private String email;

    public MemberDtoRequest(String id, String passwd, String name, String email) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
