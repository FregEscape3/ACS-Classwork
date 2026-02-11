public class Square extends Rectangle {
    public Square(double sideLength) {
        super(sideLength, sideLength);
    }

    public Square() {
        super(4, 4);
    }

    public String toString() {
        return (super.toString() + "\n" + "It is also a square.");
    }
}
