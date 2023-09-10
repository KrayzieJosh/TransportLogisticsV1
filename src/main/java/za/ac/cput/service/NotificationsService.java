package za.ac.cput.service;

/* NotificationsService.java
 Entity for the service
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/

import za.ac.cput.domain.Notifications;

import java.util.List;
import java.util.Set;

public interface NotificationsService  {

    Notifications create(Notifications notification);

    Notifications read(String notificationId);

    Notifications update (Notifications notification);

    boolean delete(String notificationId);

    public List<Notifications> getAll();
}
