package com.example.placeapi.model.DTO;

import com.example.placeapi.model.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceListDTO {
    private ArrayList<Place> places;
}
