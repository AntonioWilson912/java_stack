public class TestOrders {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Chad");
        Order order4 = new Order("Danny");
        Order order5 = new Order("Eli");

        Item dripCoffee = new Item("drip coffee", 1.50);
        Item capuccino = new Item("Capuccino", 3.50);
        Item latte = new Item("latte", 4.00);
        Item mocha = new Item("mocha", 1.99);

        order1.addItem(capuccino);
        order1.addItem(mocha);

        order2.addItem(capuccino);
        order2.addItem(capuccino);

        order3.addItem(dripCoffee);
        order3.addItem(mocha);

        order4.addItem(latte);
        order4.addItem(capuccino);

        order5.addItem(dripCoffee);
        order5.addItem(latte);

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        System.out.println(order1.getStatusMessage());
        order2.setReady(true);
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        order4.setReady(true);
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());
        System.out.println(order3.getOrderTotal());
        System.out.println(order4.getOrderTotal());
        System.out.println(order5.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
