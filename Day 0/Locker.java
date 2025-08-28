public class Locker {
    private String user;
    private String color;
    private String condition;
    private String material;
    private int number;
    private boolean locked;
    private double height;
    private double weight;


    public Locker() {
        user = "unknown";
        color = "pale";
        condition = "dusty";
        material = "steel";
        number = 300;
        locked = true;
        height = 2.67;
        weight = 65;
    }

    public void unlock(boolean locked) {
        if (locked == true) {
            locked = false;
        }
        else {
            locked = true;
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
}