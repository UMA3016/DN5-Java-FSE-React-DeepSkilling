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

        System.out.println("Original Orders:");
        for(Order order : orders) {
            System.out.println(order);
        }

        System.out.println("\nSorting using Bubble Sort:");
        Order[] ordersForBubble = orders.clone();
        SortOperations.bubbleSort(ordersForBubble);
        for(Order order : ordersForBubble) {
            System.out.println(order);
        }

        System.out.println("\nSorting using Quick Sort:");
        Order[] ordersForQuick = orders.clone();
        SortOperations.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        for(Order order : ordersForQuick) {
            System.out.println(order);
        }
    }
}