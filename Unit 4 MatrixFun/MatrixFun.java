import java.util.Random;

public class MatrixFun {
    private int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public MatrixFun(int numberOfRows, int numberOfColumns) {
        if (numberOfRows <= 0 || numberOfColumns <= 0) {
            throw new IllegalArgumentException();
        }
        matrix = new int[numberOfRows][numberOfColumns];
        fillArray(matrix);
    }

    public MatrixFun(int[][] starterMatrix) {
        checkMatrix(starterMatrix);
        matrix = starterMatrix;
    }

    public MatrixFun() {
        this(3, 3);
    }

    public void fillArray(int[][] toFill) {
        Random rand = new Random();
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                value = rand.nextInt(0, 10);
                matrix[i][j] = value;
            }
        }
    }

    public int[][] checkMatrix(int[][] bumMatrix) {
        try {
            int temp = bumMatrix.length;
        } catch (Exception e) {
            System.out.println("Bums are here!");
            bumMatrix = new int[3][3];
        }
        int checker = bumMatrix[0].length;
        for (int i = 0; i < bumMatrix.length; i++) {
            if (bumMatrix[i].length != checker) {
                int[][] output = new int[bumMatrix.length][checker];
                for (int j = 0; j < bumMatrix.length; j++) {
                    for (int k = 0; k < checker; k++) {
                        output[j][k] = bumMatrix[j][k];
                    }
                }
                return output;
            }
        }
        return bumMatrix;
    }

    public String toString() {
        try {
            int temp = matrix.length;
        } catch (Exception e) {
            System.out.println("Bums are here!");
        }
        String output = "";
        output += "=".repeat(2 * matrix[0].length - 1);
        output += "\n";
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                output += matrix[j][k] + " ";
            }
            output += "\n";
        }
        output += "=".repeat(2 * matrix[0].length - 1);
        return output;
    }

    public boolean equals(MatrixFun other) {
        if (this.toString().equals(other.toString())) {
            return true;
        }
        return false;
    }

    public boolean equals(int[][] other) {
        MatrixFun num1 = new MatrixFun(matrix);
        MatrixFun num2 = new MatrixFun(other);
        if (num1.toString().equals(num2.toString())) {
            return true;
        }
        return false;
    }

    public void replaceAll(int oldValue, int newValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == oldValue) {
                    matrix[i][j] = newValue;
                }
            }
        }
    }

    public void swapRow(int rowA, int rowB) {
        try {
            int[][] temp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix[rowA].length; i++) {
                temp[rowA][i] = matrix[rowB][i];
            }
            for (int j = 0; j < matrix[rowB].length; j++) {
                temp[rowB][j] = matrix[rowA][j];
            }
            matrix[rowA] = temp[rowA];
            matrix[rowB] = temp[rowB];
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
