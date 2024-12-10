package ru.itis.models;

public class Comment {

    private Long id;
    private Long chapterId;
    private Long userId;
    private String content;

    public Comment() {}

    public Comment(Long id, Long chapterId, Long userId, String content) {
        this.id = id;
        this.chapterId = chapterId;
        this.userId = userId;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
