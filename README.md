# Assignment 3 – Bridge Design Pattern

## Car Control System

This project demonstrates the **Bridge Design Pattern** using a Car Control System.

The main purpose of the project is to separate two independent dimensions:

- Vehicle types
- Control systems

This allows different vehicles to work with different control systems without creating a separate class for every possible combination.

## Bridge Pattern Structure

### Abstraction – Vehicle

`Vehicle` is an abstract class that represents the abstraction side of the Bridge pattern.

It contains a reference to the `ControlSystem` interface:

```java
protected ControlSystem controlSystem;
```

The control system is passed through the constructor:

```java
public Vehicle(ControlSystem controlSystem) {
    this.controlSystem = controlSystem;
}
```

This reference creates the bridge between the vehicle hierarchy and the control system hierarchy.

### Refined Abstractions – Car and Motorcycle

`Car` and `Motorcycle` extend the `Vehicle` abstraction.

Both implement their own `drive()` method and use the connected control system:

```java
controlSystem.control();
```

Therefore, the vehicle does not need to know whether the control system is manual or automatic.

### Implementor – ControlSystem

`ControlSystem` is the Implementor interface.

```java
public interface ControlSystem {
    void control();
}
```

It defines the operation that all concrete control systems must implement.

### Concrete Implementors

The project contains two Concrete Implementors:

- `ManualControl`
- `AutomaticControl`

Both implement the `ControlSystem` interface and provide their own implementation of the `control()` method.

### Client – Main

The `Main` class creates and connects vehicles with different control systems.

For example:

```java
ControlSystem manual = new ManualControl();
ControlSystem automatic = new AutomaticControl();

Vehicle manualCar = new Car(manual);
Vehicle automaticCar = new Car(automatic);
Vehicle automaticMotorcycle = new Motorcycle(automatic);
```

The same `Car` abstraction can work with both manual and automatic control without changing the `Car` class.

## Project Structure

```text
src/
├── Vehicle.java
├── Car.java
├── Motorcycle.java
├── ControlSystem.java
├── ManualControl.java
├── AutomaticControl.java
└── Main.java
```

## Clean Code Requirements

### 1. Clear Separation of Abstraction-side vs. Implementation-side Responsibilities

The project clearly separates the two sides of the Bridge.

The abstraction side is responsible for vehicle behavior:

- `Vehicle`
- `Car`
- `Motorcycle`

The implementation side is responsible for the type of control:

- `ControlSystem`
- `ManualControl`
- `AutomaticControl`

The vehicle classes work through the `ControlSystem` interface instead of depending directly on a specific control implementation.

### 2. Meaningful Names Distinguishing Abstraction vs. Implementor Roles

The classes have simple and descriptive names.

For example:

- `Vehicle` represents a vehicle abstraction.
- `Car` and `Motorcycle` represent concrete vehicle types.
- `ControlSystem` clearly represents the control behavior.
- `ManualControl` and `AutomaticControl` clearly describe different control implementations.

This makes the role of each class easy to understand.

### 3. Small, Focused Classes on Both Sides of the Bridge

Each class has a small and specific responsibility.

`Vehicle` stores the control system and defines the `drive()` operation.

`Car` and `Motorcycle` describe how a specific vehicle drives.

`ManualControl` and `AutomaticControl` are responsible only for their specific control behavior.

This keeps the classes simple and focused.

### 4. No Duplicated Logic Between Concrete Implementors

Both concrete implementors follow the same `ControlSystem` interface.

The common contract is defined only once:

```java
void control();
```

`ManualControl` and `AutomaticControl` only contain the behavior specific to their own control type. The vehicle classes do not duplicate control-system selection logic.

### 5. Backward-Compatible Design

A new Concrete Implementor can be added without changing the `Vehicle`, `Car`, or `Motorcycle` classes.

For example, a new control system could be created:

```java
public class RemoteControl implements ControlSystem {
    @Override
    public void control() {
        System.out.println("Vehicle is controlled remotely.");
    }
}
```

It could then be connected to an existing vehicle:

```java
Vehicle car = new Car(new RemoteControl());
```

The existing abstraction classes do not need to be modified.

## Why Bridge Pattern Is Used

Without the Bridge pattern, separate classes could be required for every combination:

```text
ManualCar
AutomaticCar
ManualMotorcycle
AutomaticMotorcycle
```

With Bridge, the two hierarchies are separated:

```text
Vehicle                    ControlSystem
├── Car                    ├── ManualControl
└── Motorcycle             └── AutomaticControl
```

They are connected through composition:

```java
protected ControlSystem controlSystem;
```

As a result, vehicle types and control systems can vary independently.

## Conclusion

The Bridge Design Pattern separates the vehicle abstraction from the control system implementation.

In this project, `Vehicle` and `ControlSystem` form the two sides of the bridge. This design avoids unnecessary class combinations, keeps responsibilities separated, and makes it easier to add new vehicle types or control systems in the future.