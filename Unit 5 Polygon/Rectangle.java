public class Rectangle extends Polygon {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double width, double length) {
        super(4);
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        this(4.0, 3.0);
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        String output = "";
        output += super.toString() + "\n";
        output += "This is a rectangle with length of " + this.length + " and width of " + this.width + "."
                + " It's area is " + this.getArea() + ".";
        return output;
    }
}
