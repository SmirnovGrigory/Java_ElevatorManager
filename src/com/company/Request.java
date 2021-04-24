package com.company;

public class Request {
    private final int floor;
    private final int direction; // 1 - up, 0 - down
    private final int destination;

    public Request(int floor, int direction, int destination) {
        this.floor = floor;
        this.direction = direction;
        this.destination = destination;
    }

    public int getFloor() {
        return floor;
    }

    public int getDirection() {
        return direction;
    }

    public int getDestination() {
        return destination;
    }
}
