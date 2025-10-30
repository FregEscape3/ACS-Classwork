import java.util.Random;

public class Line {
    private int a;
    private int b;
    private int c;
    private Point p1;
    private Point p2;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        // instance variables a, b, and c
        // a = - (y2 - y1)
        this.a = -(p2.getY() - p1.getY()); 

        // b = x2 - x1
        this.b = p2.getX() - p1.getX(); 

        // c = - (a * x1 + b * y1)
        this.c = -(this.a * p1.getX() + p1.getY() * this.b);
    }

    public Line() {
        this.a = generateRandomParameters();
        this.b = generateRandomParameters();
        this.c = generateRandomParameters();
    }

    public double calculateSlope() {
        double slope = (-(double) a / b);
        return slope;
    }

    public boolean isCoordinateOnLine(int x, int y) {
        if (x * a + y * b + c == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCoordinateOnLine(Point p) {
        if (p.getX() * a + p.getY() * b + c == 0) {
            return true;
        } else {
            return false;
        } 
    }

    public String toString() {
        return (a + "x + " + b + "y + " + c + " = 0");
    }

    public boolean equals(Line other) {
        if (this.a == other.a && this.b == other.b && this.c == other.c) {
            return true;
        } else {
            return false;
        }
    }

    public int generateRandomParameters() {
        Random random = new Random();
        return (random.nextInt());
    }

    public String isParallel(Line other) {
        if ((-(double) this.a / this.b) == (-(double) other.a / other.b)) {
            return ("These two lines are parallel.");
        } else {
            double intersectX = ((double) other.c / other.b - (double) this.c / this.b)
                / ((double) other.a / other.b - (double) this.a / this.b);
            double intersectY = -((double) this.a / this.b) * intersectX
                + ((double) this.c / this.b);
            return (intersectX + ", " + intersectY);
        }
    }

    public double calculateSlopeFromPoints() {
        return (double) (this.getP2().getY() - this.getP1().getY()) 
                        / (this.getP2().getX() - this.getP1().getX());
    }

    public String generatePointSlopeFormula() {
        return ("(y" + " - " + this.getP1().getY() + ") = "
                + this.calculateSlopeFromPoints() + "(x"
                + " - " + this.getP1().getX() + ")");
    }
}
