import java.util.Arrays;

public class RectangleTester {
    public static void main(String[] args) {
        double [] Xarray = new double[4];
        double [] Yarray = new double[4];
        Rectangle newRectangle = new Rectangle(10, 15);
        Rectangle rect = new Rectangle();
        Rectangle rect2 = new Rectangle();
        int length = 10;
        int width = 15;
        double startX = 0;
        double startY = 0;
        Rectangle rotationRect = new Rectangle (length, width, Xarray, Yarray, 0, 0, 42);
        //X, Yrotate are point to rotate from and degrees is degree rotation CCW
        Xarray[0] = startX;
        Yarray[0] = startY;
        Xarray[1] = startX;
        Yarray[1] = startY + width;
        Xarray[2] = startX + length;
        Yarray[2] = startY + width;
        Xarray[3] = startX + length;
        Yarray[3] = startY;
        //Starts from bottom left and goes clockwise (bottom left = origin)
        //Choose starting coordinate and then the rest come after
        System.out.println(newRectangle.toString());
        System.out.println(rect.equals(rect2));
        System.out.println(newRectangle.getArea());
        System.out.println(newRectangle.getPerimeter());
        System.out.println(newRectangle.getDiagonal());
        double[] rotatedRectCoords = rotationRect.rotateRectangle();
        System.out.println("The rotated rectangle's coordinates are:");
        for (int i = 0; i < 8; i += 2) {
            System.out.println("(" + rotatedRectCoords[i] + ", " + rotatedRectCoords[i + 1] + ")");
        }

    }
}
