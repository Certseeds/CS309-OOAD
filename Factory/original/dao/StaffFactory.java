package original.dao;

public class StaffFactory {
    public StaffDao createStaffDao(int type){
        switch (type){
            case 1: return new MysqlStaffDao();
            case 2: return new SqlServerStaffDao();
        }
        return null;
    }
}
