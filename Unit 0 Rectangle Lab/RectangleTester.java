import java.util.Arrays;
import java.util.Scanner;

public class RectangleTester {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double [] Xarray = new double[4];
        double [] Yarray = new double[4];
        int length;
        int width;
        double startX;
        double startY;
        double m;
        double b;
        System.out.println("Please input the length of the rectangle");
        length = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Please input the width of the rectangle");
        width = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Please input the bottom left X coordinate of the rectangle");
        startX = keyboard.nextDouble();
        keyboard.nextLine();
        System.out.println("Please input the bottom left Y coordinate of the rectangle");
        startY = keyboard.nextDouble();
        keyboard.nextLine();
        System.out.println("Please input the m for the line you want to flip the rectangle about");
        m = keyboard.nextDouble();
        System.out.println("Please input the b for the line you want to flip the rectangle about");
        b = keyboard.nextDouble();
        Rectangle rotationRect = new Rectangle(length, width, Xarray, Yarray, 2, 3, 67);
        Rectangle flipRect = new Rectangle(length, width, Xarray, Yarray, m, b);
        Xarray[0] = startX;
        Yarray[0] = startY;
        Xarray[1] = startX;
        Yarray[1] = startY + width;
        Xarray[2] = startX + length;
        Yarray[2] = startY + width;
        Xarray[3] = startX + length;
        Yarray[3] = startY;
        //X, Yrotate are point to rotate from and degrees is degree rotation CCW
        //Starts from bottom left and goes clockwise (bottom left = origin)
        //Choose starting coordinate and then the rest come after
        double[] rotatedRectCoords = rotationRect.rotateRectangle();
        System.out.println("The rotated rectangle's coordinates are:");
        for (int i = 0; i < 8; i += 2) {
            System.out.println("(" + rotatedRectCoords[i] + ", " + rotatedRectCoords[i + 1] + ")");
        }
        System.out.println("Please note that these coordinates are listed from the bottom left and CW");
        double[] flipRectCoords = flipRect.flipRectangle();
        System.out.println("The flipped rectangle's coordinates are:");
        for (int i = 0; i < 8; i += 2) {
            System.out.println("(" + flipRectCoords[i] + ", " + flipRectCoords[i + 1] + ")");
        }
        System.out.println("Please note that these coordinates are listed from the bottom left and CCW");
        Rectangle newRectangle = new Rectangle(10, 15);
        Rectangle rect = new Rectangle();
        Rectangle rect2 = new Rectangle();
        System.out.println(newRectangle.toString());
        System.out.println(rect.equals(rect2));
        System.out.println(newRectangle.getArea());
        System.out.println(newRectangle.getPerimeter());
        System.out.println(newRectangle.getDiagonal());
    }
}
