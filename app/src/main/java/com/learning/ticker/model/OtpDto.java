package com.learning.ticker.model;

import java.io.Serializable;

public class OtpDto implements Serializable {
    private Long createdTimestamp;
    private Long lastUpdatedTimestamp;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Boolean isActive;
    private Long id;
    private String otpKey;
    private Integer otpValue;
    private String otpChannel;
    private String targetId;
    private Integer wrongAttemptCount;
    private Integer isVerified;
    private Integer mockLogin;
    private String verifiedAt;
    private Long expiryTimestamp;
    private Boolean validNow;
    private Long sessionUserId;

    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Long getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Long lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtpKey() {
        return otpKey;
    }

    public void setOtpKey(String otpKey) {
        this.otpKey = otpKey;
    }

    public Integer getOtpValue() {
        return otpValue;
    }

    public void setOtpValue(Integer otpValue) {
        this.otpValue = otpValue;
    }

    public String getOtpChannel() {
        return otpChannel;
    }

    public void setOtpChannel(String otpChannel) {
        this.otpChannel = otpChannel;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getWrongAttemptCount() {
        return wrongAttemptCount;
    }

    public void setWrongAttemptCount(Integer wrongAttemptCount) {
        this.wrongAttemptCount = wrongAttemptCount;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public Integer getMockLogin() {
        return mockLogin;
    }

    public void setMockLogin(Integer mockLogin) {
        this.mockLogin = mockLogin;
    }

    public String getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(String verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public Long getExpiryTimestamp() {
        return expiryTimestamp;
    }

    public void setExpiryTimestamp(Long expiryTimestamp) {
        this.expiryTimestamp = expiryTimestamp;
    }

    public Boolean getValidNow() {
        return validNow;
    }

    public void setValidNow(Boolean validNow) {
        this.validNow = validNow;
    }

    public Long getSessionUserId() {
        return sessionUserId;
    }

    public void setSessionUserId(Long sessionUserId) {
        this.sessionUserId = sessionUserId;
    }


}
