/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;

/**
 *
 * @author pierre
 */
@Entity
public class Property  extends Model{

    public String name;
    public String description;
    
    @ManyToMany
    public List<Tag> tags;
    
    // TODO: add type , value, etc.
    // need to define properly how we intend to 
    // implement generic properties
    
    
}
