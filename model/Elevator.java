package model;

public class Elevator {
  String name;
  double currentValue;
  
  public Elevator(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getCurrentValue() {
    return currentValue;
  }

  public void add(double portion) {
    currentValue = currentValue + portion;
  }

}
