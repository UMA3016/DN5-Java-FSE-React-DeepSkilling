public class OrderSortingApplication {

    public static void main(String[] args) {

        Order[] orders = {

                new Order(
                        101,
                        "Uma",
                        5000),

                new Order(
                        102,
                        "Sai",
                        3000),

                new Order(
                        103,
                        "Ram",
                        7000)
        };

        SortOperations.bubbleSort(
                orders);

        for(Order order : orders) {
            System.out.println(order);
        }
    }
}