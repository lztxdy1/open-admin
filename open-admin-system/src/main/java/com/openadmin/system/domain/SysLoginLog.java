package com.openadmin.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@TableName("sys_login_log")
public class SysLoginLog {
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 登录账号 */
    private String username;
    /** 登录IP */
    private String ipaddr;
    /** 登录状态 */
    private String status;
    /** 提示消息 */
    private String msg;
    /** 登录时间 */
    private LocalDateTime loginTime;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getIpaddr() { return ipaddr; }
    public void setIpaddr(String ipaddr) { this.ipaddr = ipaddr; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public LocalDateTime getLoginTime() { return loginTime; }
    public void setLoginTime(LocalDateTime loginTime) { this.loginTime = loginTime; }
}
