package controller;

import model.Elevator;
import model.Truck;

public class ElevatorAppl {
  private static final int N_TRUCKS = 1000;
  private static final int N_RACES = 10;
  private static final int CAPACITY = 20;

  public static void main(String[] args) throws InterruptedException {
    Elevator[] elevators = new Elevator[4];

    for (int i = 0; i < elevators.length; i++) {
      elevators[i] = new Elevator("Elevator_" + (i + 1));
    }

    Truck[] trucks = new Truck[N_TRUCKS];
    for (int i = 0; i < trucks.length; i++) {
      trucks[i] = new Truck(N_RACES, CAPACITY, elevators);
    }

    Thread[] trucksThreads = new Thread[N_TRUCKS];
    for (int i = 0; i < trucksThreads.length; i++) {
        trucksThreads[i] = new Thread(trucks[i]);
        trucksThreads[i].start();
    }

    for (int i = 0; i < trucksThreads.length; i++) {
        trucksThreads[i].join();
    }

    for (int i = 0; i < elevators.length; i++) {
            System.out.println(elevators[i].getName() + " has + " + elevators[i].getCurrentValue() + " tons");
    }
  }
}