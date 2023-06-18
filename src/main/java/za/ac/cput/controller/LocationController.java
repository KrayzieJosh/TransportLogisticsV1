package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.service.LocationService;
import java.util.List;
/* LocationController.java
 Author: Joshua Jacobs (221144862)
 Date: 18 June 2023
*/
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public Location create(@RequestBody Location location){
        Location locationCreated = LocationFactory.createLocation(location.getLocationId(), location.getName(), location.getStreetNumber(), location.getStreetName(), location.getTownOrCity(), location.getAreaCode());

        return locationService.create(location);
    }
    @GetMapping("/read/{locationId}")
    public Location read(@PathVariable int locationId){
        return locationService.read(String.valueOf(locationId));
    }
    @PostMapping("/update")
    public Location update(@RequestBody Location location){
        return locationService.update(location);
    }
    @DeleteMapping("delete/{locationId}")
    public boolean delete(@PathVariable int locationId){
        return locationService.delete(String.valueOf(locationId));
    }
    @GetMapping("/getAll")
    public List<Location> getAll(){
        return (List<Location>) locationService.getAll();
    }
    @RequestMapping({"/","/home"})
    String home(){
        return"Hello universe!";
    }
}