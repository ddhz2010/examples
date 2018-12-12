package com.davidhernandeztechpro.examples.java.v8;

import com.davidhernandeztechpro.examples.java.v8.models.AutomaticGarageDoor;
import com.davidhernandeztechpro.examples.java.v8.models.Garage;
import com.davidhernandeztechpro.examples.java.v8.models.House;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionalExampleTest {

    private OptionalExample optExample;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        optExample = new OptionalExample();
    }

    @Test
    void testIfNull() {
        assertTrue(optExample.isNull(null, true));
        assertTrue(optExample.isNull(null, false));
        assertFalse(optExample.isNull("", true));
        assertFalse(optExample.isNull("", false));
    }

    @Test
    void testHouseHasMatchingGarageDoor() {

        House houseWithMatchingGarageDoor = buildHouseWithGarageAndDoorOpener(true, true, "Acme");

        assertTrue(optExample.hasMatchingGarageDoor(houseWithMatchingGarageDoor, "Acme", true));
    }

    @Test
    void testHouseWithNoMatchingGarageDoor_differentManufacturer() {
        House houseWithNoMatchingGarageDoor = buildHouseWithGarageAndDoorOpener(true, true, "Different");

        assertFalse(optExample.hasMatchingGarageDoor(houseWithNoMatchingGarageDoor, "Acme", true));
    }

    @Test
    void testHouseWithNoMatchingGarageDoor_noGarageDoorOpener() {
        House houseWithNoMatchingGarageDoor = buildHouseWithGarageAndDoorOpener(true, false, "XXX");

        assertFalse(optExample.hasMatchingGarageDoor(houseWithNoMatchingGarageDoor, "Acme", true));
    }


    private static House buildHouseWithGarageAndDoorOpener(boolean hasGarage, boolean hasGarageDoorOpener,
                                                    String garageDoorOpenerManufacturer) {
        House house = new House();
        if (hasGarage) {
            Garage garage = new Garage();
            house.setGarage(garage);  {
                if(hasGarageDoorOpener) {
                    AutomaticGarageDoor automaticGarageDoor = new AutomaticGarageDoor();
                    if (garageDoorOpenerManufacturer != null) {
                        automaticGarageDoor.setManufacturer(garageDoorOpenerManufacturer);
                    }

                    garage.setAutomaticGarageDoor(automaticGarageDoor);
                }
            }
        }
        return house;
    }
}