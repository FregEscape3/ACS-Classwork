public class MatrixFunTester {
    public static void main(String[] args) {
        int[][] thing = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        MatrixFun bums = new MatrixFun(5, 4);
        // toString
        System.out.println(bums);
        System.out.println(bums.toString());
        MatrixFun bums1 = new MatrixFun(thing);
        // toString
        System.out.println(bums1);
        System.out.println(bums1.toString());
        MatrixFun bums2 = new MatrixFun();
        // toString
        System.out.println(bums2);
        System.out.println(bums2.toString());
        // MatrixFun bums3 = new MatrixFun(null);
        // edge case: Null array
        // System.out.println(bums3.toString());
        // equals
        System.out.println(bums.equals(bums1));
        System.out.println(bums1.equals(thing));
        bums.swapRow(6, 4);
    }
}