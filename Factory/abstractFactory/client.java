package abstractFactory;

import abstractFactory.bean.Computer;
import abstractFactory.bean.Staff;
import abstractFactory.dao.ComputerDao;
import abstractFactory.dao.MysqlFactory;
import abstractFactory.dao.StaffDao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        var daoFactory = new MysqlFactory();
        StaffDao staffDao = daoFactory.createStaffDao();
        ComputerDao computerDao = daoFactory.createComputerDao();

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
