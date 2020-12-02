package abstractFactory.dao;

import abstractFactory.bean.Computer;

public interface ComputerDao {
    int insertComputer(Computer computer);

    int updateComputer(int id);

    int deleteComputer(int id);
}
