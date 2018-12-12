package com.davidhernandeztechpro.examples.java.v8.models;

import java.util.Optional;

public class Garage {
    private AutomaticGarageDoor automaticGarageDoor;
    private Optional<AutomaticGarageDoor> automaticGarageDoorOpt;

    public AutomaticGarageDoor getAutomaticGarageDoor() {
        return automaticGarageDoor;
    }

    public void setAutomaticGarageDoor(AutomaticGarageDoor automaticGarageDoor) {
        this.automaticGarageDoor = automaticGarageDoor;
        automaticGarageDoorOpt = Optional.ofNullable(automaticGarageDoor);
    }

    public Optional<AutomaticGarageDoor> getAutomaticGarageDoorOpt() {
        return automaticGarageDoorOpt;
    }
}
