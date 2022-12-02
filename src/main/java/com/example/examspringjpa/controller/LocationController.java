package com.example.examspringjpa.controller;

import com.example.examspringjpa.dto.LocationDTO;
import com.example.examspringjpa.dto.UserDTO;
import com.example.examspringjpa.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location/findAll")
    public List<LocationDTO> findAllLocation() {
        return locationService.findAllLocations();
    }

    @GetMapping("/location/{id}")
    public LocationDTO findLocationById(@PathVariable String id){
        return locationService.findLocationById(id);
    }

    @PostMapping("/location/add")
    public HttpStatus addLocation(@RequestBody LocationDTO locationDTO) {
        locationService.addLocation(locationDTO);
        return HttpStatus.OK;
    }

    @DeleteMapping("/location/{id}")
    public HttpStatus deleteLocationById(@PathVariable String id) {
        locationService.deleteLocationById(id);
        return HttpStatus.OK;
    }
}
