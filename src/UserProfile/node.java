/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserProfile;

/**
 *
 * @author Boochi
 */

    // Node class to create movie database and genres lists
public class node<T> {
    private node link;
    public T info;
    
    public node(T info) {
        this.info = info;
        link = null;
    }
    
    // Sets info of this node
    public void setInfo(T info)
    {
        this.info = info;
    }
    
    // Returns info of this node
    public T getInfo() {
        return info;
    }
    
    // Sets link of this node
    public void setLink(node link) {
        this.link = link;
    }

    // Returns link of this node
    public node<T> getLink() {
        return link;
    }
}



