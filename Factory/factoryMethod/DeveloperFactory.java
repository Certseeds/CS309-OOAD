package factoryMethod;

public class DeveloperFactory implements ITStaffFactoryInterface {
    @Override
    public ITStaff createITStaff() {
        return new Developer();
    }
}
