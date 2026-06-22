package com.openadmin.ai.controller;

import com.openadmin.common.core.ApiResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiAssistantController {
    @PostMapping("/chat")
    public ApiResult<Map<String, Object>> chat(@RequestBody Map<String, Object> body) {
        Object prompt = body.getOrDefault("prompt", "");
        return ApiResult.ok(Map.of(
                "model", "local-or-remote-model-placeholder",
                "answer", "AI扩展接口已打通。你可以在此处接入 OpenAI、通义、千问本地模型或企业私有模型。当前输入：" + prompt
        ));
    }
}
