package za.ac.cput.controller;
/* NotificationsController.java
 Entity for the controllers class
 Author: Jameelah Gallo (221110933)
 Date: 19 June 2023
*/
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Notifications;
import za.ac.cput.service.NotificationsService;
import za.ac.cput.factory.NotificationsFactory;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/notifications")

public class NotificationsController {
    @Autowired
    private NotificationsService notificationsService;

    @PostMapping("/create")
    public Notifications create(@RequestBody Notifications notifications) {


        Notifications notificationsCreated = NotificationsFactory.createNotification(notifications.getNotificationId(), notifications.getNotificationMessage(), notifications.getNotificationStatus());

        return notificationsService.create(notifications);
    }

    @GetMapping("/read/{notificationsId}")
    public Notifications read(@PathVariable String notificationsId) {
        return notificationsService.read(notificationsId);
    }

    @PostMapping("/update")
    public Notifications update(@RequestBody Notifications notifications) {
        return notificationsService.update(notifications);
    }

    @GetMapping("/getall")
    public List<Notifications> getAll() {
        return notificationsService.getAll();
    }


}
