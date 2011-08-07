package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 *
 * @author pierre
 */
@Entity
public class Project extends Model {

    public String name;
    public String code;
    public String description;
    @OneToMany
    public List<Project> childrenProjects;
    @ManyToMany
    public List<User> users;
    @ManyToOne
    public User owner;
    @OneToOne
    public Workflow workflow;
    @OneToMany
    public List<Role> roles;
    @OneToMany
    public List<Ticket> tickets;
    @ManyToMany
    public List<Tag> tags;
}
