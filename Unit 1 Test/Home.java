public class Home {
    private String address;
    private String ownerName;
    private String username;
    private int cleanlinessLevel;
    private boolean isScheduled;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        ownerName = CleanUtils.fixName(ownerName);
        this.ownerName = ownerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public void setCleanlinessLevel(int cleanlinessLevel) {
        cleanlinessLevel = CleanUtils.validateCleanlinessLevel(cleanlinessLevel);
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public boolean isScheduled() {
        return isScheduled;
    }
    
    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public Home(String address, String ownerName, int cleanlinessLevel) {
        this.address = address;
        this.ownerName = CleanUtils.fixName(ownerName);
        this.username = CleanUtils.generateUsername(this.ownerName);
        this.cleanlinessLevel = CleanUtils.validateCleanlinessLevel(cleanlinessLevel);
        this.isScheduled = false;
    }

    public Home() {
        this.address = "6741 Mango Mustard St.";
        this.ownerName = "Joshua Bie";
        this.username = CleanUtils.generateUsername(ownerName);
        this.cleanlinessLevel = 7;
        this.isScheduled = true; 
    }

    public String toString() {
        String thing;
        if (this.isScheduled == true) {
            thing = "Yes";
        } else {
            thing = "No";
        }
        return ("== ABOUT HOME ==\nAddress: " + this.address + "\nOwner: " + this.ownerName
                + "\nUsername: " + this.username + "\nCleanliness Level: " + this.cleanlinessLevel
                + "\nIs scheduled for cleaning? " + thing);
    }

    public boolean equals(Home other) {
        if (this.toString().equals(other.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
