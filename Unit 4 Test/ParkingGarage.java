import java.util.ArrayList;

public class ParkingGarage {
    // instance variables
    private Car[][] spots;

    // constructors
    public ParkingGarage(int levels, int spacesPerLevel) {
        if (levels <= 0 || spacesPerLevel <= 0) {
            throw new IllegalArgumentException();
        } else {
            spots = new Car[levels][spacesPerLevel];
        }
    }

    /* initializes spots as a 3x3 2D array */
    public ParkingGarage() {
        spots = new Car[3][3];
    }

    // getters and setters
    public Car[][] getSpots() {
        return spots;
    }

    public void setSpots(Car[][] spots) {
        this.spots = spots;
    }

    // methods

    /*
     * prints out the 2D array 'spots', displaying the car's info if the space is
     * occupied, or
     * '[Empty]' if the space is empty
     */
    public void displayStatus() {
        for (Car[] level : spots) {
            for (Car vehicle : level) {
                if (vehicle != null) {
                    System.out.print(vehicle);
                } else {
                    System.out.print("[Empty]");
                }
            }
            System.out.println();
        }
    }

    public void park(Car vehicle) {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                if (spots[i][j] == null) {
                    spots[i][j] = vehicle;
                    return;
                }
            }
        }
        System.out.println("No empty spots.");
    }

    public void park(Car vehicle, int level, int space) {
        if (vehicle == null) {
            throw new IllegalArgumentException();
        }
        if (level >= spots.length || space >= spots[0].length || level < 0 || space < 0) {
            throw new IllegalArgumentException();
        }
        if (spots[level][space] == null) {
            spots[level][space] = vehicle;
        } else {
            park(vehicle);
        }
    }

    public void park(ArrayList<Car> vehicles) {
        for (Car car : vehicles) {
            park(car);
        }
    }

    public Car depart(int level, int space) {
        if (level >= spots.length || space >= spots[0].length || level < 0 || space < 0) {
            throw new IllegalArgumentException();
        }
        if (spots[level][space] == null) {
            throw new IllegalArgumentException();
        }
        Car output = spots[level][space];
        spots[level][space] = null;
        return output;
    }

    public ArrayList<Car> search(String plate) {
        ArrayList<Car> output = new ArrayList<Car>();
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                if (spots[i][j].getPlate() == plate) {
                    output.add(spots[i][j]);
                }
            }
        }
        return output;
    }

    public ArrayList<Car> search(int year) {
        ArrayList<Car> output = new ArrayList<Car>();
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                if (spots[i][j].getYear() == year) {
                    output.add(spots[i][j]);
                }
            }
        }
        return output;
    }
}