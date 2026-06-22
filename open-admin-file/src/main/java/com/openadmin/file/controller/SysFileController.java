package com.openadmin.file.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.common.core.ApiResult;
import com.openadmin.file.domain.SysFile;
import com.openadmin.file.service.SysFileService;
import com.openadmin.framework.security.SecurityContextHolder;
import com.openadmin.framework.web.BaseCrudController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class SysFileController extends BaseCrudController<SysFile> {
    private final SysFileService service;
    @Value("${open-admin.upload-path:uploads}")
    private String uploadPath;
    public SysFileController(SysFileService service) { this.service = service; }
    @Override
    protected IService<SysFile> service() { return service; }

    @PostMapping("/upload")
    public ApiResult<SysFile> upload(@RequestParam("file") MultipartFile file) throws Exception {
        File dir = new File(uploadPath);
        if (!dir.exists()) dir.mkdirs();
        String ext = file.getOriginalFilename() != null && file.getOriginalFilename().contains(".")
                ? file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.')) : "";
        String fileName = UUID.randomUUID().toString().replace("-", "") + ext;
        File target = new File(dir, fileName);
        file.transferTo(target);
        SysFile sysFile = new SysFile();
        sysFile.setOriginalName(file.getOriginalFilename());
        sysFile.setFileName(fileName);
        sysFile.setFilePath(target.getAbsolutePath());
        sysFile.setContentType(file.getContentType());
        sysFile.setFileSize(file.getSize());
        sysFile.setCreateBy(SecurityContextHolder.getUsername());
        sysFile.setCreateTime(LocalDateTime.now());
        service.save(sysFile);
        return ApiResult.ok(sysFile);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<FileSystemResource> download(@PathVariable Long id) {
        SysFile sysFile = service.getById(id);
        return ResponseEntity.ok(new FileSystemResource(sysFile.getFilePath()));
    }
}
