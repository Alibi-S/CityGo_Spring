package com.example.frontservice.model.DTO;

import com.example.frontservice.model.Place;
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
