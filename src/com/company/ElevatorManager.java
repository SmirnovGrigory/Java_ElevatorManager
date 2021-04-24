package com.company;

import java.util.List;
import java.util.Random;

public class ElevatorManager {
    public List<Request> allRequests;

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
            destination = rand.nextInt(numberOfFloors);
        }
        else {
            direction = rand.nextInt(2);
            if (direction==0) {
                destination=rand.nextInt(floor);
            }
            else {
                destination = floor + rand.nextInt(numberOfFloors-floor)+1;
            }
        }
        return new Request(floor,direction,destination);
    }
}
