package com.openadmin.generator.controller;

import com.openadmin.common.core.ApiResult;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tool/gen")
public class GeneratorController {
    private final JdbcTemplate jdbcTemplate;
    public GeneratorController(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @GetMapping("/tables")
    public ApiResult<List<Map<String, Object>>> tables() {
        return ApiResult.ok(jdbcTemplate.queryForList("select table_name from information_schema.tables where table_schema = 'PUBLIC' order by table_name"));
    }

    @GetMapping("/preview/{tableName}")
    public ApiResult<String> preview(@PathVariable String tableName) {
        String className = toClassName(tableName);
        String code = "package com.example.demo;\n\npublic class " + className + " {\n    // TODO 根据表 " + tableName + " 生成字段、Mapper、Service、Controller、Vue页面\n}\n";
        return ApiResult.ok(code);
    }

    private String toClassName(String tableName) {
        StringBuilder sb = new StringBuilder();
        for (String s : tableName.split("_")) {
            if (!s.isBlank()) sb.append(s.substring(0,1).toUpperCase()).append(s.substring(1).toLowerCase());
        }
        return sb.toString();
    }
}
