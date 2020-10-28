package sustech.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sustech.backend.model.Token;
import sustech.backend.model.TokenDo;
import sustech.backend.model.User;
import sustech.backend.model.UserDO;
import sustech.backend.repository.TokenRepository;
import sustech.backend.repository.UserRepository;

import javax.annotation.Resource;

import java.util.UUID;

@RestController
public class UserController {
    @Resource
    UserRepository userRepository;

    @Resource
    TokenRepository tokenRepository;

    @PostMapping("/token")
    public TokenDo getToken(@RequestBody UserDO userDO) {
        System.out.println(userDO);
        if (userRepository.existsByUserNameAndAndPassWord(userDO.getUserName(), userDO.getPassWord())) {
            String uuidReturn = UUID.randomUUID().toString();
            System.out.println(uuidReturn);
            tokenRepository.save(new Token(uuidReturn, System.currentTimeMillis() / 1000));
            return new TokenDo(200, uuidReturn);
        } else {
            return new TokenDo(404, "");
        }
    }

    @PostMapping("/user")
    public int registerUser(@RequestBody UserDO userDO) {
        System.out.println(userDO);
        if (userRepository.existsByUserName(userDO.getUserName())) {
            return 403;
        } else {
            userRepository.save(new User(userDO));
            return 200;
        }
    }
}
