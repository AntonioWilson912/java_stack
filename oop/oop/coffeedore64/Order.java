import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this("Guest");
    }
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        ready = false;
        items = new ArrayList<Item>();
    }

    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    public void addItem(Item item) {
        items.add(item);
    }

    public String getStatusMessage() {
        return ready ? "Your order is ready." : "Thank you for waiting. Your order will be ready soon.";
    }

    public double getOrderTotal() {
        double total = 0.0;

        for (Item item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public void display() {
        System.out.println("Customer Name: " + name);
        for (Item item : items) {
            System.out.format("%s - $%.2f\n", item.getName(), item.getPrice());
        }
        System.out.format("Total: $%.2f\n\n", getOrderTotal());
    }
    
    // GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public boolean isReady() {
        return ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

}

