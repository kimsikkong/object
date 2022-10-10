package refactoring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheaterTest {

    @Test
    void test() {
        ArrayList<Ticket> tickets = createMockTickets();
        TicketOffice ticketOffice = new TicketOffice(0L, tickets);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Audience audience = new Audience(new Bag(5000L));
        theater.enter(audience);

        assertEquals(1000L, ticketOffice.getAmount());
        assertEquals(4000L, audience.getAmount());
    }

    private ArrayList<Ticket> createMockTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1000L));
        tickets.add(new Ticket(1000L));
        tickets.add(new Ticket(1000L));
        tickets.add(new Ticket(1000L));
        return tickets;
    }

}