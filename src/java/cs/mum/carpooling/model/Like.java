/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.model;

import java.io.Serializable;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class Like implements Serializable{

    private User user;
    private Post post;

    public Like() {
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "Like{" + "user=" + user + ", post Id=" + post + '}';
    }

    
}
