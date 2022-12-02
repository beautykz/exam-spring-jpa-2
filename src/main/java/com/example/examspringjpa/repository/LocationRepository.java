package com.example.examspringjpa.repository;

import com.example.examspringjpa.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
}
