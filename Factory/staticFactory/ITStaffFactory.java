package staticFactory;

public class ITStaffFactory {
    public ITStaff createITManager() {
        return new ITManager();
    }

    public ITStaff createDeveloper() {
        return new Developer();
    }

    public ITStaff createTester() {
        return new Tester();
    }
}
