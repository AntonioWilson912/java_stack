import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double orderTotal = 0.0;

        for (double price : prices) {
            orderTotal += price;
        }
        return orderTotal;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.format("%d %s\n", i, menuItems.get(i));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size())
            return false;
        
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.format("%d %s -- $%.2f\n", i, menuItems.get(i), prices.get(i));
        }

        return true;
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.print("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");
        System.out.format("There are %d people in front of you.\n", customers.size());
        customers.add(userName);
    }

    public void addCustomers(ArrayList<String> customers) {
        String userInput = "";

        while (!userInput.toLowerCase().equals("q")) {
            System.out.print("Please enter the customer's name or q to quit: ");
            userInput = System.console().readLine();
            if (!userInput.toLowerCase().equals("q")) {
                customers.add(userInput);
            }
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int qty = 1; qty <= maxQuantity; qty++) {
            double cost = qty * price;
            double discount = 0.50 * (qty - 1);
            cost -= discount;
            System.out.printf("%d - $%.2f\n", qty, cost);
        }
    }
}
