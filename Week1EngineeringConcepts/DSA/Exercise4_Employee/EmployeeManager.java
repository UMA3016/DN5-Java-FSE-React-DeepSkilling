public class EmployeeManager {

    Employee[] employees =
            new Employee[100];

    int size = 0;

    public void add(
            Employee employee) {

        employees[size++] =
                employee;
    }

    public Employee search(
            int id) {

        for(int i = 0;
            i < size;
            i++) {

            if(employees[i]
                    .employeeId == id) {

                return employees[i];
            }
        }

        return null;
    }

    public void traverse() {

        for(int i = 0;
            i < size;
            i++) {

            System.out.println(
                    employees[i].name);
        }
    }

    public void delete(
            int id) {

        for(int i = 0;
            i < size;
            i++) {

            if(employees[i]
                    .employeeId == id) {

                for(int j = i;
                    j < size - 1;
                    j++) {

                    employees[j] =
                            employees[j + 1];
                }

                size--;
                break;
            }
        }
    }
}