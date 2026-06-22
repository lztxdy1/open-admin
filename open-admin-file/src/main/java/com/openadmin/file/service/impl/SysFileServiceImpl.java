package com.openadmin.file.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.file.domain.SysFile;
import com.openadmin.file.mapper.SysFileMapper;
import com.openadmin.file.service.SysFileService;
import org.springframework.stereotype.Service;
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {}
