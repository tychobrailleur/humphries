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
public class Permission  extends Model{

    public String name;
    public String description;
    
    
    @ManyToMany
    public List<Tag> tags;
    
    
}