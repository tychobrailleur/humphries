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
 * This class reprents a security role
 * Roles cans be assigned to users and groups of users
 *  
 */
@Entity
public class Role  extends Model{

    @ManyToMany
    public List<Tag> tags;
    
    
}
