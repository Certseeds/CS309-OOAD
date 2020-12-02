package singleton;

import abstractFactory.dao.DaoFactory;
import singleton.bean.Computer;
import singleton.bean.Staff;
import singleton.dao.ComputerDao;
import singleton.dao.DaoFactoryImpl;
import singleton.dao.SqlServerStaffDao;
import singleton.dao.StaffDao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("Factory/singleton/src/resource.properties"));
            prop.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        var method = DaoFactoryImpl.class.getMethod("getSingleton",String.class);
        method.setAccessible(true);
        var dfi = (DaoFactoryImpl)method.invoke(null,prop.getProperty("classname"));
        var staffDao = dfi.createStaffDao();
        var computerDao = dfi.createComputerDao();

        test(staffDao, computerDao);
    }

    public static void test(StaffDao staffDao, ComputerDao computerDao) {
        Scanner input = new Scanner(System.in);
        int op = -1;
        do {
            try {
                op = input.nextInt();
                switch (op) {
                    case 1:
                        staffDao.insertStaff(new Staff());
                        break;
                    case 2:
                        staffDao.updateStaff(1);
                        break;
                    case 3:
                        staffDao.deleteStaff(1);
                        break;
                    case 4:
                        computerDao.insertComputer(new Computer(1));
                        break;
                    case 5:
                        computerDao.updateComputer(1);
                        break;
                    case 6:
                        computerDao.deleteComputer(1);
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Exception " + e);
            }
        } while (op != 0);
    }
}
