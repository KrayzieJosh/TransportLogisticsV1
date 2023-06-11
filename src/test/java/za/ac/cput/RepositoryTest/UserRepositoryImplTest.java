package za.ac.cput.RepositoryTest;

/* UserRepositoryImplTest.java
 Package: RepositoryTest
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.repositoryImpl.UserRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.MethodName.class)
    class UserRepositoryImplTest {

        private static UserRepositoryImpl repository = UserRepositoryImpl.getRepository();
        private static User user = UserFactory.createUser(Helper.generateID(), "Tommy", "Jerico",
                "Abrahams","089 798 5432","tjerico@gmail.com","DRI456");

        @Test
        void a_create() {
            User created = repository.create(user);
            assertEquals(user.getUserId(), created.getUserId());
            System.out.println("Create: " + created);
        }

        @Test
        void b_read() {
            User read = repository.read(user.getUserId());
            assertNotNull(read);
            System.out.println("Read: " + read);
        }

        @Test
        void c_update() {
            User updated = new User.Builder().copy(user).setUserEmail("tjerico01@gmail.com")
                    .build();
            assertNotNull(repository.update(updated));
            System.out.println("Update: " + updated);
        }

        @Test
        void e_delete() {
            boolean success = repository.delete(user.getUserId());
            assertTrue(success);
            System.out.println("Delete: " + success);
        }

        @Test
        void d_getAll() {
            System.out.println("Display all:");
            System.out.println(repository.getAll());
        }
    }

