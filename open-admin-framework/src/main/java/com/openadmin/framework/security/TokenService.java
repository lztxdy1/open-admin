package com.openadmin.framework.security;

import com.openadmin.common.security.SecurityUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {
    private static class TokenInfo {
        private SecurityUser user;
        private LocalDateTime expireAt;
    }
    private final Map<String, TokenInfo> tokenStore = new ConcurrentHashMap<>();

    public String createToken(SecurityUser user) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenInfo info = new TokenInfo();
        info.user = user;
        info.expireAt = LocalDateTime.now().plusHours(12);
        tokenStore.put(token, info);
        return token;
    }
    public SecurityUser getUser(String token) {
        if (token == null || token.isBlank()) return null;
        TokenInfo info = tokenStore.get(token);
        if (info == null) return null;
        if (info.expireAt.isBefore(LocalDateTime.now())) {
            tokenStore.remove(token);
            return null;
        }
        return info.user;
    }
    public void remove(String token) { if (token != null) tokenStore.remove(token); }
}
