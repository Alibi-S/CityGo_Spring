package com.example.placeapi.dao;

import com.example.placeapi.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDAO extends JpaRepository<Place, Long> {

}
