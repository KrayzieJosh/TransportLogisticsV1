package za.ac.cput.repository.repositoryImpl;
import java.util.HashSet;
import java.util.Set;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl repository = null; //nothiing in customer repo yet
    private Set<User> userDB = null;

    private UserRepositoryImpl() {
        userDB = new HashSet<>();
    }

    public static UserRepositoryImpl getRepository() {
        if (repository == null) { //will return null if empty
            repository = new UserRepositoryImpl(); //will return an object if not
        }
        return repository;
    }

    @Override
    public User create(User user) {
        boolean success = userDB.add(user);
        if (!success)
            return null;
        return user;
    }
    @Override
    public User read(String userId) {
        for (User c : userDB) {
            if (c.getUserId().equals(userId)) //getting the object from the primary key,if thr primary key doe not match the customer id then it will return null
                return c;
        }
        return null;
    }
    @Override
    public User update(User user) {
        User oldUser= read(user.getUserId());
        if (oldUser != null) {
            userDB.remove(oldUser); //getting the existing customer details, and comparing it , if theres changes needed then changes get added and return it to be a new one
            userDB.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(String userId) { //read id , if theres something to delete in DB it will return true if ther is nothing to delete then it will return false
        User userToDelete = read(userId);
        if (userToDelete == null) {
            return false;
        }
        userDB.remove(userToDelete);
        return true;
    }

    @Override
    public Set<User> getAll () {

        return userDB;
    }
}


