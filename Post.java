/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;

/**
 *
 * @author 729347
 */
public class Post implements Serializable {

    private String story;

    public Post() {

    }
    
    public Post(String story) {
        this.story = story;
    }
    
    public String getStory() {
        return story;
    }
}
