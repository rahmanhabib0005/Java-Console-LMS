public class Student extends User {
    public Student(String name) {
        super(name);
    }
    @Override
    public void showMenu() {
        System.out.println("Student Menu");
    }
}