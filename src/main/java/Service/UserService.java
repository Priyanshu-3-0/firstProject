package Service;

import DAO.UserDAO;
import DAO.SpecializationDAO;
import Entities.Specialization;
import Entities.User;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    private SpecializationDAO specializationDAO = new SpecializationDAO();

    public int createUser(String name, String email, String role, Integer specializationId) {
        Specialization specialization = null;
        if ("DOCTOR".equalsIgnoreCase(role) && specializationId != null) {
            specialization = specializationDAO.getById(specializationId);
        }
        User user = new User(name, email, role.toUpperCase(), specialization);
        userDAO.save(user);
        return user.getId();
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }
}
