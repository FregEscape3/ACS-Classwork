public class TotalItUp {
    private int numOne, numTwo, answer;

    public void setNums(int n1, int n2) {
        this.numOne = n1;
        this.numTwo = n2;
    }

    public void add() {
        answer = numOne + numTwo;
    }

    public void print() {
        System.out.println(numOne + " + " + numTwo + " = " + answer);
    }
}
