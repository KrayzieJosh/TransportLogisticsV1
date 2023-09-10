package za.ac.cput.service.serviceImpl;

/* NotificationsServiceImpl.java
 Entitys for the serviceImpl
 Author: Jameelah Gallo (221110933)
 Date: 9 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Notifications;
import za.ac.cput.repository.NotificationsRepository;
import za.ac.cput.service.NotificationsService;
import java.util.List;
@Service
public class NotificationsServiceImpl implements NotificationsService {

    private NotificationsRepository repository;

    @Autowired
    private NotificationsServiceImpl(NotificationsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notifications create(Notifications notification) {
        return this.repository.save(notification);
    }

    @Override
    public Notifications read(String notificationId) {
        return this.repository.findById(notificationId).orElse(null);
    }

    @Override
    public Notifications update(Notifications notification) {
        if (this.repository.existsById(notification.getNotificationId()))
            return this.repository.save(notification);
        return null;
    }


    @Override
    public boolean delete(String notificationId) {
        if (this.repository.existsById(notificationId)){
            this.repository.deleteById(notificationId);
            return true;
        }
        return false;
    }

    @Override
    public List<Notifications> getAll() {
        return this.repository.findAll();
    }
}