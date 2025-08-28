public class LockerTester {
    public static void main(String[] args) {
        System.out.println("wobbly wiggly wobbly wiggly huuuuh wooaaaaaahhhh wooooaaaahhhhh 6 7");
        Locker C300 = new Locker();
        C300.takeStuff();
        C300.unlock(true);
        String condition = C300.rust("dusty");
        String destroyed = C300.destroy("dusty", true, 2.67);
        System.out.println("Your locker got destroyed by godzilla");
    }
}
