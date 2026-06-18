public class EmployeeManagementApplication {

    public static void main(
            String[] args) {

        EmployeeManager manager =
                new EmployeeManager();

        manager.add(
                new Employee(
                        101,
                        "Uma",
                        "Developer",
                        50000));

        manager.add(
                new Employee(
                        102,
                        "Sai",
                        "Tester",
                        40000));

        manager.traverse();
    }
}