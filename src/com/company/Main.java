package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ElevatorManager M = new ElevatorManager(2,10,5);

        M.getElevators()[0].printInfo();
        M.getElevators()[1].printInfo();

        M.generateStartRequests(5);
        System.out.println(M.allRequests.size());
        M.run(40);
        M.getElevators()[0].printInfo();
        M.getElevators()[1].printInfo();
        System.out.println(M.allRequests.size());
    }
}
