package sustech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * @author nanos
 */
@Entity
@Data
@AllArgsConstructor
@Table(name = "user_table")
public class User implements Serializable {
    private static final long serialVersionUID = 125183331L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String userName;
    @Column(name = "password", nullable = false)
    private String passWord;

    public User() {
    }

    public User(UserDO userDO) {
        this.userName = userDO.getUserName();
        this.passWord = userDO.getPassWord();
    }
}