package com.openadmin.framework.security;

import com.openadmin.common.security.SecurityUser;

public class SecurityContextHolder {
    private static final ThreadLocal<SecurityUser> USER = new ThreadLocal<>();
    private SecurityContextHolder() {}
    public static void setUser(SecurityUser user) { USER.set(user); }
    public static SecurityUser getUser() { return USER.get(); }
    public static Long getUserId() { return getUser() == null ? null : getUser().getUserId(); }
    public static String getUsername() { return getUser() == null ? null : getUser().getUsername(); }
    public static void clear() { USER.remove(); }
}
