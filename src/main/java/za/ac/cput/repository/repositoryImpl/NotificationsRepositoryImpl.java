package za.ac.cput.repository.repositoryImpl;

/* NotificationsRepositoryImpl.java
 Entity for the impl
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import za.ac.cput.domain.Notifications;
import za.ac.cput.repository.NotificationsRepository;

import java.util.HashSet;
import java.util.Set;

public class NotificationsRepositoryImpl implements NotificationsRepository {

    private static NotificationsRepositoryImpl repository = null;
    private Set<Notifications> notificationDB = null;

    private NotificationsRepositoryImpl() {
        notificationDB = new HashSet<>();
    }

    public static NotificationsRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new NotificationsRepositoryImpl();
        }
        return repository;
    }
    @Override
    public Notifications create(Notifications notification) {
        boolean success = notificationDB.add(notification);
        if (!success) {
            return null;
        }
        return notification;
    }

    @Override
    public Notifications read(String notificationId) {
        for (Notifications n : notificationDB) {
            if (n.getNotificationId().equals(notificationId))
                return n;
        }
        return null;
    }

    @Override
    public Notifications update(Notifications notification) {
        Notifications oldNotifications = read(notification.getNotificationId());
        if (oldNotifications != null) {
            notificationDB.remove(oldNotifications);
            notificationDB.add(notification);
            return notification;
        }
        return null;
    }



    @Override
    public boolean delete(String notificationId) {
        Notifications notificationToDelete = read(notificationId);
        if (notificationToDelete == null) {
            return false;
        }
        notificationDB.remove(notificationToDelete);
        return true;
    }

    @Override
    public Set<Notifications> getAll () {


        return notificationDB;
    }
}






