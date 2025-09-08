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

    public boolean equals(Locker newLocker, Locker lockerOther) {
        if (newLocker.user == lockerOther.user) { //got lazy and didn't include other stuff
            return true;
        } else {
            return false;
        }
    }
    //attention (Q, K ,V) = softmax(K^T * Q/sqrt(d_k))V
}