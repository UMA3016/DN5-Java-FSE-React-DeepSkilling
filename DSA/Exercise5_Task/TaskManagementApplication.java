public class TaskManagementApplication {

    public static void main(String[] args) {

        TaskLinkedList list =
                new TaskLinkedList();

        list.add(
                new Task(
                        1,
                        "Design UI",
                        "Pending"));

        list.add(
                new Task(
                        2,
                        "Develop Backend",
                        "In Progress"));

        list.add(
                new Task(
                        3,
                        "Testing",
                        "Pending"));

        System.out.println(
                "Task List:");

        list.traverse();

        System.out.println(
                "\nSearching Task 3:");

        Task task =
                list.search(3);

        if(task != null) {

            System.out.println(
                    task.getTaskName());
        }

        list.delete(2);

        System.out.println(
                "\nAfter Deletion:");

        list.traverse();
    }
}