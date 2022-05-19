package com.codeup.springblog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @OneToOne
    private PostDetails postDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonManagedReference
    private List<PostImage> postImages;

    public Post(){}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, PostDetails postDetails, List<PostImage> postImages) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
        this.postImages = postImages;
    }

    public Post(String title, String body, List<PostImage> postImages) {
        this.title = title;
        this.body = body;
        this.postImages = postImages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }
}
