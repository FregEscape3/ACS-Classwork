public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int newLength, int newWidth) {
        this.length = newLength;
        this.width = newWidth;
    } 

    public Rectangle() {
        length = 4;
        width = 5;
    }

    public String toString() {
        return ("This rectangle has length " + length + " and width of " + width + ". The area is " + length*width);
    }

    public boolean equals(Rectangle rectOther) {
        if (width == rectOther.width && length == rectOther.length) {
            return true;
        } else {
            return false;
        }
    }

    public int getArea() {
        return (length * width);
    }

    public int getPerimeter() {
        return (2 * (length + width));
    }

    public double getDiagonal() {
        double thingy = Math.pow(length, 2) + Math.pow(width, 2);
        return (Math.pow(thingy, 0.5));
    }
}
