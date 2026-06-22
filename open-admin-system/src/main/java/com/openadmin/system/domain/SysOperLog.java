package com.openadmin.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@TableName("sys_oper_log")
public class SysOperLog {
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 模块标题 */
    private String title;
    /** 业务类型 */
    private String businessType;
    /** 方法名称 */
    private String method;
    /** 请求方式 */
    private String requestMethod;
    /** 操作人员 */
    private String operName;
    /** 操作IP */
    private String operIp;
    /** 请求URL */
    private String operUrl;
    /** 请求参数 */
    private String operParam;
    /** 返回参数 */
    private String jsonResult;
    /** 操作状态 */
    private Integer status;
    /** 错误消息 */
    private String errorMsg;
    /** 操作时间 */
    private LocalDateTime operTime;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public String getRequestMethod() { return requestMethod; }
    public void setRequestMethod(String requestMethod) { this.requestMethod = requestMethod; }
    public String getOperName() { return operName; }
    public void setOperName(String operName) { this.operName = operName; }
    public String getOperIp() { return operIp; }
    public void setOperIp(String operIp) { this.operIp = operIp; }
    public String getOperUrl() { return operUrl; }
    public void setOperUrl(String operUrl) { this.operUrl = operUrl; }
    public String getOperParam() { return operParam; }
    public void setOperParam(String operParam) { this.operParam = operParam; }
    public String getJsonResult() { return jsonResult; }
    public void setJsonResult(String jsonResult) { this.jsonResult = jsonResult; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getErrorMsg() { return errorMsg; }
    public void setErrorMsg(String errorMsg) { this.errorMsg = errorMsg; }
    public LocalDateTime getOperTime() { return operTime; }
    public void setOperTime(LocalDateTime operTime) { this.operTime = operTime; }
}
