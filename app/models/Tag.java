package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 *
 */
@Entity
public class Tag extends Model {

    public String name;
    public String description;

    
    @ManyToMany
    public List<Tag> tags;
}
