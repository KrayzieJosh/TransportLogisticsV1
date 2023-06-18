package za.ac.cput.controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.DeliveryEventsService;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.factory.DeliveryEventsFactory;
import java.util.Set;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/deliveryEvents")

public class DeliveryEventsController {
    @Autowired
    private DeliveryEventsService deliveryEventsService;

    @PostMapping("/create")
    public DeliveryEvents create(@RequestBody DeliveryEvents deliveryEvents) {

        DeliveryEvents deliveryEventsCreated = DeliveryEventsFactory.createDeliveryEvents(deliveryEvents.getDeliveryEventId(), deliveryEvents.getDeliveryName(),deliveryEvents.getDeliveryDate(),deliveryEvents.getDeliveryEventLocation(),deliveryEvents.getNotification());

        return deliveryEventsService.create(deliveryEvents);
    }

    @GetMapping("/read/{deliveryEventsId}")
    public DeliveryEvents read(@PathVariable String deliveryEventsId) {
        return deliveryEventsService.read(deliveryEventsId);
    }

    @PostMapping("/update")
    public DeliveryEvents update(@RequestBody DeliveryEvents deliveryEvents) {
        return deliveryEventsService.update(deliveryEvents);
    }

    @DeleteMapping("delete/{deliveryEventsId}")
    public boolean delete(@PathVariable String deliveryEventsId) {
        return deliveryEventsService.delete(deliveryEventsId);
    }

    @GetMapping("/getall")
    public Set<DeliveryEvents> getAll() {
        return deliveryEventsService.getAll();
    }


}


