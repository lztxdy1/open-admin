package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysDictData;
import com.openadmin.system.mapper.SysDictDataMapper;
import com.openadmin.system.service.SysDictDataService;
import org.springframework.stereotype.Service;

@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {}
