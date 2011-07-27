package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 *
 * In order to allow project specific workflow, 
 * states are project-specific
 */
@Entity
public class State extends Model {

    public String name;
    public String description;

    @ManyToMany
    public List<Tag> tags;
    
    // FIXME : the workflow is linked to the project
    @ManyToOne
    public Project project;
   
   

}
