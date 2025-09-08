public class RectangleTester {
    public static void main(String[] args) {
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
