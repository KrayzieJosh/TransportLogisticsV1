package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Tracking;
import za.ac.cput.factory.TrackingFactory;
import za.ac.cput.service.TrackingService;
import java.util.List;
/* TrackingController.java
 Author: Joshua Jacobs (221144862)
 Date: 18 June 2023
*/
@RestController
@RequestMapping("/tracking")
public class TrackingController {
    @Autowired
    private TrackingService trackingService;

    @PostMapping("/create")
    public Tracking create(@RequestBody Tracking tracking){
        Tracking trackingCreated = TrackingFactory.createTracker(tracking.getTripId(), tracking.getStops(), tracking.getDetours());

        return trackingService.create(trackingCreated);
    }
    @GetMapping("/read/{tripId}")
    public Tracking read(@PathVariable String tripId){
        return trackingService.read(String.valueOf(tripId));
    }
    @PostMapping("/update")
    public Tracking update(@RequestBody Tracking tracking){
        return trackingService.update(tracking);
    }
    @DeleteMapping("delete/{tripId}")
    public boolean delete(@PathVariable String tripId){
        return trackingService.delete(String.valueOf(tripId));
    }
    @GetMapping("/getAll")
    public List<Tracking> getAll(){
        return (List<Tracking>) trackingService.getAll();
    }
}