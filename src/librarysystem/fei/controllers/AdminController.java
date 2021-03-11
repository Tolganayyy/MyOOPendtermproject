package librarysystem.fei.controllers;

import librarysystem.fei.entities.Admin;
import librarysystem.fei.repositories.interfaces.IAdminRepository;

import java.util.List;

public class AdminController {
    private final IAdminRepository adminrepo;

    public AdminController(IAdminRepository adminrepo) {
        this.adminrepo = adminrepo;
    }
    public String createBook( int id,String name,String pwd){
        Admin admin = new Admin(id, name, pwd);
        boolean created = adminrepo.createAdmin(admin);
        return (created ? "Admin was created!" : "Admin creation was failed!");
    }
    public String getAdminById(int id){
        Admin admin = adminrepo.getAdminById(id);
        return (admin == null ? "Admin was not found!" : admin.toString());
    }
    public String getAllAdmin() {
        List<Admin> admins = adminrepo.getAllAdmin();

        return admins.toString();
    }
    public String deleteAdmin(int id){
        boolean delete = adminrepo.deleteAdmin(id);
        return (delete ? "Admin was deleted!" : "Admin delete was failed!");
    }
}
