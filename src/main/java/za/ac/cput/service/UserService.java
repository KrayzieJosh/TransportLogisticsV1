package za.ac.cput.service;

/* UserService.java
 Entity for the service
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import java.util.Set;
import za.ac.cput.domain.User;
public interface UserService {
    User create(User user);
    User read(String userId);
    User update(User user);
    boolean delete(String userId);
    public Set<User> getAll();
}
