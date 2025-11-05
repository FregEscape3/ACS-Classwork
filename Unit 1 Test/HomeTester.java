public class HomeTester {
    public static void main(String[] args) {
        Home home1 = new Home("123 Theiss Ave.", "   Joshua      Bie  ", 16);
        Home home2 = new Home();
        System.out.println(home1.getOwnerName());
        System.out.println(home1.getUsername());
        System.out.println(home1.getCleanlinessLevel());
        System.out.println(home1.toString());
        System.out.println(home1.equals(home2));
    }
}
