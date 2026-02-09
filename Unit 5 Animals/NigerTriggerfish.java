public class NigerTriggerfish extends Animal {
    private String name;
    private int numberOfScales;
    private String habitat;
    private String species;
    private String color;
    private boolean isCaptive;
    private String gender;
    private String[] diet;

    public String[] getDiet() {
        return diet;
    }

    public void setDiet(String[] diet) {
        this.diet = diet;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfScales() {
        return numberOfScales;
    }

    public void setNumberOfScales(int numberOfScales) {
        this.numberOfScales = numberOfScales;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCaptive() {
        return isCaptive;
    }

    public void setCaptive(boolean isCaptive) {
        this.isCaptive = isCaptive;
    }

    public NigerTriggerfish(String name, int numberOfScales, String habitat, String species, String color,
            boolean isCaptive, String gender, String[] diet) {
        super(diet, numberOfScales, gender, habitat, color, name);
        this.numberOfScales = numberOfScales;
        this.species = species;
        this.isCaptive = isCaptive;
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
        System.out.println(" ");
    }

}
