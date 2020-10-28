package sustech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserDO implements Serializable {
    private static final long serialVersionUID = 19290402L;
    private String userName;
    private String passWord;

    public UserDO() {
    }
}
// curl -H "Accept: application/json" \
// -H "Content-type: application/json" \
// -X POST -d '{"userName":"11712312","passWord":"wowawesome"}' localhost:8888/user