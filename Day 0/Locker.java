public class Locker {
    private String user;
    private String color;
    private String condition;
    private String material;
    private int number;
    private boolean locked;
    private double height;
    private double weight;
    //this is the instructions for the traits of each bottle


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Locker() {
        user = "unknown";
        color = "pale";
        condition = "dusty";
        material = "steel";
        number = 300;
        locked = true;
        height = 2.67;
        weight = 65;
        //Instructions for creating particular bottles (instances of the class)
        //Need to set the variables declared earlier to a certain value
    }

    public void unlock(boolean locked) {
        if (locked == true) {
            locked = false;
        }
    }

    public String rust(String condition) {
        if (condition != "rusty") {
            System.out.println("This locker is not rusty. Good for you!");
        }
        condition = "rusty";
        return condition;
    }

    public void takeStuff() {
        System.out.println("You took out a book.");
    }

    public String destroy(String condition, boolean locked, double height) {
        for (int i = 0; i < 5; i++) {
            System.out.println(5 - i);
        }
        condition = "destroyed";
        locked = false;
        height = 0;
        return (condition + " " + locked + " " + height);
    }

    public String toString() {
        return (user + color + condition + material + number + locked + height + weight + "hi");
    }

    public boolean equals(Locker lockerOther) {
        if (this.user.equals(lockerOther.user) &&
            this.color.equals(lockerOther.color) &&
            this.condition.equals(lockerOther.condition) &&
            this.material.equals(lockerOther.material) &&
            this.number == lockerOther.number &&
            this.locked == lockerOther.locked &&
            this.height == lockerOther.height &&
            this.weight == lockerOther.weight) {
            return true;
        } else {
            return false;
        }
    }
    //attention (Q, K ,V) = softmax(K^T * Q/sqrt(d_k))V
}