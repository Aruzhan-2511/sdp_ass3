public class Main {
    public static void main(String[] args) {

        ControlSystem manual = new ManualControl();
        ControlSystem automatic = new AutomaticControl();

        Vehicle manualCar = new Car(manual);
        Vehicle automaticCar = new Car(automatic);
        Vehicle automaticMotorcycle = new Motorcycle(automatic);

        manualCar.drive();
        automaticCar.drive();
        automaticMotorcycle.drive();
    }
}