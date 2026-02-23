import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    public MyPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setSize(500, 500);
    }

    public void paint(Graphics g) {
        // to-do: draw the house!

        // Adds shapes to an ArrayList, converting them all to Polygons
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        // building
        shapes.add(new Rectangle(125, 125, 250, 250));
        shapes.get(0).setFillColor(Color.gray);
        shapes.get(0).draw(g);

        // door
        shapes.add(new Rectangle(175, 250, 50, 125));
        shapes.get(1).setFillColor(150, 75, 0);
        shapes.get(1).draw(g);

        // roof
        shapes.add(new Triangle(new int[] { 125, 250, 375 }, new int[] { 125, 75, 125 }));
        shapes.get(2).setFillColor(Color.black);
        shapes.get(2).draw(g);

        // sun
        shapes.add(new Circle(50, 50, 50));
        shapes.get(3).setFillColor(255, 223, 34);
        shapes.get(3).draw(g);

        // window
        shapes.add(new Rectangle(300, 150, 50, 50));
        shapes.get(4).setFillColor(Color.red);
        shapes.get(4).draw(g);

        // sierpinski triangle
        int point1x = 500;
        int point1y = 450;
        int point2x = 0;
        int point2y = 450;
        int point3x = 250;
        int point3y = 450 - (int) (250 * Math.sqrt(3));
        for (int i = 0; i < 100; i++) {
            shapes.add(new Triangle(new int[] { point1x, point2x, point3x },
                    new int[] { point1y, point2y, point3y }));
            shapes.get(i + 5).setFillColor(67, 41, 69);
            shapes.get(i + 5).draw(g);
            int temp1 = point1x;
            int temp2 = point2x;
            int temp3 = point3x;
            point1x = (temp1 + temp2) / 2;
            point2x = (temp2 + temp3) / 2;
            point3x = (temp3 + temp1) / 2;
            temp1 = point1y;
            temp2 = point2y;
            temp3 = point3y;
            point1y = (temp1 + temp2) / 2;
            point2y = (temp2 + temp3) / 2;
            point3y = (temp3 + temp1) / 2;
        }

    }
}
