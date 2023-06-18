package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.service.DeliveryHistoryService;

import java.util.Set;

@RestController
@RequestMapping("/deliveryHistory")
public class DeliveryHistoryController {

    @Autowired
    private DeliveryHistoryService deliveryHistoryService;

    //Methods:
    @PostMapping("/create")
    public DeliveryHistory create(@RequestBody DeliveryHistory deliveryHistory){return deliveryHistoryService.create(deliveryHistory);}

    @GetMapping("/read/{id}")
    public DeliveryHistory read(@PathVariable String id){return deliveryHistoryService.read(id);}

    @PostMapping("/update")
    public DeliveryHistory update(@RequestBody DeliveryHistory deliveryHistory){return  deliveryHistoryService.update(deliveryHistory);}

    @RequestMapping("/getAll")
    public Set<DeliveryHistory> getAll() {return deliveryHistoryService.getAll();}
}
