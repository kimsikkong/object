package refactoring;

public class Bag {

    private Invitation invitation;
    private Ticket ticket;
    private Long amount;

    public Bag(Invitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            this.ticket = ticket;
            return 0L;
        } else {
            minusAmount(ticket.getFee());
            this.ticket = ticket;
            return ticket.getFee();
        }
    }

    public Bag(Long amount) {
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public Long getAmount() {
        return amount;
    }
}
