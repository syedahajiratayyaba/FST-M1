package activities;

public class Activity1 extends Car {

    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.make = 2020;
        toyota.color = "red";
        toyota.transmission = "Automatic";
    
        //Using Car class method
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
    }

}
