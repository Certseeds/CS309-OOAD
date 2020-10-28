package sustech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenDo implements Serializable {
    private static final long serialVersionUID = 4349190260L;
    private int state;
    private String tokenId;

    public TokenDo() {
    }
}