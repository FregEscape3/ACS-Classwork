public class TheaterMember {
    private String name;
    private boolean[] loyaltyCredits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean[] getLoyaltyCredits() {
        return loyaltyCredits;
    }

    public void setLoyaltyCredits(boolean[] loyaltyCredits) {
        this.loyaltyCredits = loyaltyCredits;
    }

    public TheaterMember(String name) {
        this.name = name;
        this.loyaltyCredits = new boolean[10];
    }

    public void grantLoyaltyCredit() {
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] != true) {
                loyaltyCredits[i] = true;
            }
        }
    }

    public int countLoyaltyCredits() {
        int count = 0;
        for (int i = 0; i < loyaltyCredits.length; i++) {
            if (loyaltyCredits[i] == true) {
                count++;
            }
        }
        return count;
    }

    public String determineMembershipStatus() {
        if (this.countLoyaltyCredits() >= 6) {
            return "Gold Member";
        } else if (this.countLoyaltyCredits() >= 3) {
            return "Silver Member";
        } else {
            return "Plus Member";
        }
    }

    public String loyaltyHistory() {
        String output = "Loyalty History: [";
        for (int i = 0; i < loyaltyCredits.length - 1; i++) {
            if (loyaltyCredits[i] == true) {
                output = output + "X, ";
            } else {
                output = output + "-, ";
            }
        }
        if (loyaltyCredits[loyaltyCredits.length - 1] == true) {
            output = output + "X";
        } else {
            output = output + "-";
        }
        output = output + "]";
        return output;
    }

    public String toString() {
        return (this.name + " (" + this.determineMembershipStatus() + "), "
                + this.loyaltyHistory());
    }

    public boolean equals(TheaterMember other) {
        if (this.toString().equals(other.toString())) {
            return true;
        } else {
            return false;
        }
    }
}