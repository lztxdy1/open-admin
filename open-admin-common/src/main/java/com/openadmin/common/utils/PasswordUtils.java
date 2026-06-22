package com.openadmin.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordUtils {
    private PasswordUtils() {}
    public static String sha256(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new IllegalStateException("密码加密失败", e);
        }
    }
    public static boolean matches(String raw, String encoded) {
        return sha256(raw).equalsIgnoreCase(encoded);
    }
}
