
import org.junit.*;
import java.util.*;
import models.Ticket;
import org.h2.engine.User;
import play.test.*;
//import models.*;

public class TicketTest extends UnitTest {

    @Test
    public void createAndRetrieveTicket() {
        // Create a new ticket and save it
        Ticket t = new Ticket();
        t.name = "test ticket ";
        t.reference = "REF";

        t.save();

        // Retrieve the Ticket
        Ticket t2 = Ticket.find("byReference", "REF").first();

        // Test 
        assertNotNull(t2);
        assertEquals(t.name, t2.name);
        assertEquals(t.description, t2.description);
    }
}
