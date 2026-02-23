import java.awt.*;

public class Triangle extends Shape {

    // to-do: implement the 2-param Constructor
    public Triangle(int[] xCoord, int[] yCoord) {
        super(xCoord, yCoord);
    }

    public Triangle() {
        this(new int[] { 0, 50, 100 }, new int[] { 0, 75, 50 });
    }

    // get the area of the triangle using the 3 coordinates
    public double getArea() {
        return Math.abs((xCoord[0] * (yCoord[1] - yCoord[2]) + xCoord[1] * (yCoord[2] - yCoord[0])
                + xCoord[2] * (yCoord[0] - yCoord[1])) / 2);
    }

    public String toString() {
        return super.toString() + " This shape is a triangle with coordinates (" + xCoord[0] + ", " + yCoord[0] + "), ("
                + xCoord[1] + ", " + yCoord[1] + "), and (" + xCoord[2] + ", " + yCoord[2] + ").";
    }

    // to-do: implement the draw method
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.pink);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawPolygon(xCoord, yCoord, 3);
        g2D.setPaint(super.fillColor);
        g2D.fillPolygon(xCoord, yCoord, 3);
    }

}
