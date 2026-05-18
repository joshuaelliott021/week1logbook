public class StockDemo {
    private StockList stock;

    public StockDemo() {
        stock = new StockList();

        stock.addProduct(new Product(101, "Graphics Cards", 0));
        stock.addProduct(new Product(102, "Processors", 0));
        stock.addProduct(new Product(103, "RAM", 0));
    }

    // -----------------------------
    // Your original demo
    // -----------------------------
    public void runDemo() {
        System.out.println("Initial stock");
        stock.printAll();

        stock.deliver(101, 10);
        stock.deliver(102, 5);
        stock.deliver(103, 20);

        System.out.println("\nStock after deliveries");
        stock.printAll();

        stock.sell(101, 2);
        stock.sell(102, 1);
        stock.sell(103, 5);

        System.out.println("\nAfter sales");
        stock.printAll();
    }

    // -----------------------------
    // REQUIRED TEST METHODS
    // -----------------------------
    public void testAddProduct() {
        System.out.println("=== Testing Add Product ===");
        stock.addProduct(new Product(104, "Motherboard", 15));
        stock.printAll();
    }

    public void testFindProduct() {
        System.out.println("=== Testing Find Product (ID 102) ===");
        Product p = stock.find(102);

        if (p != null) {
            System.out.println("Product found:");
            p.print();
        } else {
            System.out.println("Product not found.");
        }
    }

    public void testRemoveProduct() {
        System.out.println("=== Testing Remove Product (ID 103) ===");
        boolean removed = stock.removeProduct(103);

        if (removed) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }

        stock.printAll();
    }

    // -----------------------------
    // Demo runner
    // -----------------------------
    public void runDemo2() {
        testAddProduct();
        testFindProduct();
        testRemoveProduct();
    }

    public static void main(String[] args) {
        StockDemo demo = new StockDemo();
        demo.runDemo2();
    }
}