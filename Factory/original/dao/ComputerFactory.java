package original.dao;

public class ComputerFactory {
    public ComputerDao createComputerDao(int type){
        switch (type){
            case 1: return new MysqlComputerDao();
            case 2: return new SqlServerComputerDao();
        }
        return null;
    }
}
