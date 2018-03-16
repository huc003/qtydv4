package com.qtyd.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserReward implements Serializable {
    private Integer id;

    private Integer userId;

    private BigDecimal money;

    private Byte type;

    private Byte isUse;

    private Integer timeout;

    private Integer addtime;

    private String username;

    private Integer recommendedId;

    private Integer usetime;

    private Integer tenderId;

    private Integer borrowId;

    private String rewardNo;

    private Integer utenderId;

    private Integer uborrowId;

    private Byte rewardStyle;

    private String rewardName;

    private Byte useTogether;

    private String weixinId;

    private String borrowLimit;

    private Boolean newhandLimit;

    private Boolean fristInvestLimit;

    private BigDecimal moneyLimit;

    private String specialBorrowId;

    private String specialRemark;

    private Byte sign;

    private Integer borrowDays;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getAddtime() {
        return addtime;
    }

    public void setAddtime(Integer addtime) {
        this.addtime = addtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getRecommendedId() {
        return recommendedId;
    }

    public void setRecommendedId(Integer recommendedId) {
        this.recommendedId = recommendedId;
    }

    public Integer getUsetime() {
        return usetime;
    }

    public void setUsetime(Integer usetime) {
        this.usetime = usetime;
    }

    public Integer getTenderId() {
        return tenderId;
    }

    public void setTenderId(Integer tenderId) {
        this.tenderId = tenderId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getRewardNo() {
        return rewardNo;
    }

    public void setRewardNo(String rewardNo) {
        this.rewardNo = rewardNo == null ? null : rewardNo.trim();
    }

    public Integer getUtenderId() {
        return utenderId;
    }

    public void setUtenderId(Integer utenderId) {
        this.utenderId = utenderId;
    }

    public Integer getUborrowId() {
        return uborrowId;
    }

    public void setUborrowId(Integer uborrowId) {
        this.uborrowId = uborrowId;
    }

    public Byte getRewardStyle() {
        return rewardStyle;
    }

    public void setRewardStyle(Byte rewardStyle) {
        this.rewardStyle = rewardStyle;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName == null ? null : rewardName.trim();
    }

    public Byte getUseTogether() {
        return useTogether;
    }

    public void setUseTogether(Byte useTogether) {
        this.useTogether = useTogether;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId == null ? null : weixinId.trim();
    }

    public String getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(String borrowLimit) {
        this.borrowLimit = borrowLimit == null ? null : borrowLimit.trim();
    }

    public Boolean getNewhandLimit() {
        return newhandLimit;
    }

    public void setNewhandLimit(Boolean newhandLimit) {
        this.newhandLimit = newhandLimit;
    }

    public Boolean getFristInvestLimit() {
        return fristInvestLimit;
    }

    public void setFristInvestLimit(Boolean fristInvestLimit) {
        this.fristInvestLimit = fristInvestLimit;
    }

    public BigDecimal getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(BigDecimal moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public String getSpecialBorrowId() {
        return specialBorrowId;
    }

    public void setSpecialBorrowId(String specialBorrowId) {
        this.specialBorrowId = specialBorrowId == null ? null : specialBorrowId.trim();
    }

    public String getSpecialRemark() {
        return specialRemark;
    }

    public void setSpecialRemark(String specialRemark) {
        this.specialRemark = specialRemark == null ? null : specialRemark.trim();
    }

    public Byte getSign() {
        return sign;
    }

    public void setSign(Byte sign) {
        this.sign = sign;
    }

    public Integer getBorrowDays() {
        return borrowDays;
    }

    public void setBorrowDays(Integer borrowDays) {
        this.borrowDays = borrowDays;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserReward other = (UserReward) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIsUse() == null ? other.getIsUse() == null : this.getIsUse().equals(other.getIsUse()))
            && (this.getTimeout() == null ? other.getTimeout() == null : this.getTimeout().equals(other.getTimeout()))
            && (this.getAddtime() == null ? other.getAddtime() == null : this.getAddtime().equals(other.getAddtime()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getRecommendedId() == null ? other.getRecommendedId() == null : this.getRecommendedId().equals(other.getRecommendedId()))
            && (this.getUsetime() == null ? other.getUsetime() == null : this.getUsetime().equals(other.getUsetime()))
            && (this.getTenderId() == null ? other.getTenderId() == null : this.getTenderId().equals(other.getTenderId()))
            && (this.getBorrowId() == null ? other.getBorrowId() == null : this.getBorrowId().equals(other.getBorrowId()))
            && (this.getRewardNo() == null ? other.getRewardNo() == null : this.getRewardNo().equals(other.getRewardNo()))
            && (this.getUtenderId() == null ? other.getUtenderId() == null : this.getUtenderId().equals(other.getUtenderId()))
            && (this.getUborrowId() == null ? other.getUborrowId() == null : this.getUborrowId().equals(other.getUborrowId()))
            && (this.getRewardStyle() == null ? other.getRewardStyle() == null : this.getRewardStyle().equals(other.getRewardStyle()))
            && (this.getRewardName() == null ? other.getRewardName() == null : this.getRewardName().equals(other.getRewardName()))
            && (this.getUseTogether() == null ? other.getUseTogether() == null : this.getUseTogether().equals(other.getUseTogether()))
            && (this.getWeixinId() == null ? other.getWeixinId() == null : this.getWeixinId().equals(other.getWeixinId()))
            && (this.getBorrowLimit() == null ? other.getBorrowLimit() == null : this.getBorrowLimit().equals(other.getBorrowLimit()))
            && (this.getNewhandLimit() == null ? other.getNewhandLimit() == null : this.getNewhandLimit().equals(other.getNewhandLimit()))
            && (this.getFristInvestLimit() == null ? other.getFristInvestLimit() == null : this.getFristInvestLimit().equals(other.getFristInvestLimit()))
            && (this.getMoneyLimit() == null ? other.getMoneyLimit() == null : this.getMoneyLimit().equals(other.getMoneyLimit()))
            && (this.getSpecialBorrowId() == null ? other.getSpecialBorrowId() == null : this.getSpecialBorrowId().equals(other.getSpecialBorrowId()))
            && (this.getSpecialRemark() == null ? other.getSpecialRemark() == null : this.getSpecialRemark().equals(other.getSpecialRemark()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getBorrowDays() == null ? other.getBorrowDays() == null : this.getBorrowDays().equals(other.getBorrowDays()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIsUse() == null) ? 0 : getIsUse().hashCode());
        result = prime * result + ((getTimeout() == null) ? 0 : getTimeout().hashCode());
        result = prime * result + ((getAddtime() == null) ? 0 : getAddtime().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getRecommendedId() == null) ? 0 : getRecommendedId().hashCode());
        result = prime * result + ((getUsetime() == null) ? 0 : getUsetime().hashCode());
        result = prime * result + ((getTenderId() == null) ? 0 : getTenderId().hashCode());
        result = prime * result + ((getBorrowId() == null) ? 0 : getBorrowId().hashCode());
        result = prime * result + ((getRewardNo() == null) ? 0 : getRewardNo().hashCode());
        result = prime * result + ((getUtenderId() == null) ? 0 : getUtenderId().hashCode());
        result = prime * result + ((getUborrowId() == null) ? 0 : getUborrowId().hashCode());
        result = prime * result + ((getRewardStyle() == null) ? 0 : getRewardStyle().hashCode());
        result = prime * result + ((getRewardName() == null) ? 0 : getRewardName().hashCode());
        result = prime * result + ((getUseTogether() == null) ? 0 : getUseTogether().hashCode());
        result = prime * result + ((getWeixinId() == null) ? 0 : getWeixinId().hashCode());
        result = prime * result + ((getBorrowLimit() == null) ? 0 : getBorrowLimit().hashCode());
        result = prime * result + ((getNewhandLimit() == null) ? 0 : getNewhandLimit().hashCode());
        result = prime * result + ((getFristInvestLimit() == null) ? 0 : getFristInvestLimit().hashCode());
        result = prime * result + ((getMoneyLimit() == null) ? 0 : getMoneyLimit().hashCode());
        result = prime * result + ((getSpecialBorrowId() == null) ? 0 : getSpecialBorrowId().hashCode());
        result = prime * result + ((getSpecialRemark() == null) ? 0 : getSpecialRemark().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getBorrowDays() == null) ? 0 : getBorrowDays().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", money=").append(money);
        sb.append(", type=").append(type);
        sb.append(", isUse=").append(isUse);
        sb.append(", timeout=").append(timeout);
        sb.append(", addtime=").append(addtime);
        sb.append(", username=").append(username);
        sb.append(", recommendedId=").append(recommendedId);
        sb.append(", usetime=").append(usetime);
        sb.append(", tenderId=").append(tenderId);
        sb.append(", borrowId=").append(borrowId);
        sb.append(", rewardNo=").append(rewardNo);
        sb.append(", utenderId=").append(utenderId);
        sb.append(", uborrowId=").append(uborrowId);
        sb.append(", rewardStyle=").append(rewardStyle);
        sb.append(", rewardName=").append(rewardName);
        sb.append(", useTogether=").append(useTogether);
        sb.append(", weixinId=").append(weixinId);
        sb.append(", borrowLimit=").append(borrowLimit);
        sb.append(", newhandLimit=").append(newhandLimit);
        sb.append(", fristInvestLimit=").append(fristInvestLimit);
        sb.append(", moneyLimit=").append(moneyLimit);
        sb.append(", specialBorrowId=").append(specialBorrowId);
        sb.append(", specialRemark=").append(specialRemark);
        sb.append(", sign=").append(sign);
        sb.append(", borrowDays=").append(borrowDays);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}