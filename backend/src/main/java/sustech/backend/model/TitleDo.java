package sustech.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TitleDo implements Serializable {
    private static final long serialVersionUID = 2044592701L;
    private String title;

}