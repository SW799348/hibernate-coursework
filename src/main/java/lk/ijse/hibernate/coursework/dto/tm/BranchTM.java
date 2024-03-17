package lk.ijse.hibernate.coursework.dto.tm;

import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BranchTM {

    private Long id;

    private String name;
    private String location;

    private AdminDTO admin;


}
