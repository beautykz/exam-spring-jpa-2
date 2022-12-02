package com.example.examspringjpa.service;

import com.example.examspringjpa.dto.LocationDTO;
import com.example.examspringjpa.dto.UserDTO;
import com.example.examspringjpa.exception.ResourceNotFoundException;
import com.example.examspringjpa.model.location.Location;
import com.example.examspringjpa.model.user.User;
import com.example.examspringjpa.repository.LocationRepository;
import com.example.examspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserRepository userRepository;

    public List<LocationDTO> findAllLocations() {
        List<Location> locations = (List<Location>) locationRepository.findAll();

        List<LocationDTO> locationDTOS = new ArrayList<>();
        for (Location location : locations) {
            LocationDTO locationDTO = new LocationDTO();
            locationDTO.setId(location.getId());
            locationDTO.setName(location.getName());
            locationDTOS.add(locationDTO);
        }
        return locationDTOS;
    }

    public LocationDTO findLocationById(String id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (!locationOptional.isPresent()) {
            throw new ResourceNotFoundException();
        }
        Location location = locationOptional.get();
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setName(location.getName());

        return locationDTO;
    }

    public void addLocation(LocationDTO locationDTO) {

        Location location = new Location();
        location.setName(locationDTO.getName());

        locationRepository.save(location);
    }

    public void deleteLocationById(String id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (!locationOptional.isPresent()) {
            throw new ResourceNotFoundException();
        }

        locationRepository.delete(locationOptional.get());
    }
}
