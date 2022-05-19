package com.codeup.springblog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="post_image")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imageTitle;

    @Column(length = 1000)
    private String url;

    @ManyToOne
    @JoinColumn(name="post_id")
    @JsonBackReference
    private Post post;

    public PostImage(String imageTitle, String url, Post post) {
        this.imageTitle = imageTitle;
        this.url = url;
        this.post = post;
    }

    public PostImage() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
