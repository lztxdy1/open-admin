# Open Admin 企业级快速开发框架

这是一个参考若依工程组织方式设计的 **Java 前后端分离、多模块 Maven 工程**。

## 一、工程结构

```text
open-admin-ruoyi-style
├── pom.xml                    # Maven 父工程
├── open-admin-common          # 通用工具、统一返回、异常、登录用户对象
├── open-admin-framework       # 框架核心：拦截器、Token、权限注解、异常处理、基础 Controller
├── open-admin-system          # 系统管理：用户、角色、菜单、部门、岗位、租户、字典、参数、日志
├── open-admin-auth            # 登录认证、退出、当前用户信息
├── open-admin-generator       # 代码生成模块
├── open-admin-job             # 定时任务模块
├── open-admin-file            # 文件管理模块
├── open-admin-message         # 消息中心模块
├── open-admin-plugin          # 插件中心模块
├── open-admin-ai              # AI 助手扩展模块
├── open-admin-server          # 后端启动模块
└── open-admin-ui              # Vue3 前端工程
```

## 二、后端启动

要求：JDK17+、Maven 3.8+

```bash
cd open-admin-server
mvn clean package -DskipTests
java -jar open-admin-server/target/open-admin-server-1.0.0.jar
```

开发时也可以直接启动：

```bash
mvn -pl open-admin-server -am spring-boot:run
```

默认地址：

- 后端接口：http://localhost:8080
- Swagger：http://localhost:8080/swagger-ui/index.html
- H2 控制台：http://localhost:8080/h2-console

默认账号：

```text
admin / admin123
```

## 三、前端启动

要求：Node.js 18+

```bash
cd open-admin-ui
npm install
npm run dev
```

默认地址：

```text
http://localhost:5173
```

## 四、数据库

默认使用 H2 内存数据库，启动即初始化表结构和演示数据。

如需 MySQL，请执行：

```text
open-admin-server/src/main/resources/db/mysql/schema-mysql.sql
open-admin-server/src/main/resources/db/mysql/data-mysql.sql
```

然后启用：

```bash
java -jar open-admin-server/target/open-admin-server-1.0.0.jar --spring.profiles.active=mysql
```

## 五、当前已实现功能

- 前后端分离
- Maven 多模块
- 登录认证
- Token 鉴权
- 当前用户信息
- RBAC 权限注解
- 动态菜单接口
- 用户管理
- 角色管理
- 菜单管理
- 部门管理
- 岗位管理
- 租户管理
- 字典管理
- 参数管理
- 操作日志
- 登录日志
- 文件上传/下载
- 消息中心
- 定时任务配置与手动触发
- 代码生成预览
- 插件中心
- AI 助手扩展接口
- H2 / MySQL 双数据库脚本
- Swagger 接口文档
- Vue3 管理端页面

## 六、和若依结构的对应关系

| 本项目模块 | 类似若依模块 | 说明 |
|---|---|---|
| open-admin-common | ruoyi-common | 通用工具和基础对象 |
| open-admin-framework | ruoyi-framework | Web 框架、权限、拦截器、异常处理 |
| open-admin-system | ruoyi-system | 系统管理业务 |
| open-admin-auth | ruoyi-admin 中认证部分 | 登录认证接口 |
| open-admin-generator | ruoyi-generator | 代码生成 |
| open-admin-job | ruoyi-quartz | 定时任务 |
| open-admin-server | ruoyi-admin | 后端启动入口 |
| open-admin-ui | ruoyi-ui | 前端管理端 |

## 七、说明

本项目是一套可运行的完整脚手架，重点是先把“若依式多模块工程结构 + 核心后台功能”搭起来。工作流、复杂低代码、插件热插拔、多租户独立库、分布式任务等高级能力已保留扩展点，可在后续版本逐步增强。
