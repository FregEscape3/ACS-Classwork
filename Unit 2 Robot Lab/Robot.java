public class Robot {
    private int[] hallway;
    private int position;
    private boolean isFacingRight;

    public int[] getHallway() {
        return hallway;
    }

    public void setHallway(int[] hallway) {
        for (int i = 0; i < hallway.length; i++) {
            if (hallway[i] < 0) {
                hallway[i] = 0;
            }
        }
        this.hallway = hallway;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position < 0) {
            position = 0;
        } else if (position > hallway.length - 1) {
            position = hallway.length - 1;
        }
        this.position = position;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean isFacingRight) {
        this.isFacingRight = isFacingRight;
    }

    public Robot(int[] hallwayToClean, int startingPosition) {
        if (startingPosition < 0) {
            startingPosition = 0;
        } else if (startingPosition > hallwayToClean.length - 1) {
            startingPosition = hallwayToClean.length - 1;
        }
        for (int i = 0; i < hallwayToClean.length; i++) {
            if (hallwayToClean[i] < 0) {
                hallwayToClean[i] = 0;
            }
        }
        this.hallway = hallwayToClean;
        this.position = startingPosition;
        this.isFacingRight = true;
    }

    public boolean isRobotBlockedByWall() {
        if ((isFacingRight == true && this.position == hallway.length - 1)
            || (isFacingRight == false && this.position == 0)) {
            return true;
        }
        return false;
    }

    /*
     * Commands the robot to pick up an item, move forward or turn around
     */
    public void move() {
        if (isRobotBlockedByWall() == true) {
            if (hallway[position] == 1 || hallway[position] == 0) {
                if (isFacingRight == true) {
                    isFacingRight = false;
                } else {
                    isFacingRight = true;
                }
            }
            if (hallway[position] != 0) {
                hallway[position] -= 1;
            }
        } else {
            if (hallway[position] == 1) {
                hallway[position] -= 1;
                if (isFacingRight == true) {
                    position += 1;
                } else {
                    position -= 1;
                }
            } else if (hallway[position] == 0) {
                if (isFacingRight == true) {
                    position += 1;
                } else {
                    position -= 1;
                }
            } else {
                hallway[position] -= 1;
            }
        }
    }

    public int clearHall() {
        int count = 0;
        while (hallIsClear() != true) {
            count += 1;
            move();
            hallIsClear();
        }
        return count;
    }

    public boolean hallIsClear() {
        for (int i = 0; i < hallway.length; i++) {
            if (hallway[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public void displayState() {
        for (int i = 0; i < hallway.length; i++) {
            System.out.print(hallway[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < position * 2; i++) {
            System.out.print(" ");
        }
        if (isFacingRight == true) {
            System.out.print(">\n");
        } else {
            System.out.print("<\n");
        }
    }
}
