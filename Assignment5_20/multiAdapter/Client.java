package multiAdapter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        List<StaffModel> list = new ArrayList<>();
        FileOperateInterfaceV1 fileOperator1 = new FileOperate();
        ManageStaffInterface manageStaff = new ManageStaff();
        FileOperateInterfaceV2 fileOperator2 = new Adapter(fileOperator1, manageStaff);
        Scanner input = new Scanner(System.in);
        System.out.println("Please select operatio+ \n1.readFile \n2.listFile \n3.writeFileByName \n4.writeFileByPeopleId \n5.addStaff \n6.removeStaff");
        int op = 0;
        do {
            try {
                op = input.nextInt();
                switch (op) {
                    case 1: {
                        list = fileOperator2.readAllStaff();
                        break;
                    }
                    case 2: {
                        fileOperator2.listAllStaff(list);
                        break;
                    }
                    case 3: {
                        fileOperator2.writeByName(list);
                        break;
                    }
                    case 4: {
                        fileOperator2.writeByRoom(list);
                        break;
                    }
                    case 5: {
                        fileOperator2.addNewStaff(list);
                        break;
                    }
                    case 6: {
                        fileOperator2.removeStaffByName(list);
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception:" + e);
                input.nextLine();
            }
        } while (op != 0);
        input.close();
    }
}
