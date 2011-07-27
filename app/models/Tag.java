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
 */
@Entity
public class Tag  extends Model {

    public String name;
    public String description;

    
}
