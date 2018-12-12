package com.davidhernandeztechpro.examples.java.v8.streams;

import com.davidhernandeztechpro.examples.java.v8.models.Hotel;

import java.util.ArrayList;
import java.util.List;

public class StreamMatchExample {
    public static void main(String[] args) {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(1));
        hotels.add(new Hotel(2));

    }

    private void hotelsMatch(List<Hotel> hotels) {
        boolean allMatch = hotels.stream().allMatch(hotel -> hotel.getId() < 5);
    }
}
