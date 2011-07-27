package controllers;

import play.mvc.*;

import java.util.*;
import models.Ticket;

public class Application extends Controller {

    public static void index() {
        List<Ticket> tickets = Ticket.all().fetch();
        render(tickets);
    }
}