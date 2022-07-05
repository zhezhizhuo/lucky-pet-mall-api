package com.lucky.pet.common.core.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 *
 * @author zhizhuo
 */
@ApiModel("注册实体类")
public class RegisterOv implements Serializable {

    @ApiModelProperty(required = true,value = "用户名")
    @NotNull(message =  "用户名不能空")
    @DecimalMin(value = "3",message = "用户名最长度不少于3位")
    private String username;


    @ApiModelProperty(required = true,value = "手机号码")
    @NotNull(message =  "手机号码不能空")
    @Pattern(regexp = "^1[3|4|5|7|8]\\d{9}$",message = "手机号格式不对")
    private String mobile;

    @ApiModelProperty(hidden = true,value = "验证码")
    private String code;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 唯一标识
     */
    @ApiModelProperty(hidden = true,value = "唯一标识")
    private String uuid;
    @ApiModelProperty(required = true,value = "用户昵称")
    @NotNull(message =  "用户昵称不能空")

    private String nick_name;
    @ApiModelProperty(required = true,value = "用户性别（0男 1女 ）")
    @NotNull(message =  "用户性别不能空")
    private Integer sex;
    @NotNull(message =  "密码不能为空")
    @DecimalMin(value = "6",message = "密码最长度不少于6位")
    @ApiModelProperty(required = true,value = "密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
