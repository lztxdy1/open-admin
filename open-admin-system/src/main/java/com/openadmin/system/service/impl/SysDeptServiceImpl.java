package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysDept;
import com.openadmin.system.mapper.SysDeptMapper;
import com.openadmin.system.service.SysDeptService;
import org.springframework.stereotype.Service;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {}
