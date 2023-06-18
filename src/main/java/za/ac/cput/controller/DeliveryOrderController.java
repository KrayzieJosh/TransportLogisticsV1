package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.service.DeliveryOrderService;

import java.util.Set;

@RestController
@RequestMapping("/deliveryOrder")
class DeliveryOrderController {

    @Autowired
    private DeliveryOrderService deliveryOrderService;

    @PostMapping("/create")
    public DeliveryOrder create(@RequestBody DeliveryOrder deliveryOrder) {
        return deliveryOrderService.create(deliveryOrder);
    }

    @GetMapping("/read/{id}")
    public DeliveryOrder read(@PathVariable String id) {
        return deliveryOrderService.read(id);
    }

    @PostMapping("/update")
    public DeliveryOrder update(@RequestBody DeliveryOrder deliveryOrder) {
        return deliveryOrderService.update(deliveryOrder);
    }

    @RequestMapping("/getAll")
    public Set<DeliveryOrder> getAll() {
        return deliveryOrderService.getAll();
    }
}
