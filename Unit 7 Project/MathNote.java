import java.util.Random;

public class MathNote extends Note {
    private int difficulty;

    public MathNote(String title, String topic, int unit, int difficulty) {
        super(title, topic, unit, 50);
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String generateGraphingProblem(String type) {
        type = type.toLowerCase();
        Random rand = new Random();
        if (type.equals("trig")) {
            String trigType = "";
            int amp1 = rand.nextInt(-5, 6);
            while (amp1 == 0) {
                amp1 = rand.nextInt(-5, 6);
            }
            int amp2 = rand.nextInt(1, 6);
            int amp3 = rand.nextInt(-5, 6);
            while (amp2 % amp3 == 0 || amp3 == 0) {
                amp2 = rand.nextInt(1, 6);
                amp3 = rand.nextInt(-5, 6);
            }
            int shift1 = rand.nextInt(-6, 7);
            while (shift1 == 5 || shift1 == 0) {
                shift1 = rand.nextInt(-6, 7);
            }
            int shift2 = rand.nextInt(1, 6);
            while (shift2 % shift1 == 0) {
                shift2 = rand.nextInt(1, 6);
            }
            int trig = rand.nextInt(0, 7);
            if (trig == 0) {
                trigType = "sin";
            } else if (trig == 1) {
                trigType = "cos";
            } else if (trig == 2) {
                trigType = "tan";
            } else if (trig == 3) {
                trigType = "csc";
            } else if (trig == 4) {
                trigType = "sec";
            } else {
                trigType = "cot";
            }
            int translation = rand.nextInt(-6, 7);
            return "" + amp1 + "(" + amp2 + "+ " + trigType + " " + shift2 + "\u03C0/" + shift1 + ") + " + translation;
        } else if (type.equals("invtrig")) {
            String trigType = "";
            int amp1 = rand.nextInt(-5, 6);
            while (amp1 == 0) {
                amp1 = rand.nextInt(-5, 6);
            }
            int amp2 = rand.nextInt(-5, 6);
            int amp3 = rand.nextInt(-5, 6);
            while (amp2 % amp3 == 0 || amp2 == 0 || amp3 == 0) {
                amp2 = rand.nextInt(-5, 6);
                amp3 = rand.nextInt(-5, 6);
            }
            int shift1 = rand.nextInt(-6, 7);
            while (shift1 == 5 || shift1 == 0) {
                shift1 = rand.nextInt(-6, 7);
            }
            int shift2 = rand.nextInt(-6, 7);
            while (shift2 % shift1 == 0 || shift2 == 0) {
                shift2 = rand.nextInt(-6, 7);
            }
            int trig = rand.nextInt(0, 3);
            if (trig == 0) {
                trigType = "arcsin";
            } else if (trig == 1) {
                trigType = "arccos";
            } else {
                trigType = "arctan";
            }
            int translation = rand.nextInt(-6, 6);
            return "" + amp1 + "(" + amp2 + "+ " + trigType + " " + shift2 + "/" + shift1 + ") + " + translation;
        } else if (type.equals("polynomial")) {
            String output = "";
            int coefficient1 = rand.nextInt(1, 8);
            int coefficient2 = rand.nextInt(-8, 9);
            if (coefficient1 % coefficient2 == 0) {
                coefficient1 = rand.nextInt(1, 8);
                coefficient2 = rand.nextInt(-8, 9);
            }
            output += coefficient1 + "/" + coefficient2;
            int degree = rand.nextInt(2, 5);
            for (int i = 0; i < degree; i++) {
                int root = rand.nextInt(-10, 11);
                output += "(x + " + root + ")";
            }
            return output;
        } else if (type.equals("rational")) {
            return "(" + generateGraphingProblem("polynomial") + ")/(" + generateGraphingProblem("polynomial") + ")";
        } else if (type.equals("log")) {
            int coefficient1 = rand.nextInt(-5, 6);
            while (coefficient1 == 0) {
                coefficient1 = rand.nextInt(-5, 6);
            }
            int base = rand.nextInt(1, 17);
            int coefficient2 = rand.nextInt(-6, 7);
            while (coefficient2 == 0) {
                coefficient2 = rand.nextInt(-6, 7);
            }
            int coefficient3 = rand.nextInt(-10, 11);
            int coefficient4 = rand.nextInt(-10, 11);
            return coefficient1 + "(log_" + base + "(" + coefficient2 + "x + " + coefficient3 + ") + " + coefficient4;
        } else if (type.equals("exponent")) {
            return "Exponential graphing problem coming soon";
        } else if (type.equals("polar")) {
            return "Polar graphing problem coming soon";
        } else {
            return "That is not a valid option! Please input either trig, invtrig, polynomial, rational, log, exponent, or polar!";
        }
    }
}
