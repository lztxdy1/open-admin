package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysDictType;
import com.openadmin.system.mapper.SysDictTypeMapper;
import com.openadmin.system.service.SysDictTypeService;
import org.springframework.stereotype.Service;

@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {}
