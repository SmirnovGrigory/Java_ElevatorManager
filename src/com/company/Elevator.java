package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Elevator {
    private int currentFloor;
    private final int maxCapacity;
    private int direction=1;
    private List<Request> passengers;
    ElevatorManager myManager;

    public Elevator(int currentFloor, int maxCapacity, ElevatorManager myManager ) {
        this.maxCapacity = maxCapacity;
        this.currentFloor = currentFloor;
        this.myManager = myManager;
        passengers = new ArrayList<Request>();
    }

    public void findNearestRequestAndSetDirection() { //should be synchronized

        int minDistance=-1;
        for (Request r: myManager.allRequests) {
            if (minDistance==-1 || Math.abs(currentFloor - r.getFloor())<minDistance) {
                minDistance = Math.abs(currentFloor - r.getFloor());
                if (r.getFloor()>currentFloor)
                    direction=1;
                else
                    direction=0;
            }
        }
    }

    public void debark() {
        passengers.removeIf(r -> r.getDestination() == currentFloor);
    }

    public void takePassenger() { //should be synchronized
        List<Request> forRemoving = new ArrayList<Request>();
        for (Request r: myManager.allRequests)
            if (r.getFloor() == currentFloor && (r.getDirection() == direction || passengers.size() == 0) && passengers.size()<maxCapacity) {
                if (passengers.size() == 0)
                    direction=r.getDirection();
                passengers.add(r);
                //myManager.allRequests.remove(r);
                forRemoving.add(r);
            }
        if (forRemoving.size()!=0)
            myManager.allRequests.removeIf(forRemoving::contains);
    }

    public void printInfo() {
        System.out.print("curFloor: " + currentFloor + " dir: " + direction + " pas: " + passengers.size() + "\n");
        if (passengers.size()!=0)
            for (Request r: passengers)
                System.out.println( "f " +r.getFloor() + " dir " + r.getDirection() + " dest " + r.getDestination());
    }

    public void move() {
        takePassenger();
        if (passengers.size() == 0)
            findNearestRequestAndSetDirection();

        if (direction == 0 && currentFloor!=1)
            currentFloor--;
        if (direction == 1)
            currentFloor++;
        debark();
        //if (passengers.size() < maxCapacity)
          //  takePassenger();
    }
}
