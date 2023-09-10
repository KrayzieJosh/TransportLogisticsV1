package za.ac.cput.repository;

/* UserRepository.java
 Entity for the repository
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import za.ac.cput.domain.User;

import java.util.Set;

public interface UserRepository extends IRepository <User,String> {

    public Set<User> getAll();
}
