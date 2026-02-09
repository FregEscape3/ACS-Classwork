public abstract class Animal {
    private String[] diet;
    private int age;
    private String gender;
    private String habitat;
    private String color;
    private String name;

    public Animal(String[] diet, int age, String gender, String habitat, String color, String name) {
        this.diet = diet;
        this.age = age;
        this.gender = gender;
        this.habitat = habitat;
        this.color = color;
        this.name = name;
    }

    public String[] getDiet() {
        return diet;
    }

    public void setDiet(String[] diet) {
        this.diet = diet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void eat(String food);

    public abstract void swim(int time);

    public abstract void sing();

    public String toString() {
        return "Animal {" +
                "diet =" + String.join(", ", diet) +
                ", age =" + age +
                ", gender =" + (gender ? "Male" : "Female") +
                ", habitat ='" + habitat + '\'' +
                ", color ='" + color + '\'' +
                ", name ='" + name + '\'' +
                '}';
    }
}
