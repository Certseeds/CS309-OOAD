package sustech.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sustech.backend.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Transactional(timeout = 10)
    Boolean existsByUserNameAndAndPassWord(String userName, String passWord);

    @Transactional(timeout = 10)
    Boolean existsByUserName(String userName);
}

