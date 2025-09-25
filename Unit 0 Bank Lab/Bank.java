public class Bank {
    private int numberOfLoanOfficers;
    private int numberOfTellers;

    public int getNumberOfLoanOfficers() {
        return numberOfLoanOfficers;
    }
    
    public void setNumberOfLoanOfficers(int numberOfLoanOfficers) {
        this.numberOfLoanOfficers = numberOfLoanOfficers;
    }

    public int getNumberOfTellers() {
        return numberOfTellers;
    }

    public void setNumberOfTellers(int numberOfTellers) {
        this.numberOfTellers = numberOfTellers;
    }

    public Bank(int numberOfLoanOfficers, int numberOfTellers) {
        this.numberOfLoanOfficers = numberOfLoanOfficers;
        this.numberOfTellers = numberOfTellers;
    }

    public int computeTotalEmployees() {
        return (numberOfLoanOfficers + numberOfTellers);
    }

    public String toString() {
        return ("This bank has " + numberOfLoanOfficers + " loan officers and "
                + numberOfTellers + " tellers.");
    }

    public boolean equals(Bank other) {
        if (this.numberOfLoanOfficers == other.numberOfLoanOfficers 
            && this.numberOfTellers == other.numberOfTellers) {
            return true;
        } else {
            return false;
        }
    }

    public void hireMembers(int numberToHire, boolean isLoanOfficer) {
        if (isLoanOfficer == true) {
            numberOfLoanOfficers += numberToHire;
        } else {
            numberOfTellers += numberToHire;
        }
    }

    public double getEmployeeRatio() {
        return ((double) numberOfLoanOfficers / numberOfTellers);
    }

    public void fireMembers(int numberToFire, boolean isLoanOfficer) {
        if (isLoanOfficer == true) {
            if (numberToFire < numberOfLoanOfficers) {
                numberOfLoanOfficers -= numberToFire;
            } else {
                numberOfLoanOfficers = 0;
            }
        } else {
            if (numberToFire < numberOfTellers) {
                numberOfTellers -= numberToFire;
            } else {
                numberOfTellers = 0;
            }
        }
    }

    public void transferEmployee(boolean fromLoanOfficer) {
        if (fromLoanOfficer == true) {
            numberOfLoanOfficers -= 1;
            numberOfTellers += 1;
        } else {
            numberOfLoanOfficers += 1;
            numberOfTellers -= 1;        
        }
    }

    public int calculateTotalSalary() {
        return (75000 * numberOfLoanOfficers + 45000 * numberOfTellers);
    }
}
