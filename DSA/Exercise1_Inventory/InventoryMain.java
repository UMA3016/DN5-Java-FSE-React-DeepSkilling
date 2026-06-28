public class InventoryMain {
    public static void main(String[] args) {

        InventoryManager manager =
                new InventoryManager();

        manager.addProduct(
                new Product(101,"Laptop",10,50000));

        manager.addProduct(
                new Product(102,"Mouse",50,500));

        manager.updateProduct(102,60,550);

        manager.deleteProduct(101);

        manager.displayProducts();
    }
}