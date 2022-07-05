package com.lucky.pet.common.core.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MemberOv {

    @JsonProperty("id")
    private Long id;

    private int sex;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("avatar")
    private String avatar;

    public MemberOv() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
