package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ElevatorManager M = new ElevatorManager();
        for (int i=0; i<5;i++){
           Request r = M.generateRequest(10);
           System.out.println(r.getFloor());
           System.out.println(r.getDestination());
           System.out.println(r.getDirection());
           System.out.println();
        }
    }
}
