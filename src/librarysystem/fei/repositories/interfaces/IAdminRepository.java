package librarysystem.fei.repositories.interfaces;

import librarysystem.fei.entities.Admin;

import java.util.List;

public interface IAdminRepository  {
    boolean createAdmin(Admin admin);
    Admin getAdminById(int id);
    List<Admin> getAllAdmin();
    boolean deleteAdmin(int id);
}
