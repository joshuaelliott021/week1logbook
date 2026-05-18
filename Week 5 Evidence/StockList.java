import java.util.ArrayList;

public class StockList {

    private ArrayList<Product> stock;

    public StockList() {
        stock = new ArrayList<>();
    }

    public void addProduct(Product item) {
        stock.add(item);
    }

    public Product findProduct(int id) {
        for (Product p : stock) {
            if (p.getId() == id) {   // FIXED: getId(), not getID()
                return p;
            }
        }
        return null;
    }

    public boolean removeProduct(int id) {
        Product p = findProduct(id);
        if (p != null) {
            stock.remove(p);
            return true;
        }
        return false;
    }

    public void deliver(int id, int amount) {
        Product p = findProduct(id);
        if (p != null) {
            p.increaseQuantity(amount);   // now exists
        }
    }

    public void sell(int id, int amount) {
        Product p = findProduct(id);
        if (p != null) {
            p.decreaseQuantity(amount);   // now exists
        }
    }

    public void printAll() {
        for (Product p : stock) {
            System.out.println(p);   // now prints readable info
        }
    }
}