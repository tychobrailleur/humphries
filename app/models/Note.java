package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 *
 * @author pierre
 */
@Entity
public class Note extends Model {

    public String text;
    public User author;
    @ManyToOne
    public Ticket ticket;
    @ManyToMany
    public List<Tag> tags;
}
