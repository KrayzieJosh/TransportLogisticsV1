package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.DeliveryOrder;
import za.ac.cput.service.DeliveryOrderService;

import java.util.List;

@RestController
@RequestMapping("/deliveryOrder")
public class DeliveryOrderController {

    private final DeliveryOrderService deliveryOrderService;

    @Autowired
    public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @PostMapping("/create")
    public DeliveryOrder create(@RequestBody DeliveryOrder deliveryOrder) {
        return deliveryOrderService.create(deliveryOrder);
    }

    @GetMapping("/read/{deliveryOrderId}")
    public DeliveryOrder read(@PathVariable String deliveryOrderId) {
        return deliveryOrderService.read(deliveryOrderId);
    }

    @PostMapping("/update")
    public DeliveryOrder update(@RequestBody DeliveryOrder deliveryOrder) {
        return deliveryOrderService.update(deliveryOrder);
    }

    @DeleteMapping("/delete/{deliveryOrderId}")
    public boolean delete(@PathVariable String deliveryOrderId) {
        return deliveryOrderService.delete(deliveryOrderId);
    }

    @GetMapping("/getall")
    public List<DeliveryOrder> getAll() {
        return deliveryOrderService.getAll();
    }
}
