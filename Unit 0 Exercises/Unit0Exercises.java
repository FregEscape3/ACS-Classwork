// Solution: Unit 0 Exercises
public class Unit0Exercises {

    public static void main(String[] args) {
        Unit0Exercises obj = new Unit0Exercises();
        System.out.println();

        // testing sleepIn() method
        System.out.println(obj.sleepIn(false, false)); // output: true
        // sleepIn(true, false) -> true
        // sleepIn(false, true) -> true

        // testing diff21() method
        System.out.println(obj.diff21(19)); // ouput: 2
        // diff21(10) -> 11
        // diff21(21) -> 0

        // testing flooringCalculator() method
        System.out.println(obj.flooringCalculator(500, 2.5)); // output: 1250.0
        // flooringCalculator(0, 3.0) -> 0.0
        // flooringCalculator(100, -1.5) -> 0.0

    }


    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (weekday == true) {
            if (vacation == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public int diff21(int n) {
        if (n > 21) {
            return 2 * (n - 21);
        } else {
            return (21 - n);
        }
    }

    public double flooringCalculator(int sqft, double pricePerSqft) {
        if (pricePerSqft > 0 && sqft > 0) {
            return (pricePerSqft * sqft);
        } else {
            return 0.0;
        }
    }
}