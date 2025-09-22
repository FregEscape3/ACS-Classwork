import java.util.Random;

public class Line {
    private int a;
    private int b;
    private int c;

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
}
