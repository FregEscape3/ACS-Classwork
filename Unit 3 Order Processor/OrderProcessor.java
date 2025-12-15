public class OrderProcessor {

    public static OrderSummary processCustomerOrder(Item[] items, double taxRate) {
        ItemProcessingResult result = processItems(items);
        String[] expensiveItems = trimPremiumItems(result.expensiveItemsTemp, result.premiumCount);
        Totals totals = calculateTotals(result.subtotal, taxRate);
        printSummary(result.subtotal, totals.tax, totals.total, result.premiumCount);
        return new OrderSummary(totals.total, result.subtotal, totals.tax, expensiveItems);
    }

    // Processes all items and calculates subtotal and premium items
    // this should be separate because you process orders a lot, and it is good to
    // have a helper method that does that
    private static ItemProcessingResult processItems(Item[] items) {
        double subtotal = 0;
        String[] expensiveItemsTemp = new String[items.length];
        int premiumCount = 0;

        for (Item item : items) {
            String name = item.getName();
            double price = item.getPrice();
            int quantity = item.getQuantity();

            double itemTotal = price * quantity;
            subtotal += itemTotal;

            if (price > 50.0) {
                expensiveItemsTemp[premiumCount] = name;
                premiumCount += 1;
                System.out.println(name + " is a premium item at $" + price);
            } else {
                System.out.println(name + " is a regular item at $" + price);
            }
        }

        return new ItemProcessingResult(subtotal, expensiveItemsTemp, premiumCount);
    }

    // Trims the premium items array to the correct size
    // Important because like processing we need to trim for every order,
    // so it would be good for this to be a helper method
    private static String[] trimPremiumItems(String[] expensiveItemsTemp, int premiumCount) {
        String[] expensiveItems = new String[premiumCount];
        for (int i = 0; i < premiumCount; i++) {
            expensiveItems[i] = expensiveItemsTemp[i];
        }
        return expensiveItems;
    }

    // Calculates tax and total
    // this is a lot of calculations, so I separated this part
    private static Totals calculateTotals(double subtotal, double taxRate) {
        double tax;
        double total;

        if (subtotal > 0) {
            tax = subtotal * taxRate;
            total = subtotal + tax;
        } else {
            tax = 0;
            total = 0;
        }

        return new Totals(tax, total);
    }

    // Prints the order summary
    //
    private static void printSummary(double subtotal, double tax, double total, int premiumCount) {
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax: $" + tax);
        System.out.println("Total: $" + total);
        System.out.println("Number of premium items: " + premiumCount);
    }

    // Helper constructor
    // This helper class is just a constructor basically
    // helpful as an object (like robot.java) for the other functions
    private static class ItemProcessingResult {
        double subtotal;
        String[] expensiveItemsTemp;
        int premiumCount;

        ItemProcessingResult(double subtotal, String[] expensiveItemsTemp, int premiumCount) {
            this.subtotal = subtotal;
            this.expensiveItemsTemp = expensiveItemsTemp;
            this.premiumCount = premiumCount;
        }
    }

    // Another helper constructor
    // This helper class is just a constructor basically
    // helpful as an object (like robot.java) for the other functions
    private static class Totals {
        double tax;
        double total;

        Totals(double tax, double total) {
            this.tax = tax;
            this.total = total;
        }
    }
}
