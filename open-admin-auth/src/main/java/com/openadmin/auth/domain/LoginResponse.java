package com.openadmin.auth.domain;

import com.openadmin.common.security.SecurityUser;

public class LoginResponse {
    private String token;
    private SecurityUser user;
    public LoginResponse() {}
    public LoginResponse(String token, SecurityUser user) { this.token = token; this.user = user; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public SecurityUser getUser() { return user; }
    public void setUser(SecurityUser user) { this.user = user; }
}
