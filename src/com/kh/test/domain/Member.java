package com.kh.test.domain;

import java.io.Serial;

public class Member {
    private String id;
    private String passwd;
    private String name;
    private String email;

    public Member() {}

    public static class Builder{
        private final String id;
        private String passwd;
        private String name;
        private String email;

        public Builder(String id){
            this.id = id;
        }

        public Builder setPasswd(String passwd){
            this.passwd = passwd;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Member build(){
            Member member = new Member();
            member.id = id;
            member.passwd = passwd;
            member.name = name;
            member.email = email;
            return member;
        }
    }
}
