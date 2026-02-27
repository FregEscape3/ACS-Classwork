public class Car {
    private String plate;
    private int year;

    public Car(String plate, int year) {
        this.plate = plate;
        this.year = year;
    }

    public Car() {
        this("ABC123", 2010);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "[" + plate + " (" + year + ")]";
    }

    public boolean equals(Car other) {
        return this.plate.equals(other.plate) && this.year == other.year;
    }
}
