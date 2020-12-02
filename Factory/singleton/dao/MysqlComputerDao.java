package singleton.dao;

import singleton.bean.Computer;

public class MysqlComputerDao extends Singleton implements ComputerDao {
    // way 4: double checked locking
    private volatile static MysqlComputerDao singleton;

    private MysqlComputerDao() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (MysqlComputerDao.class) {
                if (singleton == null) {
                    try {
                        singleton = MysqlComputerDao.class.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {

                    }
                }
            }
        }
        return singleton;
    }

    @Override
    public int insertComputer(Computer computer) {
        if (computer == null) {
            System.out.println("computer is null");
            return 0;
        } else {
            System.out.println("insert computer into Mysql database successfully");
            return 1;
        }
    }

    @Override
    public int updateComputer(int id) {
        System.out.println("update computer in Mysql database successfully");
        return 1;
    }

    @Override
    public int deleteComputer(int id) {
        System.out.println("delete computer in Mysql database successfully");
        return 1;
    }
}
