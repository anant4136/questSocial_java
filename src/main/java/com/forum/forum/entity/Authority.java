package com.forum.forum.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }
}
