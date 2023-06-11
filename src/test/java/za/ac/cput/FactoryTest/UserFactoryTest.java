package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    public void createUser() {
       User user =  UserFactory.createUser
                (Helper.generateID(),"Tommy","Jerico"
                        ,"Abrahams", "089 798 5432", "tjerico@gmail.com",
                        "DRI456");

        assertNotNull(user);
        System.out.println(user.toString());

    }
}

