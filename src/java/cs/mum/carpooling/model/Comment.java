/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class Comment implements Serializable {

    private Integer id;
    private String comment;
    private User givenBy;
    private Post post;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public Comment() {
    }

    public Comment(String comment, User givenBy, Post post) {
        this(-1, comment, givenBy, post, null, null);
    }

    public Comment(Integer id, String comment, User givenBy, Post post,
            LocalDateTime dateCreated, LocalDateTime dateUpdated) {
        this.id = id;
        this.comment = comment;
        this.givenBy = givenBy;
        this.post = post;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public String getComment() {
        return comment;
    }

    public User getGivenBy() {
        return givenBy;
    }

    public Post getPost() {
        return post;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id 
                + ", comment=" + comment 
                + ", givenBy=" + givenBy 
                + ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated + '}';
    }

}
