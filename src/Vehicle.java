public abstract class Vehicle {
    protected ControlSystem controlSystem;
    public Vehicle(ControlSystem controlSystem){
        this.controlSystem=controlSystem;
    }
    public abstract void drive();
}
