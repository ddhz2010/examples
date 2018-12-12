package com.davidhernandeztechpro.examples.java.v8.models;

import java.util.Optional;

public class House {

    private Garage garage;  // traditional way to define
    private Optional<Garage> garageOpt; // use of new Optional - indicates that this is optional

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
        this.garageOpt = Optional.ofNullable(garage);
    }

    public Optional<Garage> getGarageOpt() {
        return garageOpt;
    }
}
