public class Dog {
    private String name;
    private String ownerName;
    private int age;
    private int dogId;
    private char dogChar;
    private String dogTag;
    private boolean stillInFacility;

    public Dog(String name, String ownerName, int age, int dogId) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.dogId = dogId;
        this.dogChar = generateDogChar(this.dogId);
        dogTag = generateDogTag();
        stillInFacility = true;
    }

    public Dog() {
        this.name = "Lulu";
        this.ownerName = "Joshua";
        this.age = 6;
        this.dogId = 670;
        this.dogChar = generateDogChar(this.dogId);
        dogTag = generateDogTag();
        stillInFacility = true;       
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public char getDogChar() {
        return dogChar;
    }

    public void setDogChar(char dogChar) {
        this.dogChar = dogChar;
    }

    public String getDogTag() {
        return dogTag;
    }

    public void setDogTag(String dogTag) {
        this.dogTag = dogTag;
    }

    public boolean getStillInFacility() {
        return stillInFacility;
    }

    public void setStillInFacility(boolean stillInFacility) {
        this.stillInFacility = stillInFacility;
    }

    public String toString() {
        String temp = (name + " is a good dog. They are " + age + "years old and belong to " 
                        + ownerName + ". They are currently in our facility." 
                        + "For employee use only: DogTag is " + dogTag + ".");
        stillInFacility = false;
        return temp;
    }

    public boolean equals(Dog other) {
        if (this.toString().equals(other.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static char generateDogChar(int dogId) {
        char dogChar = (char) ('F' + (dogId / 100 + (dogId - dogId / 100) / 10 + dogId % 10) % 10);
        return dogChar;
    }

    public String generateDogTag() {
        dogTag = (dogId + "" + dogChar);
        return dogTag;
    }

    public String pickup(Dog dog, String personName) {
        if (personName.equals(dog.ownerName)) {
            dog.stillInFacility = false;
            return (dog.name + " has been picked up by their" +
                                " owner " + dog.ownerName + ".");
        } else {
            return ("You are not tuff SigmaEpstein. GET OUT! Safety First! :)");
        }
    }

    public void checkIn(Dog dog, String personName) {
        dog.stillInFacility = true;
        dog.ownerName = personName;
    }
}