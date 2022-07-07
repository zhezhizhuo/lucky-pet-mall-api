package com.lucky.pet.common.core.domain.vo;

public class IndexCountOV {
    private Integer userCount;
    private Integer noticeCount;
    private Integer priceSum;
    private Integer orderCount;

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(Integer noticeCount) {
        this.noticeCount = noticeCount;
    }

    public Integer getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Integer priceSum) {
        this.priceSum = priceSum;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }
}
