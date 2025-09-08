public class Rectangle {
    private int length;
    private int width;
    private double[] Xcoords;
    private double[] Ycoords;
    private double Xrot;
    private double Yrot;
    private double degrees;

    public Rectangle() {
        length = 4;
        width = 5;
    }

    public Rectangle(int newLength, int newWidth) {
        this.length = newLength;
        this.width = newWidth;
    } 

    public Rectangle(int newLength, int newWidth, double[] newXarray, double[] newYarray, double Xrotate, double Yrotate, double degrees) {
        this.length = newLength;
        this.width = newWidth;
        this.Xcoords = newXarray;
        this.Ycoords = newYarray;
        this.Xrot = Xrotate;
        this.Yrot = Yrotate;
        this.degrees = degrees;
    } 

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return ("This rectangle has length " + length + " and width of " + width 
            + ". The area is " + length * width);
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

    public double[] rotateRectangle() {
        double[] returnArray = new double[8];
        double radians = Math.toRadians(degrees);
        for (int i = 0; i < 8; i += 2) {
            returnArray[i] = Math.round((Xrot + (Xcoords[i / 2] - Xrot) * Math.cos(radians) - (Ycoords[i / 2] - Yrot) * Math.sin(radians)) * 100.0) / 100.0;
            returnArray[i + 1] = Math.round((Yrot + (Xcoords[i / 2] - Xrot) * Math.sin(radians) + (Ycoords[i / 2] - Yrot) * Math.cos(radians)) * 100.0) / 100.0;
        }
        return returnArray;
    }
}
