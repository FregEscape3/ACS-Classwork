public class SkyViewTester {
    public static void main(String[] args) {
        double[] scanned = { 1, 2, 3, 4, 5, 6 };
        SkyView thing = new SkyView(3, 2, scanned);
        System.out.println(thing.toString());
        System.out.println(thing.getAverage(1, 2, 0, 1));
    }
}
