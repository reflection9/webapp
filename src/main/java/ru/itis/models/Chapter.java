package ru.itis.models;

public class Chapter {

    private Long id;
    private String title;
    private String content;
    private Long titleId;

    public Chapter() {
    }

    public Chapter(Long id, String title, String content, Long titleId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.titleId = titleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }
}
