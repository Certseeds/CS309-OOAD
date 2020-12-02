package abstractFactory.dao;

import abstractFactory.bean.Staff;

public interface StaffDao {
    int insertStaff(Staff staff);

    int deleteStaff(int id);

    int updateStaff(int id);
}
