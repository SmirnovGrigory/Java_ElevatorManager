package com.company;

import java.util.*;

public class ElevatorManager {
    private Elevator[] elevators;
    private final int numberOfFloors;
    public List<Request> allRequests;

    public ElevatorManager(int numberOfElevators, int numberOfFloors, int maxCapacity ) {
        this.numberOfFloors=numberOfFloors;
        elevators = new Elevator[numberOfElevators];
        for (int i=0;i<numberOfElevators;i++)
            elevators[i] = new Elevator(1, maxCapacity, this);
        allRequests = new ArrayList<Request>();
    }

    public Request generateRequest(int numberOfFloors) {
        Random rand = new Random();
        int floor = rand.nextInt(numberOfFloors)+1;
        int direction; // 1 - up, 0 - down
        int destination;
        if (floor == 1) {
            direction = 1;
            destination = floor + rand.nextInt(numberOfFloors-floor)+1;
        }
        else if (floor == numberOfFloors) {
            direction = 0;
            destination = rand.nextInt(numberOfFloors-1)+1;
        }
        else {
            direction = rand.nextInt(2);
            if (direction==0) {
                destination=rand.nextInt(floor-1)+1;
            }
            else {
                destination = floor + rand.nextInt(numberOfFloors-floor)+1;
            }
        }
        return new Request(floor,direction,destination);
    }

    public void addNewRequest() {
        allRequests.add(generateRequest(numberOfFloors));
    }

    public void generateStartRequests(int n) {
        for (int i=0;i<n;i++)
            addNewRequest();
    }

    public Elevator[] getElevators() {
        return elevators;
    }

    void run(int iterations) {
        while (iterations!=0) {
            iterations--;
            for (Elevator e:elevators) {
                e.move();
            }
//            Random rand = new Random();
//            if (rand.nextBoolean()) {
//                addNewRequest();
//            }
        }
    }
}
