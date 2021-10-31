package transport;

// import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
  private static List<AbstractVehicle> filterVehicles(List<AbstractVehicle> theList, CheckVehicle tester){
    List<AbstractVehicle> tempList = new ArrayList<>();

    for(AbstractVehicle v: theList){
      if(tester.test(v)){
        tempList.add(v);
      }
    }
    return tempList;
  }
  public static void main(String[] args) {
    System.out.println("Hello World");
    System.out.println("\n*** Working with Interfaces");

    Horse seabiscuit = new Horse("Seabiscuit");
    Horse affirmed = new Horse("Affirmed");
    Horse joe = new Horse("Joe");

    seabiscuit.eat(10);
    affirmed.eat(25);

    for (int i = 0; i < 3; i++){
      seabiscuit.move();
    }
    System.out.println(seabiscuit.getName() + " " + seabiscuit.getFuelLevel());

    System.out.println("\n\n*** Working with Abstract Classes");
    HorseFromVehicle secretariat = new HorseFromVehicle("Secretariat", 10);
    secretariat.addFuel(10);

    HorseFromVehicle eclipse = new HorseFromVehicle("Eclipse");
    eclipse.move(10);

    HorseFromVehicle trigger = new HorseFromVehicle("Trigger", 10);
    HorseFromVehicle seattleSlew = new HorseFromVehicle("Seattle Slew", 10);
    HorseFromVehicle americanPharoah = new HorseFromVehicle("American Pharoah", 10);

    Auto vw = new Auto(1, "EuroVan", 2000);
    Auto toyota = new Auto(10, "Tundra", 1998);
    Auto honda = new Auto(5, "Accord", 2003);

    vw.move();
    vw.move(5);

    // ArrayList - 1, 3, 4, 6, 2
    // Array (JS) - 1, 3, 4, "Small", 2

    List<AbstractVehicle> myList = new ArrayList<>();
    myList.add(secretariat);
    myList.add(trigger);
    myList.add(seattleSlew);
    myList.add(americanPharoah);
    myList.add(eclipse);
    myList.add(vw);
    myList.add(toyota);
    myList.add(honda);
    myList.add(americanPharoah);

    System.out.println("\n*** The List");
    System.out.println(myList);

    System.out.println("\n*** Lambda Expressions");
    System.out.println("\n*** Sorted List");
    myList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
    myList.forEach((v) -> System.out.println(v.getName()));

    System.out.println();
    myList.sort((v1, v2) -> v2.getFuelLevel() - v1.getFuelLevel());
    myList.forEach((v) -> System.out.println(v));

    System.out.println("\nFilter ");
    List<AbstractVehicle> filteredList = new ArrayList<>();
    filteredList = filterVehicles(myList, (v) -> v.getFuelLevel() < 0);
    filteredList.forEach((v) -> System.out.println(v));

    System.out.println();
    filteredList = filterVehicles(myList, (v) -> (v.getFuelLevel() > 0) && (v instanceof HorseFromVehicle));
    filteredList.forEach((v) -> System.out.println(v));

  }
}
