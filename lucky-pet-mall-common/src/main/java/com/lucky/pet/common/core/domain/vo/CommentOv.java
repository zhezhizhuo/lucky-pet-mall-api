package com.lucky.pet.common.core.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CommentOv implements Serializable {

            private Integer id;
            private MemberOv member;

            private String tabs;

            private String content;

            private String score;


            private boolean isLike;


            private Integer officialReply;
            private Integer praiseCount;
           @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date createTime;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public MemberOv getMember() {
        return member;
    }

    public void setMember(MemberOv member) {
        this.member = member;
    }

    public String getTabs() {
        return tabs;
    }

    public void setTabs(String tabs) {
        this.tabs = tabs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOfficialReply() {
        return officialReply;
    }

    public void setOfficialReply(Integer officialReply) {
        this.officialReply = officialReply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
