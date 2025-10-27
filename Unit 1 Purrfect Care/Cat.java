public class Cat {
    private String name;
    private String ownerName;
    private int moodLevel;
    private String catId;
    private char catChar;
    private boolean isHungry;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = PurrfectUtils.validateMoodLevel(moodLevel);
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = PurrfectUtils.validateCatId(catId);
    }

    public char getCatChar() {
        return catChar;
    }

    public void setCatChar(char catChar) {
        this.catChar = catChar;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public Cat(String name, String ownerName, int moodLevel, String catId) {
        this.name = name;
        this.ownerName = ownerName;
        this.moodLevel = PurrfectUtils.validateMoodLevel(moodLevel);
        this.catId = PurrfectUtils.validateCatId(catId);
        this.catChar = PurrfectUtils.generateCatChar(catId);
        this.isHungry = true;
    }

    public Cat() {
        this.name = "Jimbob";
        this.ownerName = "Joshua";
        this.moodLevel = 6;
        this.catId = "6741";
        this.catChar = PurrfectUtils.generateCatChar(this.catId);
        this.isHungry = true;
    }

    public String generateCatTag(String catId, char catChar) {
        return (catId + catChar);
    }

    public String toString() {
        return ("== ABOUT " + name.toUpperCase() + " ==\n"
                + name + " is a cat."
                + "Their tag is " + generateCatTag(this.catId, this.catChar) + "."
                + PurrfectUtils.determineCatMood(this));
    }

    public boolean equals(Cat other) {
        if (this.toString().equals(other.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
