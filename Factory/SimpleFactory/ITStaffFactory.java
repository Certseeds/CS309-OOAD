package SimpleFactory;

public class ITStaffFactory {
    public ITStaff createITStaff(ITStaffEnum its) {
        switch (its) {
            case Developer: {
                return new Developer();
            }
            case ITManager: {
                return new ITManager();
            }
            case Tester: {
                return new Tester();
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + its);
            }
        }
    }
}
