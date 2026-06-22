package com.openadmin.job.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.job.domain.SysJob;
import com.openadmin.job.mapper.SysJobMapper;
import com.openadmin.job.service.SysJobService;
import org.springframework.stereotype.Service;
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements SysJobService {}
