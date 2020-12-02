package singleton.dao;

import singleton.bean.Staff;

public class SqlServerStaffDao extends Singleton implements StaffDao {
    private volatile static SqlServerStaffDao singleton;

    private SqlServerStaffDao() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (SqlServerComputerDao.class) {
                if (singleton == null) {
                    try {
                        singleton = SqlServerStaffDao.class.getDeclaredConstructor().newInstance();
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
            System.out.println("insert staff into SqlServer database successfully");
            return 1;
        }
    }

    @Override
    public int deleteStaff(int id) {
        System.out.println("delete Staff in SqlServer successfully!");
        return 1;
    }

    @Override
    public int updateStaff(int id) {
        System.out.println("update Staff in SqlServer successfully!");
        return 1;
    }
}
