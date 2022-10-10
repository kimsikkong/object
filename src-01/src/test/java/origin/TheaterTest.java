package origin;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TheaterTest {

    @Test
    void test() {
        ArrayList<Ticket> tickets = createMockTickets();
        TicketOffice ticketOffice = new TicketOffice(0L, tickets);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Audience audience = new Audience(new Bag(5000L));
        theater.enter(audience);

        assertEquals(1000L, ticketSeller.getTicketOffice().getAmount());
        assertEquals(4000L, audience.getBag().getAmount());
        assertTrue(audience.getBag().hasTicket());
    }

    private ArrayList<Ticket> createMockTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1000L));
        tickets.add(new Ticket(1000L));
        tickets.add(new Ticket(1000L));
        tickets.add(new Ticket(1000L));
        return tickets;
    }

    @Test
    void test2() {
        ArrayList<Ticket> tickets = createMockTickets();
        TicketOffice ticketOffice = new TicketOffice(0L, tickets);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Audience audience = new Audience(new Bag(new Invitation(LocalDateTime.now()), 0L));
        theater.enter(audience);

        assertTrue(audience.getBag().hasInvitation());
        assertTrue(audience.getBag().hasTicket());
    }

}