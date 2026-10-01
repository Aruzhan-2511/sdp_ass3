public class Car extends Vehicle{
    public Car(ControlSystem controlSystem){
        super(controlSystem);
    }
    public void drive(){
        System.out.println("Driving a car");
        controlSystem.control();
    }
}
