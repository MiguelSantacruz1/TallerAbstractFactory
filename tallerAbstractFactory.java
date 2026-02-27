import java.util.Scanner;

// 1. Productos Abstractos
interface Sensor { void detect(); }
interface Actuator { void actuate(); }
interface ControlSystem { void control(); }
interface PowerUnit { void supplyPower(); }

// 2. Productos Concretos (Familia Industrial)
class IndustrialSensor implements Sensor { public void detect() { System.out.println("Sensor industrial de alta precisión detectando"); } }
class IndustrialActuator implements Actuator { public void actuate() { System.out.println("Actuador industrial robusto actuando"); } }
class IndustrialControlSystem implements ControlSystem { public void control() { System.out.println("Sistema de control industrial automatizado funcionando"); } }
class IndustrialPowerUnit implements PowerUnit { public void supplyPower() { System.out.println("Suministrando energía industrial estable"); } }

// 2. Productos Concretos (Familia Médico)
class MedicalSensor implements Sensor { public void detect() { System.out.println("Sensor médico ultra sensible detectando"); } }
class MedicalActuator implements Actuator { public void actuate() { System.out.println("Actuador médico preciso actuando"); } }
class MedicalControlSystem implements ControlSystem { public void control() { System.out.println("Sistema de control médico inteligente funcionando"); } }
class MedicalPowerUnit implements PowerUnit { public void supplyPower() { System.out.println("Suministrando energía médica segura"); } }

// 2. Productos Concretos (Familia Doméstico)
class HomeSensor implements Sensor { public void detect() { System.out.println("Sensor doméstico básico detectando"); } }
class HomeActuator implements Actuator { public void actuate() { System.out.println("Actuador doméstico simple actuando"); } }
class HomeControlSystem implements ControlSystem { public void control() { System.out.println("Sistema de control doméstico básico funcionando"); } }
class HomePowerUnit implements PowerUnit { public void supplyPower() { System.out.println("Suministrando energía doméstica estándar"); } }

// 3. Fábrica Abstracta
interface RobotFactory {
    Sensor createSensor();
    Actuator createActuator();
    ControlSystem createControlSystem();
    PowerUnit createPowerUnit();
}

// 4. Fábricas Concretas
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

// 5. Ensamblador
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
        System.out.println("=== Ensamblando Robot ===");
        sensor.detect();
        actuator.actuate();
        controlSystem.control();
        powerUnit.supplyPower();
        System.out.println("Robot ensamblado correctamente!\n");
    }
}

// 6. Clase Principal con selección de usuario
public class tallerAbstractFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige el tipo de robot a ensamblar:");
        System.out.println("1. Industrial");
        System.out.println("2. Médico");
        System.out.println("3. Doméstico");
        System.out.print("Opción: ");

        int opcion = sc.nextInt();
        RobotFactory factory;

        switch(opcion) {
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
                System.out.println("Opción inválida, se ensamblará un robot doméstico por defecto.");
                factory = new HomeRobotFactory();
        }

        RobotAssembler assembler = new RobotAssembler(factory);
        assembler.assembleRobot();
        sc.close();
    }
}
