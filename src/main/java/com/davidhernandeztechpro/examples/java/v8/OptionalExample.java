package com.davidhernandeztechpro.examples.java.v8;

import com.davidhernandeztechpro.examples.java.v8.models.Garage;
import com.davidhernandeztechpro.examples.java.v8.models.House;

import java.util.Optional;

public class OptionalExample {

    public boolean isNull(final String str, boolean useOptional) {
        if (useOptional) {
            //Optional<String> strOpt = Optional.of(str); // will throw NPE if str is null
            Optional<String> strOpt = Optional.ofNullable(str);
            return !strOpt.isPresent();
        } else {
            return str==null;
        }
    }

    /**
     * Does the house have an automatic door opener from giving garage door manufacturer.
     * @param house
     * @param garageDoorManufacturerName
     * @param useOptional
     * @return
     */
    public boolean hasMatchingGarageDoor(House house, String garageDoorManufacturerName, boolean useOptional) {
        if (useOptional) {
            Optional<Garage> optGarage = house.getGarageOpt();
            return optGarage.map(Garage::getAutomaticGarageDoor)
                    .filter(automaticGarageDoor -> garageDoorManufacturerName.equals(automaticGarageDoor.getManufacturer()))
                    .isPresent();

        }
        return false;
    }
}
