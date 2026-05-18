import java.util.Scanner;

public class InteractiveMenu {

    private StockList stock;
    private Scanner scanner;

    public InteractiveMenu() {
        stock = new StockList();
        scanner = new Scanner(System.in);

        // Pre-populate with some products
        stock.addProduct(new Product(101, "Graphics Cards", 10));
        stock.addProduct(new Product(102, "Processors", 5));
        stock.addProduct(new Product(103, "RAM", 20));
    }

    public class Week5LogbookEvidence {
    public static void main(String[] args) {
        StockDemo demo = new StockDemo();
        demo.runDemo();
    }

}

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getInt("Enter choice: ");

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    deliverStock();
                    break;
                case 4:
                    sellStock();
                    break;
                case 5:
                    findProduct();
                    break;
                case 6:
                    stock.printAll();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting program... Thank you for using the Stock Management System!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== Stock Management Menu ===");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Deliver Stock");
        System.out.println("4. Sell Stock");
        System.out.println("5. Find Product");
        System.out.println("6. Print All Stock");
        System.out.println("0. Exit");
    }

    private void addProduct() {
        int id = getInt("Enter product ID: ");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        int quantity = getInt("Enter initial quantity: ");

        stock.addProduct(new Product(id, name, quantity));
        System.out.println("Product added successfully.");
    }

    private void removeProduct() {
        int id = getInt("Enter product ID to remove: ");
        if (stock.removeProduct(id)) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void deliverStock() {
        int id = getInt("Enter product ID to deliver: ");
        int amount = getInt("Enter quantity to deliver: ");
        stock.deliver(id, amount);
        System.out.println("Stock delivered successfully.");
    }

    private void sellStock() {
        int id = getInt("Enter product ID to sell: ");
        int amount = getInt("Enter quantity to sell: ");
        stock.sell(id, amount);
        System.out.println("Stock sold successfully.");
    }

    private void findProduct() {
        int id = getInt("Enter product ID to find: ");
        Product p = stock.findProduct(id);

        if (p != null) {
            System.out.println("Product found: " + p);
        } else {
            System.out.println("Product not found.");
        }
    }

    private int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // consume invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear newline
        return value;
    }

    public static void main(String[] args) {
        InteractiveMenu menu = new InteractiveMenu();
        menu.run();
    }
}