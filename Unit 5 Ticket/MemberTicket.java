import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class MemberTicket extends Ticket {
    private static final double MEMBER_DISCOUNT = 0.25;
    private double totalPrice;

    public MemberTicket(Date eventDate, int ticketCount) {
        super(eventDate, ticketCount);
    }

    public double getTotalPrice() {
        return ticketCount * this.getBasePrice() * 0.75 * (1 + this.getTax());
    }

    public void printMemberBenefits() {
        System.out.println("Includes access to special discounts and complimentary refreshments.");
    }

    @Override
    public void printTicketType() {
        System.out.println("Ticket Type: Member");
    }

    @Override
    public void printPrice() {
        BigDecimal decimalFormatter = new BigDecimal(this.getTotalPrice()).setScale(2, RoundingMode.HALF_UP);
        // rounds totalPrice to 2 decimal places, will be 1 decimal place if last digit
        // is 0 (i.e. 7.50 -> 7.5)
        System.out.println("Ticket Price: $" + decimalFormatter.doubleValue()); // prints the price
    }

    @Override
    public void printCancellationPolicy() {
        System.out.println("Can be canceled within 24 hours before the event. No cancellation fee applies.");
    }

    @Override
    public void printTicketDetails() {
        System.out.println("== RECEIPT ==\nEvent Date: " + eventDate + "\nCount: " + ticketCount + "\n"
                + "Ticket Type: Member"
                + "\nTicket Price: $" + this.getTotalPrice()
                + "\nIncludes access to special discounts and complimentary refreshments." +
                "\nCancellation Policy: Can be canceled within 24 hours before the event. No cancellation fee applies.");
    }
}
