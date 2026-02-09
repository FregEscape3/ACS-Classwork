public class BlueFootedBooby extends Animal {
    private String name;
    private int numberOfFeathers;
    private int feetColor;
    private int age;
    private String habitat;
    private String gender;
    private String[] diet;

    public String[] getDiet() {
        return diet;
    }

    public void setDiet(String[] diet) {
        this.diet = diet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFeathers() {
        return numberOfFeathers;
    }

    public void setNumberOfFeathers(int numberOfFeathers) {
        this.numberOfFeathers = numberOfFeathers;
    }

    public int getFeetColor() {
        return feetColor;
    }

    public void setFeetColor(int feetColor) {
        this.feetColor = feetColor;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BlueFootedBooby(String name, int numberOfFeathers, int feetColor, int age, String habitat, String gender,
            String[] diet) {
        super(diet, age, gender, habitat, gender, name);
        this.feetColor = feetColor;
        this.numberOfFeathers = numberOfFeathers;
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

    public void sing() {
        System.out.println("Caw Caw Caw");
    }

}