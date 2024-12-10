package ru.itis.models;

import java.util.List;

public class Title {

    private Long id;
    private String name;
    private String description;
    private String type;
    private String coverImage;
    private Long authorId;
    private List<Genre> genres; // Список жанров для этого тайтла

    public Title() {}

    public Title(Long id, String name, String description, String type, String coverImage, Long authorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.coverImage = coverImage;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
