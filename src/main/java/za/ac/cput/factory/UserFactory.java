package za.ac.cput.factory;

/* UserFactory.java
 Entity for the factory
 Author: Ferdouz Allie 214038033
 Date: 10 June 2023
*/

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {
public static User createUser(String userId, String userFirstName, String userMiddleName, String userLastName,String userContact, String userEmail, String userDriverCode){

    userId = Helper.generateID();

    if(Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(userFirstName)||Helper.isNullOrEmpty(userMiddleName)
    || Helper.isNullOrEmpty(userLastName) || Helper.isNullOrEmpty(userContact)|| Helper.isNullOrEmpty(userEmail)
    || Helper.isNullOrEmpty(userDriverCode)){
        return null;
    }
    return new User.Builder()
            .setUserId(userId)
            .setUserFirstName(userFirstName)
            .setUserMiddleName(userMiddleName)
            .setUserLastName(userLastName)
            .setUserContact(userContact)
            .setUserEmail(userEmail)
            .setUserDriverCode(userDriverCode)
            .build();
    }
}

