import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
    private int length;
    private int width;

    // Constructor that takes in 2 coordinates and the dimensions of the rectangle
    public Rectangle(int xCoord, int yCoord, int length, int width) {
        super(new int[] { xCoord }, new int[] { yCoord });
        this.length = length;
        this.width = width;

    }

    // Constructor that takes in the dimensions of the rectangle, sets default
    // coordinates to (0, 0)
    public Rectangle(int length, int width) {
        this(0, 0, length, width);
    }

    // Returns the area of the rectangle
    public double getArea() {
        return (double) this.length * this.width;
    }

    // Sets the coordinates of the rectangle, notice that it converts the x and y
    // coordinates to arrays
    public void setCoordinates(int xCoord, int yCoord) {
        this.xCoord[0] = xCoord;
        this.yCoord[0] = yCoord;
    }

    public String toString() {
        return "This shape is a Rectangle with a length of " + length + " and a width of " + width + " and an area of "
                + getArea() + ".";
    }

    // Draws the rectangle
    public void draw(Graphics g) {

        Graphics2D g2D = (Graphics2D) g; // initializes a 2D graphics component
        g2D.setPaint(super.fillColor); // sets the paint color to Pink
        g2D.fillRect(xCoord[0], yCoord[0], length, width); // draws a rectangle (filled in with pink)
        g2D.setPaint(Color.black); // sets the paint color to red
        g2D.setStroke(new BasicStroke(3)); // changes the line stroke width to 3
        g2D.drawRect(xCoord[0], yCoord[0], length, width); // draws a rectangle outline

    }

}
