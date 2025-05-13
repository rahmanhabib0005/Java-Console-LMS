public class Instructor extends User {
    public Instructor(String name) {
        super(name);
    }

    public void showMenu() {
        System.out.println("Instructor Menu:");
        System.out.println("1. Upload Content");
        System.out.println("2. Assign Grade");
        System.out.println("3. Exit");
    }
}