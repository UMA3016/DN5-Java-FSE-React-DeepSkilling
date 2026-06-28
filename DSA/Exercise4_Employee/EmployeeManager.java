public class EmployeeManager {

    private Employee[] employees = new Employee[2]; // Start with small capacity to test resizing

    private int size = 0;

    public void add(Employee employee) {
        if (employee == null) {
            System.out.println("Error: Cannot add a null employee.");
            return;
        }
        // Check for duplicate employee ID
        if (search(employee.getEmployeeId()) != null) {
            System.out.println("Error: Employee with ID " + employee.getEmployeeId() + " already exists.");
            return;
        }
        // Dynamic array resizing
        if (size >= employees.length) {
            Employee[] newEmployees = new Employee[employees.length * 2];
            System.arraycopy(employees, 0, newEmployees, 0, employees.length);
            employees = newEmployees;
            System.out.println("Resized employee array capacity to " + employees.length);
        }
        employees[size++] = employee;
        System.out.println("Employee added successfully: " + employee.getName());
    }

    public Employee search(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        if (size == 0) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("Employee Records:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void delete(int id) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                String removedName = employees[i].getName();
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                // Clear reference to avoid memory leak
                employees[size - 1] = null;
                size--;
                found = true;
                System.out.println("Employee deleted successfully: " + removedName);
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Employee with ID " + id + " not found for deletion.");
        }
    }
}