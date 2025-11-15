public class RobotTester {
    public static void main(String[] args) {
        int[] hall = {0, 5, 2, 2};
        Robot robby = new Robot(hall, 1);
        robby.setFacingRight(false);
        int moveCount = robby.clearHall();
        System.out.println("The total number of moves to clear this hall: " + moveCount);
        System.out.println("Did the robot complete the hall with exactly 9 moves? "
                            + (moveCount == 9 ? "Yes." : "No."));
    }
}
