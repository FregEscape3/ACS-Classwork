public class Triangle extends Polygon {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super(3);
        this.base = base;
        this.height = height;
    }

    public Triangle() {
        this(3, 4);
    }

    public double getArea() {
        return height * base / 2;
    }

    public String toString() {
        String output = "";
        output += super.toString() + "\n";
        output += "This is a triangle with base of " + this.base + " and height of " + this.height + "."
                + " It's area is " + this.getArea() + ".";
        return output;
    }
}
