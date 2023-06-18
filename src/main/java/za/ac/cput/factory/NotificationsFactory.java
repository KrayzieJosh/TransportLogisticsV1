package za.ac.cput.factory;

/* NotificationsFactory.java
 Entity for the factory
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/

import za.ac.cput.domain.Notifications;
import za.ac.cput.util.Helper;

public class NotificationsFactory {
    public static Notifications createNotification(String notificationId, String notificationMessage, String notificationStatus){

        notificationId= Helper.generateID();

        if(Helper.isNullOrEmpty(notificationId)||Helper.isNullOrEmpty(notificationMessage)||Helper.isNullOrEmpty(notificationStatus)){
            return null;
        }

        return new Notifications.Builder()
                .setNotificationId(notificationId)
                .setNotificationMessage(notificationMessage)
                .setNotificationStatus(notificationStatus)
                .build();
    }
}

