import java.util.Arrays;
import java.util.Random;

public class Student {
    private String name;
    private String id;
    private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.id = generateId();
    }

    public Student(String name) {
        this.name = name;
        this.grade = 10;
        this.id = generateId();
    }

    public String toString() {
        return (name + " is a " + grade + "th grade student." 
                + " Their id is " + id);
    }

    public boolean equals(Student other) {
        if (this.name.equals(other.name) && this.grade
            == other.grade && this.id.equals(other.id)) {
            return true;
        } else {
            return false;
        }
    }

    public String generateId() {
        int[] numbers = new int[3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(1, 9);
        }
        int id1 = numbers[0];
        int id2 = random.nextInt(1000, 10000);
        int id3 = numbers[1];
        int id4 = numbers[2];
        return (id1 + "" + id3 + "" + id4 + "-" + id2);
    }
}