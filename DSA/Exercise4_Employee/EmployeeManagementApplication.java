public class EmployeeManagementApplication {

    public static void main(
            String[] args) {

        EmployeeManager manager =
                new EmployeeManager();

        manager.add(new Employee(101, "Uma", "Developer", 50000));
        manager.add(new Employee(102, "Sai", "Tester", 40000));
        // This will trigger array resizing as initial capacity is set to 2
        manager.add(new Employee(103, "Ram", "Manager", 70000));

        System.out.println();
        manager.traverse();

        System.out.println("\nSearching for Employee 102:");
        Employee emp = manager.search(102);
        if (emp != null) {
            System.out.println("Found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee 101:");
        manager.delete(101);

        System.out.println();
        manager.traverse();
    }
}