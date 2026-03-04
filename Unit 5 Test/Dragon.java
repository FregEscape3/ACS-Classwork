public class Dragon extends Monster {
    private String name;
    private ElementType element;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private boolean hasUsedDoubleDown = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElementType getElement() {
        return element;
    }

    public void setElement(ElementType element) {
        this.element = element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isHasUsedDoubleDown() {
        return hasUsedDoubleDown;
    }

    public void setHasUsedDoubleDown(boolean hasUsedDoubleDown) {
        this.hasUsedDoubleDown = hasUsedDoubleDown;
    }

    public Dragon(String name) {
        super(name, ElementType.AIR, 100, 30, 50, 35, "Dragon Breath", "Fire Breath", ElementType.AIR,
                ElementType.FIRE);
    }

    public String victoryNoise() {
        return "Hon Hon Hon I am Dragonite and you all are peasants";
    }
}
