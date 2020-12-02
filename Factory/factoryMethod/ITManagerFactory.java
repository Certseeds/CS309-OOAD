package factoryMethod;

public class ITManagerFactory implements ITStaffFactoryInterface {
    @Override
    public ITStaff createITStaff() {
        return new ITManager();
    }
}
