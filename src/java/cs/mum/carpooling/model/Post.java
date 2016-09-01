/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class Post implements Serializable {

    private Integer postId;
    private String post;
    private PostType postType;
    private User createdBy;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private List<Comment> comments;
    private List<Like> likes;
    private int likesCount;
    public Post() {
    }

    public Post(int postId, String post, PostType postType,
            User createdBy, LocalDateTime dateCreated,
            LocalDateTime dateUpdated,
            List<Comment> cmnts,
            List<Like> likes,
            int size
            ) {
        this.comments = cmnts != null ? cmnts : new ArrayList<>();
        this.post = post;
        this.postType = postType;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.likes = likes;
        this.likesCount = size;
    }

    public Post(String post, PostType postType, User createdBy) {
        this(-1, post, postType, createdBy, null, null, null,null,0);
    }

    public String getPost() {
        return post;
    }

    public PostType getPostType() {
        return postType;
    }

    public String getPostTypeText() {
        return postType.toString().toLowerCase();
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public Integer getPostId() {
        return postId;
    }

    public int getLikesCount() {
        return this.likes.size();
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId
                + ", post=" + post
                + ", postType=" + postType
                + ", createdBy=" + createdBy
                + ", dateCreated=" + dateCreated
                + ", dateUpdated=" + dateUpdated
                + ", likes=" + this.getLikesCount()
                + ", comments=" + comments + '}';
    }

}
