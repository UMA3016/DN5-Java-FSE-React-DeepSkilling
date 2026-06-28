import java.util.HashMap;

public class InventoryManager {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Error: Cannot add a null product.");
            return;
        }
        if (product.getQuantity() < 0) {
            System.out.println("Error: Product quantity cannot be negative.");
            return;
        }
        if (product.getPrice() < 0) {
            System.out.println("Error: Product price cannot be negative.");
            return;
        }
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Error: Product with ID " + product.getProductId() + " already exists.");
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully: " + product.getProductName());
    }

    public void updateProduct(int id, int quantity, double price) {
        if (quantity < 0) {
            System.out.println("Error: Quantity cannot be negative.");
            return;
        }
        if (price < 0) {
            System.out.println("Error: Price cannot be negative.");
            return;
        }

        Product p = inventory.get(id);

        if (p != null) {
            p.setQuantity(quantity);
            p.setPrice(price);
            System.out.println("Product ID " + id + " updated successfully.");
        } else {
            System.out.println("Error: Product with ID " + id + " not found for update.");
        }
    }

    public void deleteProduct(int id) {
        if (inventory.containsKey(id)) {
            Product removed = inventory.remove(id);
            System.out.println("Product deleted successfully: " + removed.getProductName());
        } else {
            System.out.println("Error: Product with ID " + id + " not found for deletion.");
        }
    }

    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            inventory.values().forEach(System.out::println);
        }
    }
}