package za.ac.cput.service.serviceImpl;

/* NotificationsServiceImpl.java
 Entity for the serviceImpl
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import za.ac.cput.domain.Notifications;
import za.ac.cput.repository.NotificationsRepository;
import za.ac.cput.repository.repositoryImpl.NotificationsRepositoryImpl;
import za.ac.cput.service.NotificationsService;
import java.util.Set;

public class NotificationsServiceImpl implements NotificationsService {

    private static NotificationsService service = null;
    private NotificationsRepository repository = null;

    private NotificationsServiceImpl() {
        repository = NotificationsRepositoryImpl.getRepository();
    }

    public static NotificationsService getService() {
        if (service == null) {
            service = new NotificationsServiceImpl();
        }
        return service;
    }

    @Override
    public Notifications create(Notifications notification) {
        Notifications created = repository.create(notification);
        return created;

    }

    @Override
    public Notifications read(String notificationId) {
        Notifications readNotification=repository.read(notificationId);
        return readNotification;
    }

    @Override
    public Notifications update(Notifications notification) {
        Notifications updateNotifications=repository.update(notification);
        return updateNotifications;
    }
    @Override
    public Set<Notifications> getAll () {


        return repository.getAll();
    }
}

