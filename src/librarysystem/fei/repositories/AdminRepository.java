package librarysystem.fei.repositories;

import librarysystem.fei.data.interfaces.IDB;
import librarysystem.fei.entities.Admin;
import librarysystem.fei.repositories.interfaces.IAdminRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AdminRepository implements IAdminRepository {
    private final IDB db;

    public AdminRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createAdmin(Admin admin) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql = "INSERT INTO admins(id,name,pwd) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, admin.getId());
            st.setString(2, admin.getName());
            st.setString(3, admin.getPwd());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Admin getAdminById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM admins WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("pwd"));

                return admin;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmin() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,pwd FROM admins";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Admin> admins = new LinkedList<Admin>();
            while (rs.next()) {
                Admin admin = new Admin(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("pwd"));

                admins.add(admin);
            }

            return admins;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean deleteAdmin(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "delete from admins where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
