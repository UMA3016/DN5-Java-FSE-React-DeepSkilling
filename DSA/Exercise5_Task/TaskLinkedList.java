public class TaskLinkedList {

    private Task head;

    public void add(Task task) {
        if(head == null) {
            head = task;
            return;
        }

        Task temp = head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(task);
        System.out.println("Task added successfully: " + task.getTaskName());
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        Task temp = head;
        while(temp != null) {
            System.out.println("ID: " + temp.getTaskId() + ", Name: " + temp.getTaskName() + ", Status: " + temp.getStatus());
            temp = temp.getNext();
        }
    }

    public Task search(int id) {
        Task temp = head;
        while(temp != null) {
            if(temp.getTaskId() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void delete(int id) {
        if(head == null) {
            System.out.println("Error: Task list is empty.");
            return;
        }

        if(head.getTaskId() == id) {
            String removedName = head.getTaskName();
            head = head.getNext();
            System.out.println("Task deleted successfully: " + removedName);
            return;
        }

        Task temp = head;
        while(temp.getNext() != null && temp.getNext().getTaskId() != id) {
            temp = temp.getNext();
        }

        if(temp.getNext() != null) {
            String removedName = temp.getNext().getTaskName();
            temp.setNext(temp.getNext().getNext());
            System.out.println("Task deleted successfully: " + removedName);
        } else {
            System.out.println("Error: Task with ID " + id + " not found for deletion.");
        }
    }
}