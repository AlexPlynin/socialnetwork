package com.newsweaterproject.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {//
        return name();  //стрококвое представление енума(почитать про енумы)
    }
}
