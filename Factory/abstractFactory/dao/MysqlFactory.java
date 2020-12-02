package abstractFactory.dao;

public class MysqlFactory implements DaoFactory {
    @Override
    public ComputerDao createComputerDao() {
        return new MysqlComputerDao();
    }

    @Override
    public StaffDao createStaffDao() {
        return new MysqlStaffDao();
    }
}
