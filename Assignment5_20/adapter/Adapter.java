package adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Adapter implements FileOperateInterfaceV2 {
    private FileOperateInterfaceV1 adaptee_FileOperateInterface;
    private ManageStaffInterface adaptee_ManageStaffInterface;

    public Adapter(FileOperateInterfaceV1 fileOperateInterface, ManageStaffInterface manageStaffInterface) {
        this.adaptee_FileOperateInterface = fileOperateInterface;
        this.adaptee_ManageStaffInterface = manageStaffInterface;
    }

    @Override
    public List<StaffModel> readAllStaff() {
        return adaptee_FileOperateInterface.readStaffFile();
    }

    @Override
    public void listAllStaff(List<StaffModel> list) {
        adaptee_FileOperateInterface.printStaffFile(list);
    }

    @Override
    public void writeByName(List<StaffModel> list) {
        var temp = list.toArray(new StaffModel[0]);
        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp, (x, y) -> x.getName().compareTo(y.getName()));
        System.out.println(Arrays.toString(temp));
        adaptee_FileOperateInterface.writeStaffFile(Arrays.stream(temp).collect(Collectors.toList()));
    }

    @Override
    public void writeByRoom(List<StaffModel> list) {
        var temp = list.toArray(new StaffModel[0]);
        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp, (x, y) -> x.getRoom().compareTo(y.getRoom()));
        System.out.println(Arrays.toString(temp));
        adaptee_FileOperateInterface.writeStaffFile(Arrays.stream(temp).collect(Collectors.toList()));
    }

    @Override
    public void writeByPeopleId(List<StaffModel> list) {
        adaptee_FileOperateInterface.writeStaffFile(list);
    }

    @Override
    public void addNewStaff(List<StaffModel> list) {
        adaptee_ManageStaffInterface.addingStaff(list);
    }

    @Override
    public void removeStaffByMaxPeopleId(List<StaffModel> list) {
        adaptee_ManageStaffInterface.removeStaff(list);
    }
}