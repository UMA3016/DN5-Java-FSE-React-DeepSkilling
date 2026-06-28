public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Uma");
        student.setId("101");
        student.setGrade("A");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        controller.updateView();
    }
}
