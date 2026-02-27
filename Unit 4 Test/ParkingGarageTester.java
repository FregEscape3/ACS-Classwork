import java.util.ArrayList;
import java.util.Arrays;

public class ParkingGarageTester {
    public static void main(String[] args) {
        // some cars
        Car car1 = new Car("ABC123", 2012);
        Car car2 = new Car("J9K-4L2", 2018);
        Car car3 = new Car("7HGS901", 2006);
        Car car4 = new Car("ABC123", 2020);
        // taking the cars, and putting them in a list
        ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(car1, car2, car3,
                car4));
        // creating a garage
        ParkingGarage garage = new ParkingGarage();
        // setting the garage's spots to a 3x3 array of cars, note that some spaces are
        // empty
        Car[][] starterSpots = new Car[][] {
                { car1, null, null },
                { null, car2, null },
                { car3, null, car4 }
        };
        garage.setSpots(starterSpots);
        // extra cars for you to use
        Car car5 = new Car("P4RK1T", 2015);
        Car car6 = new Car("ZOOOM", 2022);
        Car car7 = new Car("OLDTMR", 1999);
        // method that displays the garage's current status
        garage.displayStatus();
        // to-do: it is recommended that you test the following methods before you
        // submit your code:
        // park a car in the garage at a specific location
        // then display the garage's status
        // park(Car vehicle, int level, int space)
        // park a car in the garage at the first available location
        // then display the garage's status
        // park(Car vehicle)
        // park a list of cars in the garage at the first available location
        // then display the garage's status
        // park(ArrayList<Car> vehicles)
        // remove a car from the garage at a specific location
        // then display the garage's status
        // depart(int level, int space)
        // search the garage for cars with a specific license plate
        // then print the list
        // System.out.println(garage.search("ABC123"));
        // search the garage for cars from a specific year
        // then print the list
        // System.out.println(garage.search(2018));
    }
}
