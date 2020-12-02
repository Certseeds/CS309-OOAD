package singleton.dao;

public class DaoFactoryImpl {
    public DaoFactoryImpl() {
    }

    public ComputerDao createComputerDao() {
        return null;
    }

    public StaffDao createStaffDao() {
        return null;
    }
}

class MysqlFactory extends DaoFactoryImpl {

    public MysqlFactory() {
        super();
    }

    @Override
    public singleton.dao.ComputerDao createComputerDao() {
        return MysqlComputerDao.getSingleton();
    }

    @Override
    public StaffDao createStaffDao() {
        return MysqlStaffDao.getSingleton();
    }
}

class SqlServerFactory extends DaoFactoryImpl {
    public SqlServerFactory() {
        super();
    }

    @Override
    public ComputerDao createComputerDao() {
        return SqlServerComputerDao.getSingleton();
    }

    @Override
    public StaffDao createStaffDao() {
        return SqlServerStaffDao.getSingleton();
    }
}

