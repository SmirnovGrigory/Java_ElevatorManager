package com.company;

import java.util.Iterator;
import java.util.List;

public class Elevator {
    private int currentFloor;
    private int maxCapacity;
    private int direction;
    private Request[] passengers;
    ElevatorManager myManager;

    public Elevator(int currentFloor, int maxCapacity, ElevatorManager myManager ) {
        this.maxCapacity = maxCapacity;
        this.currentFloor = currentFloor;
        this.myManager = myManager;
    }

    public void findNearestRequestAndSetDirection(List<Request> lst) {
        int destination;
        int dir;
        Iterator it = lst.iterator();
        while (it.hasNext()) {

        }
    }

    public void move() {
        if (passengers.length == 0) {

        }

        else {
            if (direction == 0)
                currentFloor--;
            if (direction == 1)
                currentFloor++;

        }
    }
}
