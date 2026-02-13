import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class StudentTicket extends Ticket {
    private static final double STUDENT_DISCOUNT = 0.50;

    public StudentTicket(Date eventDate, int ticketCount) {
        super(eventDate, ticketCount);
    }

    public double getTotalPrice() {
        return ticketCount * this.getBasePrice() * 0.5 * (1 + this.getTax());
    }

    @Override
    public void printTicketDetails() {
        System.out.println("== RECEIPT ==\nEvent Date: " + eventDate + "\nCount: " + ticketCount +
                "\n" + "Ticket Type: Ticket Type: Student (Must Show ID)" + "\nTicket Price: $" + this.getTotalPrice() +
                "\nCancellation Policy: Can be canceled within 24 hours before the event. No cancellation fee applies.");
    }
}
