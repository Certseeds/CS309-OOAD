package singleton.dao;

import singleton.bean.Staff;

public class MysqlStaffDao extends Singleton implements StaffDao {
    private volatile static MysqlStaffDao singleton;

    private MysqlStaffDao() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (MysqlComputerDao.class) {
                if (singleton == null) {
                    try {
                        singleton = MysqlStaffDao.class.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {

                    }
                }
            }
        }
        return singleton;
    }

    @Override
    public int insertStaff(Staff staff) {
        if (staff == null) {
            System.out.println("staff is null");
            return 0;
        } else {
            System.out.println("insert staff into Mysql database successfully");
            return 1;
        }

    }

    @Override
    public int deleteStaff(int id) {
        System.out.println("delete Staff in Mysql database successfully");
        return 1;
    }

    @Override
    public int updateStaff(int id) {
        System.out.println("update Staff in Mysql database successfully");
        return 1;
    }
}
