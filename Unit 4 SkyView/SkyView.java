public class SkyView {
    public double[][] view;

    public double[][] getView() {
        return view;
    }

    public void setView(double[][] view) {
        this.view = view;
    }

    public SkyView(int numberOfRows, int numberOfCols, double[] scanned) {
        if (scanned.length != numberOfRows * numberOfCols) {
            throw new IllegalArgumentException();
        }
        view = new double[numberOfRows][numberOfCols];
        int count = 0;
        for (int i = 0; i < numberOfRows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < numberOfCols; j++) {
                    view[i][j] = scanned[count];
                    count++;
                }
            } else {
                for (int j = 0; j < numberOfCols; j++) {
                    view[i][numberOfCols - j - 1] = scanned[count];
                    count++;
                }
            }
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < this.getView().length; i++) {
            for (int j = 0; j < this.getView()[i].length; j++) {
                output += this.getView()[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }

    public boolean equals(SkyView other) {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        if (this.getView().length != other.getView().length) {
            return false;
        } else {
            for (int i = 0; i < this.getView().length; i++) {
                if (this.getView()[i].length != other.getView()[i].length) {
                    return false;
                } else {
                    for (int j = 0; j < this.getView()[i].length; j++) {
                        if (this.getView()[i][j] != other.getView()[i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public double getAverage(int startRow, int endRow, int startCol, int endCol) {
        double sum = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                sum += view[i][j];
            }
        }
        return sum / ((endRow - startRow + 1) * (endCol - startCol + 1));
    }
}
