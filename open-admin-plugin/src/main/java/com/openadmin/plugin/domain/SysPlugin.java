package com.openadmin.plugin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@TableName("sys_plugin")
public class SysPlugin {
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 插件编码 */
    private String pluginCode;
    /** 插件名称 */
    private String pluginName;
    /** 版本 */
    private String version;
    /** 状态 */
    private Integer status;
    /** 备注 */
    private String remark;
    /** 创建时间 */
    private LocalDateTime createTime;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPluginCode() { return pluginCode; }
    public void setPluginCode(String pluginCode) { this.pluginCode = pluginCode; }
    public String getPluginName() { return pluginName; }
    public void setPluginName(String pluginName) { this.pluginName = pluginName; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }
}
