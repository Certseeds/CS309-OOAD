package sustech.backend.model;

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
@Table(name = "token_table")
public class Token implements Serializable {
    private static final long serialVersionUID = 4349190261L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_Id", nullable = false)
    private Long autoId;
    @Column(name = "token_id", nullable = false)
    private String tokenId;
    @Column(name = "token_second", nullable = false)
    private Long tokenSecond;

    public Token() {
    }

    public Token(String tokenId, Long tokenSecond) {
        this.tokenId = tokenId;
        this.tokenSecond = tokenSecond;
    }
}