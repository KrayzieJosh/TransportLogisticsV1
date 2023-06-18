package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.GPS;
import za.ac.cput.factory.GPSFactory;
import za.ac.cput.service.GPSService;
import java.util.List;
/* GPSController.java
 Author: Joshua Jacobs (221144862)
 Date: 18 June 2023
*/
@RestController
@RequestMapping("/gps")
public class GPSController {
    @Autowired
    private GPSService gpsService;

    @PostMapping("/create")
    public GPS create(@RequestBody GPS gps){
        GPS gpsCreated = GPSFactory.createGPS(gps.getTripId(), gps.getStartLocationId(),gps.getStoreLocationId());

        return gpsService.create(gpsCreated);
    }
    @GetMapping("/read/{tripId}")
    public GPS read(@PathVariable String tripId){
        return gpsService.read(String.valueOf(tripId));
    }
    @PostMapping("/update")
    public GPS update(@RequestBody GPS gps){
        return gpsService.update(gps);
    }
    @DeleteMapping("delete/{tripId}")
    public boolean delete(@PathVariable String tripId){
        return gpsService.delete(String.valueOf(tripId));
    }
    @GetMapping("/getall")
    public List<GPS> getAll(){
        return (List<GPS>) gpsService.getAll();
    }
}