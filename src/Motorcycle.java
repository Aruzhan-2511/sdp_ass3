public class Motorcycle extends Vehicle{
    public Motorcycle(ControlSystem controlSystem){
        super(controlSystem);
    }

    @Override
    public void drive() {
        System.out.println("Driving a motorcycle");
        controlSystem.control();
    }
}
