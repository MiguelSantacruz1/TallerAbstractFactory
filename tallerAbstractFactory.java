import java.util.Scanner;

// 1. Abstract Products
interface Sensor { void detect(); }
interface Actuator { void actuate(); }
interface ControlSystem { void control(); }
interface PowerUnit { void supplyPower(); }

// 2. Concrete Products (Industrial)
class IndustrialSensor implements Sensor { public void detect() { System.out.println("Industrial high-precision sensor detecting"); } }
class IndustrialActuator implements Actuator { public void actuate() { System.out.println("Industrial robust actuator actuating"); } }
class IndustrialControlSystem implements ControlSystem { public void control() { System.out.println("Industrial automated control system running"); } }
class IndustrialPowerUnit implements PowerUnit { public void supplyPower() { System.out.println("Supplying stable industrial power"); } }

// 2. Concrete Products (Medical)
class MedicalSensor implements Sensor { public void detect() { System.out.println("Medical ultra-sensitive sensor detecting"); } }
class MedicalActuator implements Actuator { public void actuate() { System.out.println("Medical precise actuator actuating"); } }
class MedicalControlSystem implements ControlSystem { public void control() { System.out.println("Medical intelligent control system running"); } }
class MedicalPowerUnit implements PowerUnit { public void supplyPower() { System.out.println("Supplying safe medical power"); } }

// 2. Concrete Products (Home)
class HomeSensor implements Sensor { public void detect() { System.out.println("Basic home sensor detecting"); } }
class HomeActuator implements Actuator { public void actuate() { System.out.println("Simple home actuator actuating"); } }
class HomeControlSystem implements ControlSystem { public void control() { System.out.println("Basic home control system running"); } }
class HomePowerUnit implements PowerUnit { public void supplyPower() { System.out.println("Supplying standard home power"); } }

// 3. Abstract Factory
interface RobotFactory {
    Sensor createSensor();
    Actuator createActuator();
    ControlSystem createControlSystem();
    PowerUnit createPowerUnit();
}

// 4. Concrete Factories
class IndustrialRobotFactory implements RobotFactory {
    public Sensor createSensor() { return new IndustrialSensor(); }
    public Actuator createActuator() { return new IndustrialActuator(); }
    public ControlSystem createControlSystem() { return new IndustrialControlSystem(); }
    public PowerUnit createPowerUnit() { return new IndustrialPowerUnit(); }
}

class MedicalRobotFactory implements RobotFactory {
    public Sensor createSensor() { return new MedicalSensor(); }
    public Actuator createActuator() { return new MedicalActuator(); }
    public ControlSystem createControlSystem() { return new MedicalControlSystem(); }
    public PowerUnit createPowerUnit() { return new MedicalPowerUnit(); }
}

class HomeRobotFactory implements RobotFactory {
    public Sensor createSensor() { return new HomeSensor(); }
    public Actuator createActuator() { return new HomeActuator(); }
    public ControlSystem createControlSystem() { return new HomeControlSystem(); }
    public PowerUnit createPowerUnit() { return new HomePowerUnit(); }
}

// 5. Assembler
class RobotAssembler {
    private Sensor sensor;
    private Actuator actuator;
    private ControlSystem controlSystem;
    private PowerUnit powerUnit;

    public RobotAssembler(RobotFactory factory) {
        this.sensor = factory.createSensor();
        this.actuator = factory.createActuator();
        this.controlSystem = factory.createControlSystem();
        this.powerUnit = factory.createPowerUnit();
    }

    public void assembleRobot() {
        System.out.println("=== Assembling Robot ===");
        sensor.detect();
        actuator.actuate();
        controlSystem.control();
        powerUnit.supplyPower();
        System.out.println("Robot assembled successfully!\n");
    }
}

// 6. Main Class with User Selection
public class tallerAbstractFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of robot to assemble:");
        System.out.println("1. Industrial");
        System.out.println("2. Medical");
        System.out.println("3. Home");
        System.out.print("Option: ");

        int option = scanner.nextInt();
        RobotFactory factory;

        switch(option) {
            case 1:
                factory = new IndustrialRobotFactory();
                break;
            case 2:
                factory = new MedicalRobotFactory();
                break;
            case 3:
                factory = new HomeRobotFactory();
                break;
            default:
                System.out.println("Invalid option, assembling a Home robot by default.");
                factory = new HomeRobotFactory();
        }

        RobotAssembler assembler = new RobotAssembler(factory);
        assembler.assembleRobot();
        scanner.close();
    }
}