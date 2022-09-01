package model;

public class Truck implements Runnable {
  int nRaces;
  int capacity;
  Elevator[] elevators;

  public Truck(int nRaces, int capacity, Elevator... elevators) {
    this.nRaces = nRaces;
    this.capacity = capacity;
    this.elevators = elevators;
  }

  @Override
  public void run() {
    for (int i = 0; i < nRaces; i++) {
      for (int j = 0; j < elevators.length; j++) {
        synchronized(elevators[j]){
          elevators[j].add(1.*capacity/elevators.length);
        }
      }
    }
  }

}
