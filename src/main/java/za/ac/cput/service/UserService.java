package za.ac.cput.service;
import java.util.Set;
import za.ac.cput.domain.User;
public interface UserService {
    User create(User user);
    User read(String userId);
    User update(User user);
    boolean delete(String userId);
    public Set<User> getAll();
}
