package com.example.placeapi.controller;

import com.example.placeapi.model.DTO.PlaceListDTO;
import com.example.placeapi.model.Place;
import com.example.placeapi.service.PlaceService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/create")
    public void CreatePlace(@RequestBody Place place) {
        placeService.CreatePlace(place);
    }

    @GetMapping("")
    public List<Place> GetPlaces() {
        return placeService.GetPlaces();
    }

    @GetMapping("/dto")
    public PlaceListDTO GetPlacesDto() {
        return placeService.GetPlacesDto();
    }
}
