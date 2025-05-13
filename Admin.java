public class Admin extends User {
    public Admin(String name) {
        super(name);
    }
    @Override
    public void showMenu() {
        System.out.println("Admin Menu");
    }
}