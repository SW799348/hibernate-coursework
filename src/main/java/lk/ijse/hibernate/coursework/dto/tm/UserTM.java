package lk.ijse.hibernate.coursework.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserTM {
    private Long id;
    private String username;

    private String email;
}
