public class Student {
    private int age;
    private String name;
    private double GPA;
    private boolean honorRoll;

    public Student(int newAge, String newName, double newGPA, boolean newHonorRoll) {
        age = newAge;
        name = newName;
        GPA = newGPA;
        honorRoll = newHonorRoll;
    }
    public double study(int hours) {
        GPA += hours/100;
        return GPA;
    }
    public void setAge(int silly) {
        age = silly;
    }
    public String getName() {
        return name;
    }
}
