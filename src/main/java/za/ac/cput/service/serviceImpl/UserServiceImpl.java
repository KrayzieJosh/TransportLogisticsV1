package za.ac.cput.service.serviceImpl;


/* UserServiceImpl.java
 Entity for the serviceImpl
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/


import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.repositoryImpl.UserRepositoryImpl;
import za.ac.cput.service.UserService;
import java.util.Set;

public class UserServiceImpl implements UserService {
    private static UserService service = null;
    private UserRepository repository = null;

    private UserServiceImpl(){
        repository = UserRepositoryImpl.getRepository();
    }
    public static UserService getService() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;

    }
    @Override
    public User create(User user) {
        User created = repository.create(user);
        return created;
                    }

    @Override
    public User read(String userId) {
        User readUser = repository.read(userId);
        return readUser;
    }

    @Override
    public User update(User user) {
        User updateUser = repository.update(user);
        return updateUser;
    }

    @Override
    public boolean delete(String userId){
        boolean success =repository.delete(userId);
        return success;
    }

    @Override
    public Set<User> getAll() {

        return repository.getAll();
    }
}



