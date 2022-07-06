package com.lucky.pet.common.core.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

/**
 * 用户登录对象
 *
 * @author qgj
 */
@ApiModel(value = "登陆数据模型")
@Component
public class LoginBody
{
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码")
    private String code;

    /**
     * 唯一标识
     */
    @ApiModelProperty(value = "唯一标识")
    private String uuid;

    public LoginBody() {
    }

    public LoginBody(String username, String password, String code, String uuid) {
        this.username = username;
        this.password = password;
        this.code = code;
        this.uuid = uuid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
}
