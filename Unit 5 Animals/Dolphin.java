public class Dolphin extends Animal {
    private String name;
    private int IQ;
    private String color;
    private boolean isFriendly;
    private int age;
    private String gender;
    private int happiness;
    public String habitat;
    private String[] diet;

    public String[] getDiet() {
        return diet;
    }

    public void setDiet(String[] diet) {
        this.diet = diet;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int iQ) {
        IQ = iQ;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public void setFriendly(boolean isFriendly) {
        this.isFriendly = isFriendly;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dolphin(String name, int IQ, String color, boolean isFriendly, int age, String gender, int happiness,
            String habitat, String[] diet) {
        super(diet, age, gender, habitat, color, name);
        this.IQ = IQ;
        this.isFriendly = isFriendly;
        this.happiness = happiness;
    }

    public String toString() {
        String thing;
        String thing1 = "";
        if (isSmart() == true) {
            thing = "very smart";
        } else {
            thing = "not smart";
        }
        if (diet == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < diet.length - 1; i++) {
            thing1 += diet[i] + ", ";
        }
        thing1 += diet[diet.length - 1];
        return ("My name is " + this.name + ". I am " + thing + ", with an IQ of " + this.IQ
                + ". I am " + this.color + " and I am very " + this.isFriendly + ". I am " + this.age
                + " years old and I am a " + this.gender + ". My happiness score is " + this.happiness
                + "and I live in the " + this.habitat + " and I eat " + thing1 + ".");
    }

    public boolean isSmart() {
        if (this.IQ > 90) {
            return true;
        } else {
            return false;
        }
    }

    public void sing() {
        System.out.println("Eeeh aahhh eehhh ahhh ahhh eh eh ah ah");
        happiness += 5;
    }

    public void swim(int time) {
        System.out.println(name + " is a bum and is swam near the " + habitat + " for " + time + " minutes");
    }

    public void eat(String food) {
        if (food == null || food.isEmpty()) {
            System.out.println(name + " has nothing to eat.");
            return;
        }
        if (!String.join(", ", diet).contains(food)) {
            System.out.println(name + " cannot eat " + food + " because it's not in the diet.");
            return;
        }
        System.out.println(name + " is eating " + food);
        return;
    }
}
