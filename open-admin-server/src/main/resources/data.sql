INSERT INTO sys_tenant(id, tenant_code, tenant_name, contact_user, contact_phone, status, create_by, create_time, deleted) VALUES (1, 'default', '默认租户', '管理员', '13800000000', 1, 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_dept(id, parent_id, ancestors, dept_name, sort, leader, phone, status, create_by, create_time, deleted) VALUES (1, 0, '0', '总公司', 1, '管理员', '13800000000', 1, 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_user(id, username, password, nickname, email, phone, dept_id, tenant_id, status, create_by, create_time, deleted) VALUES (1, 'admin', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', '系统管理员', 'admin@example.com', '13800000000', 1, 1, 1, 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_role(id, role_name, role_key, role_sort, status, data_scope, create_by, create_time, deleted) VALUES (1, '超级管理员', 'admin', 1, 1, 'ALL', 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_user_role(user_id, role_id) VALUES (1, 1);

INSERT INTO sys_menu(id,parent_id,menu_name,menu_type,path,component,perms,icon,sort,visible,status,create_by,create_time,deleted) VALUES
(1,0,'系统管理','M','/system','Layout','','Setting',1,1,1,'system',CURRENT_TIMESTAMP,0),
(2,1,'用户管理','C','/system/user','system/user/index','system:user:list','User',1,1,1,'system',CURRENT_TIMESTAMP,0),
(3,1,'角色管理','C','/system/role','system/role/index','system:role:list','UserFilled',2,1,1,'system',CURRENT_TIMESTAMP,0),
(4,1,'菜单管理','C','/system/menu','system/menu/index','system:menu:list','Menu',3,1,1,'system',CURRENT_TIMESTAMP,0),
(5,1,'部门管理','C','/system/dept','system/dept/index','system:dept:list','OfficeBuilding',4,1,1,'system',CURRENT_TIMESTAMP,0),
(6,1,'岗位管理','C','/system/post','system/post/index','system:post:list','Postcard',5,1,1,'system',CURRENT_TIMESTAMP,0),
(7,1,'租户管理','C','/system/tenant','system/tenant/index','system:tenant:list','House',6,1,1,'system',CURRENT_TIMESTAMP,0),
(8,1,'字典管理','C','/system/dict','system/dict/index','system:dict:list','Tickets',7,1,1,'system',CURRENT_TIMESTAMP,0),
(9,1,'参数管理','C','/system/config','system/config/index','system:config:list','Tools',8,1,1,'system',CURRENT_TIMESTAMP,0),
(10,0,'系统工具','M','/tool','Layout','','Box',2,1,1,'system',CURRENT_TIMESTAMP,0),
(11,10,'代码生成','C','/tool/gen','tool/gen/index','tool:gen:list','DocumentAdd',1,1,1,'system',CURRENT_TIMESTAMP,0),
(12,10,'文件管理','C','/file','file/index','file:list','Folder',2,1,1,'system',CURRENT_TIMESTAMP,0),
(13,0,'扩展中心','M','/extend','Layout','','Connection',3,1,1,'system',CURRENT_TIMESTAMP,0),
(14,13,'消息中心','C','/message','message/index','message:list','Message',1,1,1,'system',CURRENT_TIMESTAMP,0),
(15,13,'任务调度','C','/job','job/index','job:list','Timer',2,1,1,'system',CURRENT_TIMESTAMP,0),
(16,13,'插件中心','C','/plugin','plugin/index','plugin:list','Grid',3,1,1,'system',CURRENT_TIMESTAMP,0),
(17,13,'AI助手','C','/ai','ai/index','ai:chat','ChatDotRound',4,1,1,'system',CURRENT_TIMESTAMP,0),
(18,0,'日志管理','M','/monitor','Layout','','Monitor',4,1,1,'system',CURRENT_TIMESTAMP,0),
(19,18,'操作日志','C','/monitor/operlog','monitor/operlog/index','monitor:operlog:list','List',1,1,1,'system',CURRENT_TIMESTAMP,0),
(20,18,'登录日志','C','/monitor/loginlog','monitor/loginlog/index','monitor:loginlog:list','Key',2,1,1,'system',CURRENT_TIMESTAMP,0);

INSERT INTO sys_role_menu(role_id, menu_id) SELECT 1, id FROM sys_menu;
INSERT INTO sys_post(id, post_code, post_name, post_sort, status, remark, create_by, create_time, deleted) VALUES (1, 'admin', '管理员', 1, 1, '系统内置岗位', 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_dict_type(id, dict_name, dict_type, status, remark, create_by, create_time, deleted) VALUES (1, '系统状态', 'sys_normal_disable', 1, '系统通用状态', 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_dict_data(dict_type, dict_label, dict_value, dict_sort, status, remark, create_by, create_time, deleted) VALUES ('sys_normal_disable', '正常', '1', 1, 1, '', 'system', CURRENT_TIMESTAMP, 0), ('sys_normal_disable', '停用', '0', 2, 1, '', 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_config(id, config_name, config_key, config_value, config_type, remark, create_by, create_time, deleted) VALUES (1, '系统名称', 'sys.name', 'Open Admin', 1, '系统显示名称', 'system', CURRENT_TIMESTAMP, 0);
INSERT INTO sys_message(title, content, receiver, read_flag, create_by, create_time) VALUES ('欢迎使用', '欢迎使用 Open Admin 多模块快速开发框架', 'admin', 0, 'system', CURRENT_TIMESTAMP);
INSERT INTO sys_job(job_name, job_group, cron_expression, invoke_target, status, remark, create_time) VALUES ('示例任务', 'DEFAULT', '0/30 * * * * ?', 'demoTask.run', 1, '手动触发示例', CURRENT_TIMESTAMP);
INSERT INTO sys_plugin(plugin_code, plugin_name, version, status, remark, create_time) VALUES ('file-local', '本地文件存储插件', '1.0.0', 1, '示例插件', CURRENT_TIMESTAMP);
