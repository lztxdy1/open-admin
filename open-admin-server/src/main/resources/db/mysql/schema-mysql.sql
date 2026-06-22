DROP TABLE IF EXISTS sys_role_menu;
DROP TABLE IF EXISTS sys_user_role;
DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_menu;
DROP TABLE IF EXISTS sys_dept;
DROP TABLE IF EXISTS sys_post;
DROP TABLE IF EXISTS sys_tenant;
DROP TABLE IF EXISTS sys_dict_type;
DROP TABLE IF EXISTS sys_dict_data;
DROP TABLE IF EXISTS sys_config;
DROP TABLE IF EXISTS sys_oper_log;
DROP TABLE IF EXISTS sys_login_log;
DROP TABLE IF EXISTS sys_file;
DROP TABLE IF EXISTS sys_message;
DROP TABLE IF EXISTS sys_job;
DROP TABLE IF EXISTS sys_plugin;

CREATE TABLE sys_user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  password VARCHAR(128) NOT NULL,
  nickname VARCHAR(64),
  email VARCHAR(128),
  phone VARCHAR(32),
  dept_id BIGINT,
  tenant_id BIGINT,
  status INT DEFAULT 1,
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(64), role_key VARCHAR(64), role_sort INT, status INT DEFAULT 1, data_scope VARCHAR(32),
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_menu (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  parent_id BIGINT DEFAULT 0, menu_name VARCHAR(64), menu_type VARCHAR(8), path VARCHAR(128), component VARCHAR(128), perms VARCHAR(128), icon VARCHAR(64), sort INT, visible INT DEFAULT 1, status INT DEFAULT 1,
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_dept (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  parent_id BIGINT DEFAULT 0, ancestors VARCHAR(255), dept_name VARCHAR(64), sort INT, leader VARCHAR(64), phone VARCHAR(32), status INT DEFAULT 1,
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_post (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  post_code VARCHAR(64), post_name VARCHAR(64), post_sort INT, status INT DEFAULT 1, remark VARCHAR(255),
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_tenant (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  tenant_code VARCHAR(64), tenant_name VARCHAR(64), contact_user VARCHAR(64), contact_phone VARCHAR(32), status INT DEFAULT 1, expire_time TIMESTAMP,
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_dict_type (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  dict_name VARCHAR(64), dict_type VARCHAR(64), status INT DEFAULT 1, remark VARCHAR(255),
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_dict_data (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  dict_type VARCHAR(64), dict_label VARCHAR(64), dict_value VARCHAR(64), dict_sort INT, status INT DEFAULT 1, remark VARCHAR(255),
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_config (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  config_name VARCHAR(64), config_key VARCHAR(128), config_value VARCHAR(512), config_type INT DEFAULT 0, remark VARCHAR(255),
  create_by VARCHAR(64), create_time TIMESTAMP, update_by VARCHAR(64), update_time TIMESTAMP, deleted INT DEFAULT 0
);
CREATE TABLE sys_oper_log (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(64), business_type VARCHAR(64), method VARCHAR(255), request_method VARCHAR(16), oper_name VARCHAR(64), oper_ip VARCHAR(64), oper_url VARCHAR(255), oper_param TEXT, json_result TEXT, status INT, error_msg TEXT, oper_time TIMESTAMP
);
CREATE TABLE sys_login_log (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(64), ipaddr VARCHAR(64), status VARCHAR(16), msg VARCHAR(255), login_time TIMESTAMP
);
CREATE TABLE sys_user_role (id BIGINT AUTO_INCREMENT PRIMARY KEY, user_id BIGINT, role_id BIGINT);
CREATE TABLE sys_role_menu (id BIGINT AUTO_INCREMENT PRIMARY KEY, role_id BIGINT, menu_id BIGINT);
CREATE TABLE sys_file (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  original_name VARCHAR(255), file_name VARCHAR(255), file_path VARCHAR(512), content_type VARCHAR(128), file_size BIGINT, create_by VARCHAR(64), create_time TIMESTAMP
);
CREATE TABLE sys_message (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(128), content TEXT, receiver VARCHAR(64), read_flag INT DEFAULT 0, create_by VARCHAR(64), create_time TIMESTAMP
);
CREATE TABLE sys_job (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  job_name VARCHAR(64), job_group VARCHAR(64), cron_expression VARCHAR(64), invoke_target VARCHAR(255), status INT DEFAULT 1, remark VARCHAR(255), create_time TIMESTAMP
);
CREATE TABLE sys_plugin (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  plugin_code VARCHAR(64), plugin_name VARCHAR(64), version VARCHAR(32), status INT DEFAULT 0, remark VARCHAR(255), create_time TIMESTAMP
);
