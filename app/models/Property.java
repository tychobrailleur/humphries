package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 *
 * @author pierre
 */
@Entity
public class Property extends Model {

    @ManyToMany
    public List<Tag> tags;
}
