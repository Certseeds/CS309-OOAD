package adapter;

import java.util.List;

public interface FileOperateInterfaceV2 {
    List<StaffModel> readAllStaff();

    void listAllStaff(List<StaffModel> list);

    void writeByName(List<StaffModel> list);

    void writeByRoom(List<StaffModel> list);

    void writeByPeopleId(List<StaffModel> list);

    void addNewStaff(List<StaffModel> list);

    void removeStaffByMaxPeopleId(List<StaffModel> list);
}
