package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.Set;

public interface UserRepository extends IRepository <User,String> {

    public Set<User> getAll();
}
