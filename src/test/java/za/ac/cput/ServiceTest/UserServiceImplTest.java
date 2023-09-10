package za.ac.cput.ServiceTest;

/* UserServiceImplTest.java
 Package: ServiceTest
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;
import za.ac.cput.service.serviceImpl.UserServiceImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class UserServiceImplTest {

    private static UserService service=null;

    public static User user= UserFactory.createUser(Helper.generateID(), "Tommy", "Jerico"
            , "Abrahams", "089 798 5432","tjerico@gmail.com","DRI456");
    public UserServiceImplTest(){

        service= UserServiceImpl.getService();
    }

    @Test
    void a_create() {
        User created=service.create(user);
        System.out.println("Create: "+created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        User read = service.read(user.getUserId());
        System.out.println("Read: "+read);
        assertNotNull(read);

    }

    @Test
    void c_update() {
        User updated = new User.Builder().copy(user).setUserMiddleName("Shelby")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete(){
        String id=user.getUserId();
        boolean success=service.delete(id);
        assertTrue(success);
        System.out.println("Success: "+ success);
    }
    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
