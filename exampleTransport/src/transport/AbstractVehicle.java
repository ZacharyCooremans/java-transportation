package transport;

abstract class AbstractVehicle {
  protected int fuel;

  // default constructor
  public AbstractVehicle(){
    fuel = 1;
  }

  public AbstractVehicle(int fuel){
    this.fuel = fuel;
  }

  abstract String getPath();
  abstract String getName();

  public void move(){
    fuel--;
  }

  public void move(int steps) {
    fuel = fuel - steps;
  }

  public int getFuelLevel(){
    return fuel;
  }

  public void addFuel(int i){
    fuel = fuel + i;
  }

}
