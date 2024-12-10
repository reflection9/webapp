package ru.itis.models;

public class UserTitle {
    private Long userId;
    private Long titleId;
    private String status;

    public UserTitle() {}

    public UserTitle(Long userId, Long titleId, String status) {
        this.userId = userId;
        this.titleId = titleId;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
