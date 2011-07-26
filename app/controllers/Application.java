package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.Ticket;
import play.db.jpa.GenericModel;

//import models.*;

public class Application extends Controller {

    public static void index() {
        List<Ticket> tickets = Ticket.all().fetch();
        render(tickets);
    }

    
}