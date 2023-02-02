import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public void addMenuItem(Item item) {
        menu.add(item);
    }

    public void addMenuItem(String name, double price) {
        menu.add(new Item(name, price));
    }

    public void addMenuItemByInput() {
        System.out.print("Enter the item name: ");
        String name = System.console().readLine();
        System.out.print("Enter the item price: ");
        double price = Double.parseDouble(System.console().readLine());

        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            Item currentItem = menu.get(i);
            System.out.format("%d %s -- $%.2f\n", i, currentItem.getName(), currentItem.getPrice());
        }
    }

    public void newOrder() {
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.print("Please enter customer name for new order: ");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        Order newOrder = new Order(name);

        // Show the user the menu, so they can choose items to add.
        displayMenu();

        // Prompt the user to enter an item number
        System.out.print("Please enter a menu item index or q to quit: ");
        String itemNumber = System.console().readLine();

        // Write a while loop to collect all user's order items
        while (!itemNumber.equals("q")) {
            try {
                // Get the item object from the menu, and add the item to the order
                Integer itemIndex = Integer.parseInt(itemNumber);
                Item selectedItem = menu.get(itemIndex);
                newOrder.addItem(selectedItem);
            } catch (NumberFormatException e) {
                System.out.println("Invalid menu item index.");
            }

            // Ask them to enter a new item index or q again, and take their input
            System.out.print("Please enter a menu item index or q to quit: ");
            itemNumber = System.console().readLine();
        }

        // After you have collected their order, print the order details
        newOrder.display();
    }
}
