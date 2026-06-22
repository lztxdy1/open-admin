package com.openadmin.auth.controller;

import com.openadmin.auth.domain.LoginRequest;
import com.openadmin.auth.domain.LoginResponse;
import com.openadmin.common.core.ApiResult;
import com.openadmin.common.security.SecurityUser;
import com.openadmin.framework.security.SecurityContextHolder;
import com.openadmin.framework.security.TokenService;
import com.openadmin.system.service.SysUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final SysUserService userService;
    private final TokenService tokenService;
    public AuthController(SysUserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ApiResult<LoginResponse> login(@RequestBody LoginRequest request) {
        SecurityUser user = userService.login(request.getUsername(), request.getPassword());
        String token = tokenService.createToken(user);
        return ApiResult.ok(new LoginResponse(token, user));
    }

    @GetMapping("/me")
    public ApiResult<SecurityUser> me() { return ApiResult.ok(SecurityContextHolder.getUser()); }

    @PostMapping("/logout")
    public ApiResult<Void> logout(@RequestHeader(value = "Authorization", required = false) String authorization) {
        if (authorization != null && authorization.startsWith("Bearer ")) tokenService.remove(authorization.substring(7));
        return ApiResult.ok();
    }
}
