package lk.ijse.hibernate.coursework;

import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.service.impl.AdminServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.AdminService;

public class AppInitializerWrapper {
    public static void main(String[] args) {
        AppInitializer.main(args);

//        AdminService admin = AdminServiceImpl.getInstance();
//
//        AdminDto adminDto = new AdminDTO();
//        adminDto.setUsername("samadhi");
//        adminDto.setPassword("1234");
//
//        long id = admin.saveAdmin(adminDto);
//        System.out.println(id);
//
//        AdminDto adminDto = new AdminDto();
//
//        var admin1 = admin.getAdmin(1L);
//        admin.deleteAdmin(admin1);
//
////
////        Long id= 1L;
////        adminDto.setAdminId(id);
////        adminDto.setPassword("2222");
////        adminDto.setUsername(admin1.getUsername());
////
////        var b = admin.updateAdmin(adminDto);
////        System.out.println(b);


    }
}
